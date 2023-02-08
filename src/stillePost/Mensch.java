package stillePost;

import java.util.List;

/**
 * Darstellung einer Spielfigur im Spiel, hat eine veraenderbare Meinung und waehlt (zufaellig) die Richtung, in die er sich fortbewegt.
 */
public class Mensch {
    protected Meinung meinung;

    /**
     * Initialisiert einen Menschen mit der Meinung KEINE_INFO.
     */
    public Mensch() {
        this.meinung = Meinung.KEINE_INFO;
    }

    /**
     * Waehlt zufaellig das Feld, auf welches Mensch sich bewegt.
     * @param moeglicheRichtungen alle angrenzenden Felder
     * @param aktuellesFeld Feld, auf dem Mensch derzeit steht
     * @return neu gewaehltes Feld
     */
    public Feld waehleNeuesFeld(List<Feld> moeglicheRichtungen, Feld aktuellesFeld) {
        int richtungZufall = (int) (Math.random() * (moeglicheRichtungen.size() + 1));
        if (richtungZufall == moeglicheRichtungen.size()) {
            return aktuellesFeld;
        }
        return moeglicheRichtungen.get(richtungZufall);
    }

    /**
     * Gibt die Meinung zurück
     * @return die aktuelle Meinung
     */
    public Meinung getMeinung() {
        return this.meinung;
    }

    /**
     * Aendert die Meinung
     * @param meinung Meinung
     */
    public void setMeinung(Meinung meinung) {
        this.meinung = meinung;
    }
}
