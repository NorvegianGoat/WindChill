package windchill.game.model.items;

/**
 * Modella l'oggetto ciaspole e contiene le caratteristiche che conferisce al giocatore nel momento in cui 
 * viene donato al giocatore
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Ciaspole extends InGameObject{
    
    /**
     * Il costruttore di default di ciaspole inizializza i le caratteristiche base 
     * di questo oggetto
     */
    public Ciaspole() {
        super.forza = +0;
        super.intelligenza = +0;
        super.agilita=+4;
        super.resistenzaAlFreddo=+1;
        super.puntiVita=+0;
    }

    @Override
    public void stampaBenefici() {
        System.out.println("Le ciaspole permettono di cammiare sulla neve");
    }
    
}