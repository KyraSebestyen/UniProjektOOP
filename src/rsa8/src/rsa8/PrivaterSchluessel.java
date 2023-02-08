package rsa8.src.rsa8;

import java.math.BigInteger;

/**
 * Wird eingesetzt, um die Signatur fuer einen Text zu erstellen.
 */
public class PrivaterSchluessel {

    private final int generatorZahl;
    private final int d;

    /**
     * Erstellt einen privaten Schluessel aus gegebener Generatorzahl und d.
     * @param generatorZahl Generatorzahl
     * @param d d
     */
    public PrivaterSchluessel(int generatorZahl, int d) {
        this.generatorZahl = generatorZahl;
        this.d = d;
    }

    /**
     * Erstellt eine Signatur fuer eine gegebene Pruefsumme.
     * @param pruefSumme zu signierende Pruefsumme
     * @return Signatur
     */
   public int signiere(int pruefSumme){
       return BigInteger.valueOf(pruefSumme).pow(d).mod(BigInteger.valueOf(generatorZahl)).intValue();
   }

}
