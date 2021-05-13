package stillePost;

import java.util.ArrayList;
import java.util.List;

public class Spiel {
    public static void main(String[] args) {

        List<Mensch> menschen = new ArrayList<>();

        Spielfeld spielfeld = new Spielfeld(4);
        GeruechtVerbreiter anton = new GeruechtVerbreiter(Meinung.HOCHZEIT);
        GeruechtDementierer berta = new GeruechtDementierer();

        int anzahlMenschen = 10;
        int anzahlRunden = 10;

        for (int i = 0; i < anzahlMenschen - 2; i++) {
            Mensch mensch = new Mensch();
            menschen.add(mensch);
        }

        spielfeld.platziereMenschen(menschen);
        spielfeld.platziereGeruechteVerbreiter(anton, berta);

        System.out.println("Runde\tAnton\tBerta\tUnentschlossen");
        for (int i = 1; i <= anzahlRunden; i++) {
            spielfeld.menschenBewegen();
            spielfeld.meinungenUpdaten();
            double prozentHochzeit = 100.0 * spielfeld.statistik().get(Meinung.HOCHZEIT) / anzahlMenschen;
            double prozentKeineHochzeit = 100.0 * spielfeld.statistik().get(Meinung.KEINE_HOCHZEIT) / anzahlMenschen;
            double prozentUnentschlossen = 100.0 * spielfeld.statistik().get(Meinung.UNENTSCHLOSSEN) / anzahlMenschen;
            System.out.println(i + "\t" + prozentHochzeit + "%\t" + prozentKeineHochzeit + "%\t" + prozentUnentschlossen + "%");
        }

    }
}
