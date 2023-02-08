package rsa8.src.rsa8;

import java.util.Random;

/**
 * Erstellt ein zusammengehoeriges Schluesselpaar aus einem oeffentlichen und einem privaten Schluessel.
 */
public class SchluesselPaarGenerator {

    /**
     * Generiert ein Schluesselpaar mit uebereinstimmender Generatorzahl.
     * @param p Primzahl
     * @param q Primzahl
     * @return neues Schluesselpaar
     */
    public SchluesselPaar generiere(int p, int q){
        int generatorZahl = p * q;
        int euklidisch = (p-1) * (q-1);
        int exponent = generiereExponent(euklidisch);
        int d = generiereD(exponent, euklidisch);
        return new SchluesselPaar(generatorZahl, exponent, d);
    }

    private int generiereExponent(int euklidisch) {
        int exponent;
        do {
            Random random = new Random();
            exponent = random.nextInt(euklidisch);
        } while ((exponent <= 1) || (ggT(exponent, euklidisch) != 1));
        return exponent;
    }

    private int ggT(int a, int b) {
        if (b==0) return a;
        return ggT(b, a % b);
    }

    private int generiereD(int exponent, int euklidisch){
        Random random = new Random();
        int d;
        do {
            d = random.nextInt(euklidisch);
        } while ((d <= 1) || ((exponent * d) % euklidisch != 1));
        return d;
    }

}
