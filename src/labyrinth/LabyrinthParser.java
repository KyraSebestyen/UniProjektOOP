package labyrinth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Erstellt ein labyrinth aus einer Datei mit Knoten-Paaren.
 */
public class LabyrinthParser {

    /**
     * Liest Kanten aus Datei, erstellt Kreuzungen und verknuepft diese.
     * @param dateipfad Dateipfad
     * @return Labyrinth
     */
    public Labyrinth parse(String dateipfad){
        List<Kante> kanten = liesKantenAusDatei(dateipfad);
        Map<Integer, Kreuzung> kreuzungen = new HashMap<>();
        kanten.forEach(kante -> {
            Kreuzung ersteKreuzung = kreuzungen.getOrDefault(kante.ersterKnoten, new Kreuzung(kante.ersterKnoten));
            Kreuzung zweiteKreuzung = kreuzungen.getOrDefault(kante.zweiterKnoten, new Kreuzung(kante.zweiterKnoten));
            ersteKreuzung.addNachbarn(zweiteKreuzung);
            zweiteKreuzung.addNachbarn(ersteKreuzung);
            kreuzungen.put(kante.ersterKnoten, ersteKreuzung);
            kreuzungen.put(kante.zweiterKnoten, zweiteKreuzung);
        });
        return new Labyrinth(kreuzungen);
    }

    private List<Kante> liesKantenAusDatei(String dateipfad) {
        File file = new File(dateipfad);
        FileReader fileReader;
        try {
            List<Kante> kanten = new ArrayList<>();
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine())  != null){
                kanten.add(new Kante(line));
            }
            return kanten;
        } catch (IOException e) {
            throw new IllegalArgumentException("Datei konnte nicht korrekt gelesen werden!");
        }
    }

    private static class Kante {
        private final int ersterKnoten;
        private final int zweiterKnoten;

        private Kante(String zeile) {
            String[] knoten = zeile.split(" ");
            this.ersterKnoten = Integer.parseInt(knoten[0]);
            this.zweiterKnoten = Integer.parseInt(knoten[1]);
        }
    }
}
