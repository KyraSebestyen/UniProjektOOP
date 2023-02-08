package stillePost;

/**
 * Verbreitet ein Geruecht und bleibt bei seiner Meinung.
 */
public class GeruechtVerbreiter extends Mensch {

    public GeruechtVerbreiter(Meinung meinung) {
        super();
        this.meinung = meinung;
    }

    /**
     * Verhindert die Aenderung der Meinung.
     * @param meinung Meinung
     */
    @Override
    public void setMeinung(Meinung meinung) {
    }
}
