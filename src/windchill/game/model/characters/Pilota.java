package windchill.game.model.characters;

import windchill.game.model.items.EnergyDrink;
import windchill.game.model.Player;

/**
 * Modella il pilota e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Pilota extends NPC{
    
    /**
    * Il costruttore di default di Uomo misterios inizializza il numero di incontro del 
    * personaggio e i potenziamenti che andra' a consegnare all'utente
    */
    public Pilota() {
        super.name = "Uomo misterioso";
        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.oggettoDelPersonaggio = new EnergyDrink();
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- Salute viaggiatore, se stavi cercando il pilota dell'elicottero lo hai trovato... "
            + "\nPeccato che io abbia perso il mio mezzo quando mi sono allontanato per cercare aiuto in mezzo alla bufera. "
            + "\nNon posso portarti a casa, in compenso se lo trovi tu potresti venirmi a recuperare. "
            + "\nA bordo del mio mezzo troverai il co-pilota, digli che sto bene"
            + "\nPer continuare il tuo viaggio ti do un energy drink, cosi' sarai piu' veloce a trovare l'elicottero :D"
            + "\nIn bocca al lupo " + player.getName());
            incontrato= true;
            giveObjectTo(player);
        } else {
            System.out.println("Scommetto che non hai ancora trovato l'elicottero eh... Bhe, non mi meraviglio. Nessuno di noi c'e' riuscito");
        }
    }
}