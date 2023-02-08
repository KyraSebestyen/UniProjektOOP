package rsa8.src.rsa8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Liest den zu verschluesselnden Text aus einer Datei und bildet die Pruefsumme des Textes.
 */
public class Text {

    private String text;

    /**
     * Liest Zeile fuer Zeile aus der Datei am Pfad.
     * @param pfad Pfad der Datei, die gelesen werden soll
     */
    public Text(String pfad) {
        File file = new File(pfad);
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                sb.append(line).append(" ");
            }
            this.text = sb.toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * Berechnet die Pruefsumme des Texts.
     * @return Pruefsumme
     */
    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
