package stillePost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Stellt das Spielfeld dar und bietet alle Funktionen um Spielzuege durchzufuehren.
 */
public class Spielfeld {
    private final int feldAnzahl;
    private final Feld[][] felder;

    /**
     * Initialisiert Spielfeld mit gegebener Anzahl an Feldern und erstellt für jedes Feld die gueltigen Nachbarn,
     * platziert die Menschen zufaellig.
     * @param feldAnzahl Anzahl der Zeilen und Spalten
     * @param menschen Liste der Menschen
     * @param geruechtVerbreiter Anton
     * @param geruechtDementierer Berta
     */
    public Spielfeld(int feldAnzahl, List<Mensch> menschen, GeruechtVerbreiter geruechtVerbreiter, GeruechtDementierer geruechtDementierer) {
        this.felder = new Feld[feldAnzahl][feldAnzahl];
        this.feldAnzahl = feldAnzahl;
        initialisiereFelder();
        platziereMenschen(menschen, geruechtVerbreiter, geruechtDementierer);
    }

    private void initialisiereFelder() {
        for (int zeile = 0; zeile < feldAnzahl; zeile++) {
            for (int spalte = 0; spalte < feldAnzahl; spalte++) {
                Feld feld = new Feld();
                felder[zeile][spalte] = feld;
                if (spalte > 0) {
                    Feld linkerNachbar = felder[zeile][spalte - 1];
                    linkerNachbar.addNachbar(feld);
                    feld.addNachbar(linkerNachbar);
                }
                if (zeile > 0) {
                    Feld obererNachbar = felder[zeile - 1][spalte];
                    obererNachbar.addNachbar(feld);
                    feld.addNachbar(obererNachbar);
                }
            }
        }
    }

    private void platziereMenschen(List<Mensch> menschen, GeruechtVerbreiter geruechtVerbreiter, GeruechtDementierer geruechtDementierer) {
        menschen.forEach(mensch -> {
            int zufallsZeile = (int) (Math.random() * feldAnzahl);
            int zufallsSpalte = (int) (Math.random() * feldAnzahl);
            felder[zufallsZeile][zufallsSpalte].addMensch(mensch);
        });
        felder[0][0].addMensch(geruechtVerbreiter);
        felder[feldAnzahl - 1][feldAnzahl - 1].addMensch(geruechtDementierer);
    }


    /**
     * Bewegt Menschen und updatet die Meinungen
     */
    public void spieleEineRunde(){
        menschenBewegen();
        meinungenUpdaten();
    }

    private void menschenBewegen() {
        Map<Mensch, Feld> menschenAufFeldern = new HashMap<>();
        iteriereDurchAlleFelder(feld -> {
            menschenAufFeldern.putAll(feld.lassMenschenLaufen());
            feld.clearMenschen();
        });
        menschenAufFeldern.forEach((mensch, feld) -> {
            feld.addMensch(mensch);
        });
    }

    private void meinungenUpdaten() {
        iteriereDurchAlleFelder(Feld::updateMeinungen);
    }

    /**
     * Zaehlt die Meinungen auf allen Feldern
     * @return Gibt zurueck, wie viele Menschen welcher Meinung sind.
     */
    public Statistik statistik() {
        int hochzeitCount = 0;
        int keineHochzeitCount = 0;
        int unentschlossenCount = 0;

        for (int zeile = 0; zeile < feldAnzahl; zeile++) {
            for (int spalte = 0; spalte < feldAnzahl; spalte++) {
                Map<Meinung, Integer> meinungen = felder[zeile][spalte].meinungsFindung();
                hochzeitCount += meinungen.get(Meinung.HOCHZEIT);
                keineHochzeitCount += meinungen.get(Meinung.KEINE_HOCHZEIT);
                unentschlossenCount += meinungen.get(Meinung.UNENTSCHLOSSEN);
            }
        }

        return new Statistik(hochzeitCount, keineHochzeitCount, unentschlossenCount);
    }

    private void iteriereDurchAlleFelder(Consumer<Feld> feldConsumer) {
        for (int zeile = 0; zeile < this.feldAnzahl; zeile++) {
            for (int spalte = 0; spalte < this.feldAnzahl; spalte++) {
                feldConsumer.accept(felder[zeile][spalte]);
            }
        }
    }
}
