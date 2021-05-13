package stillePost;

import java.util.List;

public class Mensch {
    protected Meinung meinung;

    public Mensch() {
        this.meinung = Meinung.KEINE_INFO;
    }

    public Feld waehleNeuesFeld(List<Feld> moeglicheRichtungen, Feld aktuellesFeld) {
        int richtungZufall = (int) (Math.random() * (moeglicheRichtungen.size() + 1));
        if (richtungZufall == moeglicheRichtungen.size()) {
            return aktuellesFeld;
        }
        return moeglicheRichtungen.get(richtungZufall);
    }

    public Meinung getMeinung() {
        return this.meinung;
    }

    public void setMeinung(Meinung meinung) {
        this.meinung = meinung;
    }
}
