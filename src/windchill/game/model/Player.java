package windchill.game.model;

import windchill.game.model.items.InGameObject;
import windchill.utils.UserChoiceCatcher;
import java.util.Random;

/**
 * Questa classe modella il concetto di giocatore e contiene le formule per calcolare la velocita' di 
 * spostamento e la perdita di vita ad ogni turno
 * @version 0.1beta
 * @author CapraNorvegese
 */

public final class Player {
    
    private String name;
    final private byte years;
    final private char sesso;
    private double forza = 0;
    private double intelligenza = 0;
    private double agilita = 0;
    private double resistenzaAlFreddo = 0;
    private double puntiVita = 100;
    private byte assignablePoints = 40;
    private double durataSpostamento;
    
    Random randomEncounterGenerator;

    /**
     * Crea il personaggio del giocatore
     * @param name il nickname del giocatore
     * @param years gli anni del personaggio
     * @param sesso il sesso del personaggio
     * Aseguito della creazione del personaggio viene chiamato il metodo per assegnare 
     * le caratteristiche di forza, intelligenza, resistenza al freddo e agilita'
     */
    public Player(String name, byte years, char sesso) {
        this.name = name;
        this.years = years;
        this.sesso = sesso;
        randomEncounterGenerator = new Random();
        setCharacteristics();
    }
    
    /**
     * Consente di settare le di forza, intelligenza, resistenza al freddo e agilita
     */
    private void setCharacteristics() {
        System.out.println("Ciao! Si possono assegnare al giocatore 40 punti che caratterizzeranno la sua forza, "
        + " intelligenza, agilita' e resistenza al freddo. \nSe assegnerai piu' di 40 punti i punti in piu' verranno sosttratti alla resistenza al freddo."
        + "\nLe caratteristiche vengono assegnate solo una volta quindi pensa bene come suddividere i tuoi punti");
        if (assignablePoints>0) {
            System.out.println("Ti rimangono " + assignablePoints + " punti");
            System.out.println("Forza");
            forza = UserChoiceCatcher.byteChoice();
            isPositive((byte) forza);
            assignablePoints-=forza;
        } if (assignablePoints>0) {
            System.out.println("Ti rimangono " + assignablePoints + " punti");
            System.out.println("Intelligenza");
            intelligenza = UserChoiceCatcher.byteChoice();
             isPositive((byte) intelligenza);
            assignablePoints-=intelligenza;
        } if (assignablePoints>0) {
            System.out.println("Ti rimangono " + assignablePoints + " punti");
            System.out.println("Agilita'");
             isPositive((byte) agilita);
            agilita = UserChoiceCatcher.byteChoice();
            assignablePoints-=agilita;
        } if (assignablePoints>0) {
            System.out.println("Ti rimangono " + assignablePoints + " punti");
            System.out.println("Resistenza al freddo");
            resistenzaAlFreddo = UserChoiceCatcher.byteChoice();
             isPositive((byte) resistenzaAlFreddo);
            assignablePoints-=resistenzaAlFreddo;
        } if (assignablePoints<0) {
            resistenzaAlFreddo+= assignablePoints;
        }
    }
    
    /**
     * Questo metodo controlla che i punti inseriti dall'utente non siano negativi o maggiori di 40
     * @param puntiCaratteristica rappresentano i punti inseriti dall'utente
     * @return i nuovi punti inseriti dall'utente in caso quelli precedenti non 
     * rispondessero alle caratteristiche richieste
     */
    private byte isPositive(byte puntiCaratteristica) {
        while (puntiCaratteristica<0||puntiCaratteristica>40) {
            puntiCaratteristica=0;
            System.out.println("Attenzione! Azione non permessa, ricorda che la caratteristica "
                    + "deve essere non minore di 0 e non maggiore di 40!"); 
            puntiCaratteristica = UserChoiceCatcher.byteChoice();
        }
        return puntiCaratteristica;
    }

    /**
     * Questo metodo consente di aggiornare le statistiche del giocatore in caso il personaggio con cui 
     * parla non gli dia un oggetto.
     * @param f rappresenta la forza
     * @param i rappresenta la intelligenza
     * @param a rappresenta la agilita'
     * @param rf rappresenta la resistenza al freddo
     * @param pv rappresenta i punti vita
     */
    public void setPowerUps(double f, double i, double a, double rf, double pv) {
       forza+=f;
       intelligenza+=i;
       agilita+=a;
       resistenzaAlFreddo+=rf;
       puntiVita+=pv;
    }
    
    /**
     * Ritorna il nome del giocaore
     * @return ua stringa contenente il nome del giocatore
     */
    public String getName() {
        return name;
    }
    
    /**
     * Ritorna il numero di incontro del giocatore
     * @return Un byte contenente il numero di incontro
     */
    public byte playerEncounterNumber() {
        byte randomEncounter = (byte) randomEncounterGenerator.nextInt(10);
        return randomEncounter;
    }
    
    /**
     * Il metodo calcola in base alla temperatura percepita e alle caratteristiche dell'utente
     * quanta vita perdera' il giocatore nel turno a causa del chilling factor
     * @param temperaturaPercepita la temperatura percepita in base al chilling factor
     * @return un double rappresentante la vita attuale dell'utente
     */
    public double calcoloPuntiVita(double temperaturaPercepita) {
        puntiVita+=temperaturaPercepita/((intelligenza/14)+(forza/8)+(agilita/8)+(resistenzaAlFreddo/4));
        return puntiVita;
    }
    
    /**
     * Il metodo calcola in base alle caratteristiche dell'utente la durata dello spostamento in millisecondi
     * @return un long contenente la durata dello spostamento
     */
    public long getDurataSpostamentoInMillis() {
        durataSpostamento = ((0.5/intelligenza)+(0.5/forza)+(0.5/agilita)+(0.5/resistenzaAlFreddo)+(years/120.0))*30000;
        if(durataSpostamento>60000) {
            durataSpostamento=60000;
        }
        return (long) durataSpostamento;
    }
    
    /**
     * Restituisce una stringa con la durata dello spostamento in secondi
     * @return una stringa che riepiloga la durata dello spostamento dell'utente
     */
    public String getDurataSpostamentoString() {
        String durataSpostamentoString = "Il tuo spostamento dura " + Math.round(((getDurataSpostamentoInMillis()/1000)*100)/100) + " secondi";
        return durataSpostamentoString;
    }
    
    /**
     * Questo metodo consente al giocatore di "prendere" un oggetto "dato" da un npc.
     * L'oggetto dell'npc viene passato come parametro le caratteristiche del giocatore vengono aggiornate
     * @param objectGivenToPlayer rappresenta l'oggetto che viene dato al giocatore
     */
    public void equipObject(InGameObject objectGivenToPlayer) {
        forza += objectGivenToPlayer.getForza();
        intelligenza += objectGivenToPlayer.getIntelligenza();
        agilita += objectGivenToPlayer.getAgilita();
        resistenzaAlFreddo += objectGivenToPlayer.getAgilita();
        puntiVita += objectGivenToPlayer.getAgilita();
    }
    
    /**
     * Riassume lo stato attuale delle caratteristiche del giocatore
     * @return Una stringa contenente le caratteristiche attuali del giocatore
     */
    @Override
    public String toString() {
        String actualCaracteristics = " Forza " + forza + ", intelligenza " 
                + intelligenza + ", agilita' " + agilita + ", resistenza al freddo " + 
                resistenzaAlFreddo + ", punti vita " + ((double)(Math.round(puntiVita*100)/100));
                return actualCaracteristics;
    }
}