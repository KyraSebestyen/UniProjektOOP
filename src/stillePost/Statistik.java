package stillePost;

/**
 * Erstellt Statistik fuer die Ausgabe nach jeder Runde.
 */

public class Statistik {
    private final int anzahlHochzeit;
    private final int anzahlKeineHochzeit;
    private final int anzahlUnentschlossen;

    public Statistik(int anzahlHochzeit, int anzahlKeineHochzeit, int anzahlUnentschlossen) {
        this.anzahlHochzeit = anzahlHochzeit;
        this.anzahlKeineHochzeit = anzahlKeineHochzeit;
        this.anzahlUnentschlossen = anzahlUnentschlossen;
    }

    /**
     * Errechnet den Prozentanteil der Menschen, die die Meinung HOCHZEIT haben.
     * @param anzahlMenschen Anzahl der Menschen
     * @return Prozentanteil der Meinung HOCHZEIT
     */
    public double getProzentHochzeit(int anzahlMenschen) {
        return 100.0 * anzahlHochzeit / anzahlMenschen;
    }

    /**
     * Errechnet den Prozentanteil der Menschen, die die Meinung KEINE_HOCHZEIT haben.
     * @param anzahlMenschen Anzahl der Menschen
     * @return Prozentanteil der Meinung KEINE_HOCHZEIT
     */
    public double getProzentKeineHochzeit(int anzahlMenschen) {
        return 100.0 * anzahlKeineHochzeit / anzahlMenschen;
    }

    /**
     * Errechnet den Prozentanteil der Menschen, die die Meinung UNENTSCHLOSSEN haben.
     * @param anzahlMenschen Anzahl der Menschen
     * @return Prozentanteil der Meinung UNENTSCHLOSSEN
     */
    public double getProzentUnentschlossen(int anzahlMenschen) {
        return 100.0 * anzahlUnentschlossen / anzahlMenschen;
    }
}
