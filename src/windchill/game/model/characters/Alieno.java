package windchill.game.model.characters;

import windchill.game.model.Player;
import windchill.game.model.items.TutaSpaziale;

/**
 * Modella l'alieno e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Alieno extends NPC {
    
    /**
     * Il costruttore di default di Alieno inizializza il numero di incontro del 
     * personaggio e i potenziamenti che andra' a consegnare all'utente
     */
    public Alieno() {
        super.name = "Alieno";
        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.oggettoDelPersonaggio = new TutaSpaziale();
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- Salute umano, io sono alieno. Tu capisci mia lingua grazie a mia avanzata tecnologia. "
            + "\nIo stava tornando a mio pianeta, ma sono perso. Non so come tornare a casa, miei radar no funzionano. "
            + "\nGrazie a mia grande tecnologia io posso sopravvivere, ma tu rischia di morire di freddo quindi io regala te tuta spaziale. "
            + "\nCiao " + player.getName() + " stato bello conoscerti");
            incontrato= true;
            giveObjectTo(player);
        } else {
            System.out.println("Umano, mia tecnologia su di te no funziona per sempre, sbrigati a trovare elicottero per provare a tornare a casa!");
        }
    }
  
}