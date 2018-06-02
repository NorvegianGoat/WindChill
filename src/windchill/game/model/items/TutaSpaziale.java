package windchill.game.model.items;

/**
 * Modella l'oggetto tuta spaziale e contiene le caratteristiche che conferisce al giocatore nel momento in cui 
 * viene donato al giocatore
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class TutaSpaziale extends InGameObject{
    
    /**
    * Il costruttore di default di ciaspole inizializza i le caratteristiche base 
    * di questo oggetto
    */
    public TutaSpaziale() {
        super.forza = +7;
        super.intelligenza = +4;
        super.agilita=+6;
        super.resistenzaAlFreddo=+7;
        super.puntiVita=+4;
    }

    @Override
    public void stampaBenefici() {
        System.out.println("La tuta spaziale ti rende incredibilmente potente!");
    }
}