package windchill.game.model.characters;

import java.util.Random;
import windchill.game.model.items.InGameObject;
import windchill.game.model.Player;

/**
 * Questo abstract modella il concetto di npc, il metodo parla va ridefinito con le righe di 
 * dialogo del personaggio che si estende
 * @version 0.1rc
 * @author CapraNorvegese
 */

public abstract class NPC{
    
    protected String name;
    protected byte incontro;
    protected boolean incontrato = false;

    protected InGameObject oggettoDelPersonaggio;
    
    Random randomEncounter = new Random();
    
    //Il numero di incontro serve per far incontrare l'npc e il giocatore
    /**
     * Ritorna il numero di incontro appartenente all'npc
     * @return un byte che e' il numero di incontro dell'npc
     */
    public byte getEncounterNumber() {
        return incontro;
    }
    
    /**
     * Ritorna il nome dell'npc
     * @return Una stringa contenente il nome dell'npc
     */
    public String getName() {
        return name;
    }
   
    /**
     * Contiene le righe di dialogo dell'npc
     * @param player e' il giocatore a cui si rivolge il dialogo
     */
    public abstract void parla(Player player);
    
    /**
     * Questo metodo serve a "dare" al giocatore l'oggetto che l'npc possiede,
     * viene richiamato il metodo del giocatore per "prendere" l'oggetto.
     * Viene anche stampata una stringa contenente le caratteristiche dell'oggetto del personaggio
     * @param player e' il giocatore a cui viene dato l'oggetto
     */
    protected void giveObjectTo(Player player) {
      player.equipObject(oggettoDelPersonaggio);
      oggettoDelPersonaggio.stampaBenefici();
      System.out.println("+ " + oggettoDelPersonaggio.toString());
    }
    
    /**
     * Questo metodo e' necessario per stabilire se l'npc e' stato incontrato
     * @return un booleano che stabilisce se l'npc e' stato incontrato o no
     */
    public boolean isIncontrato() {
        return incontrato;
    }
}