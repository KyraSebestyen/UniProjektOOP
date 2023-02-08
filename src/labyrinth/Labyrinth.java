package labyrinth;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Repraesentiert das Labyrinth bzw. den Graph.
 */
public class Labyrinth {
    private final Map<Integer, Kreuzung> kreuzungen;

    /**
     * Erstellt ein Labyrinth.
     * @param kreuzungen Kreuzungen
     */
    public Labyrinth(Map<Integer, Kreuzung> kreuzungen) {
        this.kreuzungen = kreuzungen;
    }

    /**
     * Findet alle Wege, die vom Start zum Ziel fuehren.
     * @param idStart Start-Kreuzung
     * @param idEnde Ziel-Kreuzung
     * @return alle Wege, die vom Start zum Ziel fuehren.
     */
    public List<Weg> findeWege(int idStart, int idEnde){
        return findeWege(idStart, idEnde, new Weg());
    }

    private List<Weg> findeWege(int idStart, int idEnde, Weg bisherigerWeg){
        Kreuzung start = kreuzungen.get(idStart);
        //Abbruchbedingung: Ziel erreicht
        if(start.getId() == idEnde){
            return List.of(bisherigerWeg.verlaengereWeg(start));
        }
        List<Kreuzung> nachbarn = start.getNachbarn();
        return nachbarn.stream()
                //filter bereits besuchte Kreuzungen raus
                .filter(nachbar -> !(bisherigerWeg.liegtAufDemWeg(nachbar)))
                //nimmt jeden Stream und verbindet sie miteinander -> eine große Liste
                //finde rekursiv alle Wege, die vom aktuellen Knoten bis zum Ende gehen
                .flatMap(nachbar -> findeWege(nachbar.getId(), idEnde, bisherigerWeg.verlaengereWeg(start)).stream())
                //filter alle Wege raus, die nicht zum Ziel führen
                .filter(weg -> weg.endetImZiel(idEnde))
                .collect(Collectors.toList());
    }
}
