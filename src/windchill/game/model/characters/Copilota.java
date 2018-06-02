package windchill.game.model.characters;

import windchill.game.model.Player;

/**
 * Modella il copilota e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */
public final class Copilota extends NPC{
    
    /**
     * Il costruttore di default di Elicottero inizializza il numero di incontro del 
     * veicolo
     */
    public Copilota() {
        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.name = "Copilota";
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- Vagando nella citta' avvisti una massa scura, ti dirigi verso quella strana visione e incredibilimente trovi l'elicottero, "
            + "\ndentro questo vedi il co-pilota chino su uno strano interruttore ed indeciso sul da farsi lo sfiori. "
            + "\nUn suono sordo accompagna la accensione di un display ed improvvisamente una luce si proietta su di te accecandoti per un attimo. "
            + "\nTutto si spegne e in un secondo ti perdi in un pesante buio..."
            + "\nComplimenti! " + player.getName() + ", hai vinto. " );
            incontrato = true;
        }
    }
}