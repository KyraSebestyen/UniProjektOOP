package rsa8.src.rsa8;

/**
 * Erstellung des Schluesselpaars, Uebergeben des zu verschluesselnden Textes und Ueberpruefung der Signatur.
 */
public class Main {
    private static SignaturModul signaturModul;
    private static Text text;

    public static void main(String[] args) {
        signaturModul = new SignaturModul(13, 17);
        text = new Text("Gedicht.txt");
        int signatur = signiere();
        pruefeSignatur(signatur);
    }

    private static int signiere(){
        int signatur = signaturModul.signiere(text);
        System.out.println("Signatur ist " + signatur);
        return signatur;
    }

    private static void pruefeSignatur(int signatur){
        boolean pruefSummeVerifiziert = signaturModul.verifiziereText(text, signatur);
        if(pruefSummeVerifiziert){
            System.out.println("Passt!");
        } else {
            System.out.println("Nope!");
        }
    }
}
