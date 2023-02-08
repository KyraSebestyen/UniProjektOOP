package stillePost;

import java.util.List;

/**
 * Stellt alle moeglichen Auspraegungen von Meinung von Menschen im Spiel bereit.
 */
public enum Meinung {
    HOCHZEIT, KEINE_HOCHZEIT, UNENTSCHLOSSEN, KEINE_INFO, GERUECHT_DEMENTIERER_KEINE_INFO;

    /**
     * Findet in der gegebenen Liste die vorherrschende Meinung, bei Gleichstand wird UNENTSCHLOSSEN zurueckgegeben.
     * @param meinungen Meinungen
     * @return die vorherrschende Meinung
     */
    public static Meinung meinungsfindung(List<Meinung> meinungen) {
        int hochzeitCount = 0;
        int keineHochzeitCount = 0;
        int unentschlossenCount = 0;
        int bertaKICount = 0;

        for (Meinung meinung : meinungen) {
            if (meinung == HOCHZEIT) {
                hochzeitCount++;
            } else if (meinung == KEINE_HOCHZEIT) {
                keineHochzeitCount++;
            } else if (meinung == UNENTSCHLOSSEN){
                unentschlossenCount++;
            } else if (meinung == GERUECHT_DEMENTIERER_KEINE_INFO){
                bertaKICount++;
            }
        }
        //falls Berta auf dem Feld ist und ein anderer Mensch das Gerücht schon einmal gehört hat, dementiert Berta
        if((bertaKICount > 0) && (hochzeitCount + unentschlossenCount > 0)){
            keineHochzeitCount++;
        }
        if (hochzeitCount > keineHochzeitCount) {
            return HOCHZEIT;
        }
        if (keineHochzeitCount > hochzeitCount) {
            return KEINE_HOCHZEIT;
        }
        //irgendwer, der schon einmal von HOCHZEIT gehört hat
        if(hochzeitCount + keineHochzeitCount + unentschlossenCount > 0){
            return UNENTSCHLOSSEN;
        }
        return KEINE_INFO;
    }
}
