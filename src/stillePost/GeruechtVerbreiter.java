package stillePost;

public class GeruechtVerbreiter extends Mensch {

    public GeruechtVerbreiter(Meinung meinung) {
        super();
        this.meinung = meinung;
    }

    @Override
    public void setMeinung(Meinung meinung) {
        //mach nichts, bleibt immer bei Meinung
    }
}
