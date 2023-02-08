package labyrinth;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LabyrinthParser parser = new LabyrinthParser();
        Labyrinth labyrinth = parser.parse("labyrinth-1.graph.txt");
        List<Weg> wege = labyrinth.findeWege(72, 70);
        System.out.println("Ich habe " + wege.size() + " Wege gefunden:");
        System.out.println(wege.stream()
                .map(Weg::toString)
                .collect(Collectors.joining("\n")));

        Labyrinth labyrinth2 = parser.parse("labyrinth-2.graph.txt");
        List<Weg> wege2 = labyrinth2.findeWege(129, 74);
        System.out.println("Ich habe " + wege2.size() + " Wege gefunden:");
        System.out.println(wege2.stream()
                .map(Weg::toString)
                .collect(Collectors.joining("\n")));
    }
}
