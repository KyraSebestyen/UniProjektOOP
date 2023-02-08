package rsa8.src.rsa8;

/**
 * Repraesentiert ein Paar bestehend aus einem oeffentlichen und einem privaten Schluessel.
 */
public class SchluesselPaar {

    private final PrivaterSchluessel privaterSchluessel;
    private final OeffentlicherSchluessel oeffentlicherSchluessel;

    /**
     * Erstellt einen oeffentlichen und einen privaten Schluessel mit derselben Generatorzahl.
     * @param generatorZahl Generatorzahl
     * @param exponent Exponent
     * @param d d
     */
    public SchluesselPaar(int generatorZahl, int exponent, int d) {
        this.privaterSchluessel = new PrivaterSchluessel(generatorZahl, d);
        this.oeffentlicherSchluessel = new OeffentlicherSchluessel(generatorZahl, exponent);
    }

    /**
     * Gibt den privaten Schluessel zurueck.
     * @return privater Schluessel
     */
    public PrivaterSchluessel getPrivaterSchluessel() {
        return privaterSchluessel;
    }

    /**
     * Gibt den oeffentlichen Schluessel zurueck.
     * @return oeffentlicher Schluessel
     */
    public OeffentlicherSchluessel getOeffentlicherSchluessel() {
        return oeffentlicherSchluessel;
    }
}
