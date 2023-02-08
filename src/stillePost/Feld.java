package stillePost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Stellt ein Feld auf dem Spielfeld dar.
 */
public class Feld {

    private final List<Feld> nachbarn = new ArrayList<>();
    private final List<Mensch> menschen = new ArrayList<>();

    /**
     * Fuegt gegebenen Nachbarn zur Liste von Nachbarn hinzu
     * @param nachbar Nachbar
     */
    public void addNachbar(Feld nachbar) {
        this.nachbarn.add(nachbar);
    }

    /**
     * Laesst Menschen auf ein neues Feld laufen.
     * @return Zuordnung aller Menschen zu einem neuen Feld.
     */
    public Map<Mensch, Feld> lassMenschenLaufen() {
        Map<Mensch, Feld> neueFelder = new HashMap<>();
        menschen.forEach(mensch -> {
            Feld neuesFeld = mensch.waehleNeuesFeld(nachbarn, this);
            neueFelder.put(mensch, neuesFeld);
        });
        return neueFelder;
    }

    /**
     * Fuegt gegebenen Menschen zur Liste von Menschen auf dem Feld hinzu.
     * @param mensch Mensch
     */
    public void addMensch(Mensch mensch) {
        this.menschen.add(mensch);
    }

    /**
     * Loescht alle Einträge aus der Liste von Menschen
     */
    public void clearMenschen() {
        this.menschen.clear();
    }

    /**
     * Ermittelt die Verteilung der Meinungen.
     * @return Gibt die Verteilung der verschiedenen Meinungen zurueck.
     */
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

    /**
     * Ermittelt vorherrschende Meinung und setzt diese für alle Menschen auf dem Feld.
     */
    public void updateMeinungen() {
        Meinung vorherrschendeMeinung = Meinung.meinungsfindung(menschen.stream()
                .map(Mensch::getMeinung)
                .collect(Collectors.toList()));
        menschen.forEach(mensch -> mensch.setMeinung(vorherrschendeMeinung));
    }
}
