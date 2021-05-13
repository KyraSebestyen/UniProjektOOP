package stillePost;

import java.util.HashMap;
import java.util.Map;

public class Statistik {
    private int hochzeit;
    private int keineHochzeit;
    private int unentschlossen;
    private int anzahlMenschen;

    private double anteil(int anteil) {
        return 1.0 * anteil / this.anzahlMenschen;
    }

    private double anteilHochzeit() {
        return anteil(hochzeit);
    }

    private double anteilKeineHochzeit() {
        return anteil(keineHochzeit);
    }

    private double anteilUnentschlossen() {
        return anteil(unentschlossen);
    }

    public Map<Meinung, Double> erstelleStatistik() {
        Map<Meinung, Double> anteile = new HashMap<>();
        anteile.put(Meinung.HOCHZEIT, anteilHochzeit());
        anteile.put(Meinung.KEINE_HOCHZEIT, anteilKeineHochzeit());
        anteile.put(Meinung.UNENTSCHLOSSEN, anteilUnentschlossen());
        return anteile;
    }


}
