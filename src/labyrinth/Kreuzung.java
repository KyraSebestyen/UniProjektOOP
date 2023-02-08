package labyrinth;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprasentiert eine Kreuzung im Labyrinth bzw. einen Knoten im Graph.
 */
public class Kreuzung {
    private final List<Kreuzung> nachbarn = new ArrayList<>();
    private final int id;

    /**
     * Erstellt eine Kreuzung.
     * @param id ID
     */
    public Kreuzung(int id) {
        this.id = id;
    }

    /**
     * Fuegt einen Nachbarn hinzu.
     * @param neuerNachbar neuer Nachbar
     */
    public void addNachbarn(Kreuzung neuerNachbar){
        this.nachbarn.add(neuerNachbar);
    }

    /**
     * Gibt alle Nachbarn zurueck.
     * @return alle Nachbarn
     */
    public List<Kreuzung> getNachbarn() {
        return nachbarn;
    }

    /**
     * Gibt ID zurueck.
     * @return ID
     */
    public int getId() {
        return id;
    }
}
