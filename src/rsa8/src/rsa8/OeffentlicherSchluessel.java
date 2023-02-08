package rsa8.src.rsa8;

import java.math.BigInteger;

/**
 * Kann eingesetzt werden um eine mit dem passenden privaten Schluessel verschluesselte Nachricht zu entschluesseln.
 */
public class OeffentlicherSchluessel{

    private final BigInteger generatorZahl;
    private final int exponent;

    /**
     * Erstellt einen oeffentlichen Schluessel aus der Generatorzahl und dem Exponenten.
     * @param generatorZahl Generatorzahl
     * @param exponent Exponent
     */
    public OeffentlicherSchluessel(int generatorZahl, int exponent) {
        this.generatorZahl = BigInteger.valueOf(generatorZahl);
        this.exponent = exponent;
    }

    /**
     * Ueberprueft, ob die Pruefsumme und die Signatur das gleiche Objekt beschreiben.
     * @param pruefSumme Pruefsumme
     * @param signatur Signatur
     * @return Ob die Verifizierung erfolgreich war.
     */
    public boolean verifizierePruefSumme(int pruefSumme, int signatur){
        return BigInteger.valueOf(signatur).pow(exponent).mod(generatorZahl)
                .equals(BigInteger.valueOf(pruefSumme).mod(generatorZahl));
    }
}
