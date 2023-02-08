package stillePost;

/**
 * Dementiert ein Geruecht sobald er davon erfaehrt.
 */
public class GeruechtDementierer extends Mensch {

    public GeruechtDementierer() {
        super();
        this.meinung = Meinung.GERUECHT_DEMENTIERER_KEINE_INFO;
    }

    /**
     * Sobald versucht wird, die Meinung auf etwas anderes zu setzen als auf KEINE_INFO, wird die Meinung auf das Gegengeruecht gesetzt.
     * @param meinung Meinung
     */
    @Override
    public void setMeinung(Meinung meinung) {
        if(meinung != Meinung.KEINE_INFO){
           this.meinung = Meinung.KEINE_HOCHZEIT;
        }
    }
}
