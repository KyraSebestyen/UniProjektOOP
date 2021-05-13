package stillePost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Feld {

    private List<Feld> nachbarn = new ArrayList<>();
    private List<Mensch> menschen = new ArrayList<>();

    public void addNachbar(Feld nachbar) {
        this.nachbarn.add(nachbar);
    }

    public Map<Mensch, Feld> lassMenschenLaufen() {
        Map<Mensch, Feld> neueFelder = new HashMap<>();
        menschen.forEach(mensch -> {
            Feld neuesFeld = mensch.waehleNeuesFeld(nachbarn, this);
            neueFelder.put(mensch, neuesFeld);
        });
        return neueFelder;
    }

    public void addMensch(Mensch mensch) {
        this.menschen.add(mensch);
    }

    public void clearMenschen() {
        this.menschen.clear();
    }

    public Map<Meinung, Integer> meinungsFindung() {
        Map<Meinung, Integer> meinungen = new HashMap<>();
        int hochzeit = 0;
        int keineHochzeit = 0;
        int unentschlossen = 0;
        for (Mensch mensch : menschen) {
            if (mensch.meinung == Meinung.HOCHZEIT) {
                hochzeit++;
            } else if (mensch.meinung == Meinung.KEINE_HOCHZEIT) {
                keineHochzeit++;
            } else {
                unentschlossen++;
            }
        }
        meinungen.put(Meinung.HOCHZEIT, hochzeit);
        meinungen.put(Meinung.KEINE_HOCHZEIT, keineHochzeit);
        meinungen.put(Meinung.UNENTSCHLOSSEN, unentschlossen);
        return meinungen;
    }

    public void updateMeinungen() {
        Meinung vorherrschendeMeinung = Meinung.meinungsfindung(menschen.stream()
                .map(Mensch::getMeinung)
                .collect(Collectors.toList()));
        menschen.forEach(mensch -> mensch.setMeinung(vorherrschendeMeinung));
    }
}
