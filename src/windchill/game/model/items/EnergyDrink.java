package windchill.game.model.items;

/**
 * Modella l'oggetto Energy drink e contiene le caratteristiche che conferisce al giocatore nel momento in cui 
 * viene donato al giocatore
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class EnergyDrink extends InGameObject{
    
     /**
     * Il costruttore di default di Energy Drink inizializza i le caratteristiche base 
     * di questo oggetto
     */
    public EnergyDrink() {
        super.forza = +3;
        super.intelligenza = -1;
        super.agilita=+3;
        super.resistenzaAlFreddo=+2;
        super.puntiVita=-3;
    }

    @Override
    public void stampaBenefici() {
        System.out.println("L'energy drink ti premette di essere piu' reattivo");
    }
    
}