package windchill.game.model.items;

/**
 * Modella l'oggetto cioccolata e contiene le caratteristiche che conferisce al giocatore nel momento in cui 
 * viene donato al giocatore
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Cioccolata extends InGameObject{
    
    /**
     * Il costruttore di default di ciaspole inizializza i le caratteristiche base 
     * di questo oggetto
     */
    public Cioccolata() {
        super.forza = +1;
        super.intelligenza = +0;
        super.agilita=+2;
        super.resistenzaAlFreddo=+1;
        super.puntiVita=+2;
    }

    @Override
    public void stampaBenefici() {
        System.out.println("La cioccolata ti permette di resistere un po'piu' a lungo");
    }
    
}