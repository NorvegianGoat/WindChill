package windchill.game.model;

import windchill.game.model.characters.Bambino;
import windchill.game.model.characters.Copilota;
import windchill.game.model.characters.VladIlSimpaticone;
import windchill.game.model.characters.Alieno;
import windchill.game.model.characters.Pilota;
import windchill.game.model.characters.VecchioSaggio;
import java.util.Scanner;
import windchill.utils.UserChoiceCatcher;
import windchill.model.WindChill;


/**
 * Contiene la logica della partita
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class Partita {
     
    private Player player;
    private final Alieno alieno;
    private final Bambino bambino;
    private final Copilota elicottero;
    private final Pilota uomoMisterioso;
    private final VecchioSaggio vecchioSaggio;
    private final VladIlSimpaticone vladIlSimpaticone;
    private final Scanner input;
    
    /**
     * Il costruttore di partita inizializza i personaggi che caratterizzano la partita
     * e alcuni strumenti che serviranno durante il gioco
     */
    public Partita() {
        alieno = new Alieno();
        bambino = new Bambino();
        elicottero = new Copilota();
        uomoMisterioso = new Pilota();
        vecchioSaggio = new VecchioSaggio();
        vladIlSimpaticone = new VladIlSimpaticone();
        input = new Scanner(System.in);
    }
    
    /**
    * Questo metodo avvia la partita e contiene la logica del gioco
    */
    public void gameLogic() {
        System.out.println("Benvenuto in WINDCHILL - Game"
        + "\nTi verra' ora chiesto di configurare le variabili dell'ambiente di gioco");
        System.out.println("Inserire la velocita' del vento in km/h (senza unita' di misura)");
        double windSpeed = UserChoiceCatcher.doubleChoice();
        while (windSpeed<0) {
            System.out.println("Attenzione, la velocita' del vento non puo' essere negativa, reinserirla");
            windSpeed = UserChoiceCatcher.doubleChoice();
        }
        System.out.println("Inserire la temperatura in gradi Centigradi (senza unita' di misura)");
        double temperature = UserChoiceCatcher.doubleChoice();
        while (temperature>0) {
            System.out.println("Attenzione, la temperatura non puo' essere maggiore di 0, reinserirla");
            temperature = UserChoiceCatcher.doubleChoice();
        }
        WindChill percipiedTemperatureInCelsius = new WindChill(temperature , windSpeed);
        double temperaturaPercepita = percipiedTemperatureInCelsius.metricChillCalculator();
        System.out.println("La temperatura percepita in gradi Centigradi e' " + temperaturaPercepita);
        playerCreator();
        while(player.calcoloPuntiVita(temperaturaPercepita)>0) {
            System.out.println("Procedi nella bufera camminando lentamente \n"
            +   "               /yo'           \n" +
                "              +MMMMd          \n" +
                "           ``-+MMMh:          \n" +
                "         .sdMMMMMMy`          \n" +
                "        /mMMMMMMMMMm-         \n" +
                "       oMNdMMMMMMMMMm.        \n" +
                "      :MN/.MMMMMMNsNMm/.      \n" +
                "      dM+ :MMMMMMy -ymMmy+/`  \n" +
                "     -mM+`dMMMMMMy   .:+yhy`  \n" +
                "      .-.sMMMdMMMN:           \n" +
                "        oMMMo`+NMMN/          \n" +
                "      .hMMN/   -dMMN/         \n" +
                "    `+NMNy.     `hMMN`        \n" +
                "   /dMNs-        `mMMo        \n" +
                "  `mMd`           -NMm        \n" +
                "   .yd-            +MMhy+.    \n" +
                "                    so:`      ");
            System.out.println(player.getDurataSpostamentoString());
            long timeToWait = player.getDurataSpostamentoInMillis();
            waitTime(timeToWait);
            encounter();
            if (elicottero.isIncontrato()) {
                return;
            }
        }
        System.out.println("Senti le forze mancarti, la tormenta ti avvolge e ti addormenti in un buio profondo e glaciale... ");   
    }   
    
    private void waitTime(long timeToWait) {
        try {
                Thread.sleep(timeToWait);
            } catch (InterruptedException e){
                System.out.println("Sembra che qualcosa sia andato storto con il processo, procedo con la chiusura del programma");
                System.exit(0);
            }
    }
    
    /**
    * Configura le caratteristiche base per la creazione del personaggio
    */
    private void playerCreator() {
        System.out.println("La configurazione del giocatore inizia da qua. "
                + "\nInserire il nome:");
        String playerName = input.nextLine();
        System.out.println("Inserire l'eta':");
        byte eta = UserChoiceCatcher.byteChoice();
        while (eta<0) {
            System.out.println("Attenzione! L'eta' non puo' essere negativa. Reinseriscila.");
            eta = UserChoiceCatcher.byteChoice();
        }
        System.out.println("Inserire il sesso (m/f):");
        char sesso = UserChoiceCatcher.charChoice();
        while (sesso!=102 & sesso!=109) {
            System.out.println("Attenzione, devi scegliere fra m o f ");
            System.out.println("Inseire il sesso");
            sesso = UserChoiceCatcher.charChoice();
        }
        player = new Player(playerName, eta, sesso);
    }
    
    /**
     * Questo metodo confronta i numeri di incontro degli npc con quello del personaggio, in caso 
     * siano corrispondenti il personaggio interagisce con gli npc.
     * Alla fine degli incontri del turno vengono ricapitolate le caratteristiche del giocatore
     */
    private void encounter() {
        if(player.playerEncounterNumber()==alieno.getEncounterNumber()) {
            System.out.println("Incontri un " + alieno.getName());
            alieno.parla(player);
            waitTime(20000);
        } if(player.playerEncounterNumber()==bambino.getEncounterNumber()) {
            System.out.println("Incontri un " + bambino.getName());
            bambino.parla(player);
            waitTime(20000);
        } if(player.playerEncounterNumber()==vladIlSimpaticone.getEncounterNumber()) {
            System.out.println("Incontri " + vladIlSimpaticone.getName());
            vladIlSimpaticone.parla(player);
            waitTime(20000);
        } if(player.playerEncounterNumber()==uomoMisterioso.getEncounterNumber()) {
            System.out.println("Incontri un " + uomoMisterioso.getName());
            uomoMisterioso.parla(player);
            waitTime(20000);
        } if(player.playerEncounterNumber()==vecchioSaggio.getEncounterNumber()) {
            System.out.println("Incontri un " + vecchioSaggio.getName());
            vecchioSaggio.parla(player);
            waitTime(20000);
        }   if(player.playerEncounterNumber()==elicottero.getEncounterNumber()) {
            elicottero.parla(player);
        } else {
            System.out.println("+ Ti aggiri per la citta' senza incontrare nessuno");
        }
        System.out.println("* Le tue caratteritiche attuali sono: " + player.toString());
    }
}