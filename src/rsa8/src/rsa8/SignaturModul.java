package rsa8.src.rsa8;

/**
 * Einstiegspunkt fuer die Verifizierung von Texten.
 */
public class SignaturModul {

    private final SchluesselPaar schluesselPaar;

    /**
     * Generiert ein Schluesselpaar mit den uebergebenen Primzahlen.
     * @param p Primzahl
     * @param q Primzahl
     */
    public SignaturModul(int p, int q) {
        SchluesselPaarGenerator schluesselPaarGenerator = new SchluesselPaarGenerator();
        this.schluesselPaar = schluesselPaarGenerator.generiere(p, q);
    }

    /**
     * Erstellt Signatur zum gegebenen Text.
     * @param text Text
     * @return Signatur
     */
    public int signiere(Text text){
        return schluesselPaar.getPrivaterSchluessel().signiere(text.hashCode());
    }

    /**
     * Verifiziert die Pruefsumme.
     * @param text Text
     * @param signatur Signatur
     * @return ob die Pruefsumme des Texts mit der Signatur uebereinstimmt
     */
    public boolean verifiziereText(Text text, int signatur){
        return schluesselPaar.getOeffentlicherSchluessel().verifizierePruefSumme(text.hashCode(), signatur);
    }
}
