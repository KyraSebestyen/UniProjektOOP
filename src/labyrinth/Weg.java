package labyrinth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repraesentiert einen Weg im Labyrinth bzw. einen Pfad im Graph.
 */
public class Weg {
    private final List<Kreuzung> kreuzungen = new ArrayList<>();

    /**
     * Ueberprueft ob die gegebene Kreuzung bereits Teil des Wegs ist.
     * @param kreuzung Kreuzung
     * @return ob die Kreuzung Teil des Wegs ist
     */
    public boolean liegtAufDemWeg(Kreuzung kreuzung){
        return kreuzungen.contains(kreuzung);
    }

    /**
     * Haengt gegebene Kreuzung an den bisherigen Weg an.
     * @param kreuzung Kreuzung
     * @return neuer Weg inklusive gegebener Kreuzung
     */
    public Weg verlaengereWeg(Kreuzung kreuzung){
        Weg weg = new Weg();
        weg.kreuzungen.addAll(kreuzungen);
        weg.kreuzungen.add(kreuzung);
        return weg;
    }

    /**
     * Ueberprueft ob der Weg im Ziel endet.
     * @param ziel Zielkreuzung
     * @return ob der Weg im Ziel endet.
     */
    public boolean endetImZiel(int ziel){
        return kreuzungen.get(kreuzungen.size()-1).getId() == ziel;
    }

    @Override
    public String toString() {
        return kreuzungen.stream()
                .map(kreuzung -> Integer.toString(kreuzung.getId()))
                .collect(Collectors.joining("-"));
    }
}
