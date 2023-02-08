package stillePost;

import java.util.ArrayList;
import java.util.List;

/**
 * Initialisiert das Spielfeld und startet ein Spiel.
 */

public class Spiel {
    private final int anzahlMenschen;
    private final int anzahlRunden;
    private final Spielfeld spielfeld;

    public Spiel(int anzahlMenschen, int anzahlRunden, int spielfeldGroesse) {
        this.anzahlMenschen = anzahlMenschen;
        this.anzahlRunden = anzahlRunden;

        GeruechtVerbreiter anton = new GeruechtVerbreiter(Meinung.HOCHZEIT);
        GeruechtDementierer berta = new GeruechtDementierer();

        List<Mensch> menschen = erstelleMenschen(anzahlMenschen);
        this.spielfeld = new Spielfeld(spielfeldGroesse, menschen, anton, berta);
    }

    private List<Mensch> erstelleMenschen(int anzahlMenschen) {
        List<Mensch> menschen = new ArrayList<>();
        for (int i = 0; i < anzahlMenschen - 2; i++) {
            Mensch mensch = new Mensch();
            menschen.add(mensch);
        }
        return menschen;
    }

    /**
     * Spielt die Anzahl an Runden und gibt eine Auswertung pro Runde.
     */
    public void starteSpiel() {
        System.out.println("Runde\tAnton\tBerta\tUnentschlossen");
        for (int runde = 1; runde <= anzahlRunden; runde++) {
            spielfeld.spieleEineRunde();
            spielauswertung(runde);
        }
    }

    private void spielauswertung(int runde) {
        Statistik statistik = spielfeld.statistik();
        double prozentHochzeit = statistik.getProzentHochzeit(anzahlMenschen);
        double prozentKeineHochzeit = statistik.getProzentKeineHochzeit(anzahlMenschen);
        double prozentUnentschlossen = statistik.getProzentUnentschlossen(anzahlMenschen);
        System.out.printf("%d\t\t%.2f%%\t%.2f%%\t%.2f%%\n", runde, prozentHochzeit, prozentKeineHochzeit, prozentUnentschlossen);
    }
}
