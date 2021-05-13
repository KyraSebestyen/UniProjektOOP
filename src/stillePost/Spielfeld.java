package stillePost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Spielfeld {
    private final int feldAnzahl;
    private Feld[][] felder;

    public Spielfeld(int feldAnzahl) {
        this.felder = new Feld[feldAnzahl][feldAnzahl];
        this.feldAnzahl = feldAnzahl;
        erstelleNachbarn();
    }

    private void erstelleNachbarn() {
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

    public void platziereMenschen(List<Mensch> menschen) {
        menschen.forEach(mensch -> {
            int zufallsZeile = (int) (Math.random() * feldAnzahl);
            int zufallsSpalte = (int) (Math.random() * feldAnzahl);
            felder[zufallsZeile][zufallsSpalte].addMensch(mensch);
        });
    }

    public void platziereGeruechteVerbreiter(GeruechtVerbreiter anton, GeruechtDementierer berta) {
        felder[feldAnzahl - 1][feldAnzahl - 1].addMensch(berta);
        felder[0][0].addMensch(anton);
    }

    public Feld[][] getFelder() {
        return felder;
    }

    public void menschenBewegen() {
        Map<Mensch, Feld> menschenAufFeldern = new HashMap<>();
        iteriereDurchAlleFelder(feld -> {
            menschenAufFeldern.putAll(feld.lassMenschenLaufen());
            feld.clearMenschen();
        });
        menschenAufFeldern.forEach((mensch, feld) -> {
            feld.addMensch(mensch);
        });
    }

    public void meinungenUpdaten() {
        iteriereDurchAlleFelder(Feld::updateMeinungen);
    }

    public Map<Meinung, Integer> statistik() {
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
        Map<Meinung, Integer> alleMeinungen = new HashMap<>();
        alleMeinungen.put(Meinung.UNENTSCHLOSSEN, unentschlossenCount);
        alleMeinungen.put(Meinung.KEINE_HOCHZEIT, keineHochzeitCount);
        alleMeinungen.put(Meinung.HOCHZEIT, hochzeitCount);
        return alleMeinungen;
    }


    private void iteriereDurchAlleFelder(Consumer<Feld> feldConsumer) {
        for (int zeile = 0; zeile < this.feldAnzahl; zeile++) {
            for (int spalte = 0; spalte < this.feldAnzahl; spalte++) {
                feldConsumer.accept(felder[zeile][spalte]);
            }
        }
    }
}
