package windchill.game.model.characters;

import windchill.game.model.items.Ciaspole;
import windchill.game.model.Player;

/**
 * Modella il vecchio saggio e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class VecchioSaggio extends NPC{
    
    /**
    * Il costruttore di default di Vecchio saggio inizializza il numero di incontro del 
    * personaggio e i potenziamenti che andra' a consegnare all'utente
    */
    public VecchioSaggio() {
        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.name = "Vecchio Saggio";
        super.oggettoDelPersonaggio = new Ciaspole();
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- HEY, HEY! Segui la mia voce! Per fortuna che ti ho sentito camminare, io sono "
            + "il Vecchio Saggio.\nSo che ti stai chiedendo perche' in questo posto c'e' cosi' tanta neve "
            + "la risposta e' che non lo so nemmeno io! \nNevica da anni in questa citta'... Alcuni dicono che "
            + "sia per colpa di un sortilegio. \nTutti quelli che incontrerai in questa citta' stanno cercando di scappare, "
            + "infatti c'e' un elicottero nascosto da qualche parte. \nTi conviene trovarlo finche' puoi!"
            + "\nPer aiutarti nella tua ricerca ti lascio queste ciaspole" + "\nBuona avventura " + player.getName());
            incontrato= true;
            giveObjectTo(player);
        } else {
            System.out.println("Allora non mi hai ascoltato? Ti ho detto di scappare finche' hai la possibilita' di farlo!");
        }
    } 
}