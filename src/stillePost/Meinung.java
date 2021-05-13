package stillePost;

import java.util.List;

public enum Meinung {
    HOCHZEIT, KEINE_HOCHZEIT, UNENTSCHLOSSEN;

    public static Meinung meinungsfindung(List<Meinung> meinungen) {
        int hochzeitCount = 0;
        int keineHochzeitCount = 0;

        for (Meinung meinung : meinungen) {
            if (meinung == HOCHZEIT) {
                hochzeitCount++;
            } else if (meinung == KEINE_HOCHZEIT) {
                keineHochzeitCount++;
            }
        }
        if (hochzeitCount > keineHochzeitCount) {
            return HOCHZEIT;
        }
        if (keineHochzeitCount > hochzeitCount) {
            return KEINE_HOCHZEIT;
        }
        return UNENTSCHLOSSEN;
    }
}
