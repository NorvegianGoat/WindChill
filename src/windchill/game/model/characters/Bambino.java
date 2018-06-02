package windchill.game.model.characters;

import windchill.game.model.items.Cioccolata;
import windchill.game.model.Player;

/**
 * Modella l'alieno e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Bambino extends NPC {
    
    /**
     * Il costruttore di default di Bambino inizializza il numero di incontro del 
     * personaggio e i potenziamenti che andra' a consegnare all'utente
     */
    public Bambino() {

        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.name = "Bambino";
        super.oggettoDelPersonaggio = new Cioccolata();
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- Ciao, anche tu sei un esploratore come me? Come no?! Non mi dire che sei finito "
            + "qui per errore! \nIn tal caso mi dispiace per te. Ho incontrato diversi personaggi strani in questa citta' "
            + "e devo dire che sospetto che tutto questo sia un complotto! \nSi', hai capito bene, un complotto. "
            + "Non ti diro' di piu' o mi crederai pazzo. \nIn ogni caso ho trovato una mappa nella quale c'e' scritto che esiste un aeroporto."
            + "\nMi sono recato in quel posto e non ho trovato nulla. Spero che tu sia piu' fortunato nella ricerca dell'elicottero..."
            + "\nTieni della cioccolata, ti aiutera' nel tuo tragitto."
            + "\nBuon viaggio " + player.getName());
            incontrato= true;
            giveObjectTo(player);
        } else {
            System.out.println("Ciao finto esploratore :P! Non hai ancora trovato l'elicottero eh?");
        }
    }
    
}