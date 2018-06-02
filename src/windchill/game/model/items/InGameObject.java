package windchill.game.model.items;


/**
 * Questo abstract modella il concetto di oggetto trovabile nella partita, il metodo
 * "stampa benefici" va ridefinito con una breve descrizione qualitativa del'oggetto.
 * per la descrizione quantitativa e' stato ridefinito il metodo toString
 * @version 0.1rc
 * @author CapraNorvegese
 */

public abstract class InGameObject {
    
    //I seguenti valori rappresentano l'influenza che un oggetto ha sulle charatteristiche del giocatore
    protected double forza;
    protected double intelligenza;
    protected double agilita;
    protected double resistenzaAlFreddo;
    protected double puntiVita;
    
    /**
     * Permette di accedere alla variabile rappresentante il valore di forza che
     * l'oggetto dona al giocatore
     * @return un valore double rappresentante la forza
     */
    public double getForza() {
        return forza;
    }
    
    /**
     * Permette di accedere alla variabile rappresentante il valore di intelligenza che
     * l'oggetto dona al giocatore
     * @return un valore double rappresentante la intelligenza
     */
    public double getIntelligenza() {
        return intelligenza;
    }
    
    /**
     * Permette di accedere alla variabile rappresentante il valore di agilita' che
     * l'oggetto dona al giocatore
     * @return un valore double rappresentante la agilita'
     */
    public double getAgilita() {
        return agilita;
    }
    
    /**
     * Permette di accedere alla variabile rappresentante il valore di resistenza al freddo che
     * l'oggetto dona al giocatore
     * @return un valore double rappresentante la resistenza al freddo
     */
    public double getResistenzaAlFreddo(){
        return resistenzaAlFreddo;
    }
    
    /**
     * Permette di accedere alla variabile rappresentante i punti vita che
     * l'oggetto dona al giocatore
     * @return un valore double rappresentante i punti  vita
     */
    public double getPuntiVita() {
        return puntiVita;
    }

    /**
     * Questo metodo riepiloga le caratteristiche del powerup
     * @return Stringa contenente le caratteristiche del power up
     */
    @Override
    public String toString() {
        String objectCharacteristics= "Con questo power up ottieni: " + forza + " punti forza, " 
                + intelligenza + " intelligenza, " + agilita + " punti agilita', " + resistenzaAlFreddo + " resistenza al freddo, "
                + puntiVita + " punti vita ";
        return objectCharacteristics;
    }
    
    /**
     * Questo metodo fornisce una descrizione qualitativa dell'oggetto
     */
    public abstract void stampaBenefici();
}
