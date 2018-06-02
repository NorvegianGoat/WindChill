package windchill.game.model.characters;

import windchill.game.model.Player;

/**
 * Modella Vlad il simpaticone e contiene le sue righe di dialogo
 * @version 0.1rc
 * @author CapraNorvegese
 */

public final class VladIlSimpaticone extends NPC{
    
    //Vlad il simpaticone ha delle caratteristiche particolari in quanto e' l'unico npc che 
    //toglie punti all'utente invece che dargli un oggetto 
    double f=-3;
    double i=0;
    double a = -3;
    double rf=-7;
    double pv=-3;
        
    /**
    * Il costruttore di default di vlad il simpaticone saggio inizializza il numero di incontro del 
    * personaggio e le caratteristiche che andra' a togliere al giocatore
    */
    public VladIlSimpaticone() {
        super.incontro = (byte) randomEncounter.nextInt(10);
        super.incontrato = false;
        super.name = "Vlad il simpaticone";
        f=-3;
        i=0;
        a = -3;
        rf=-7;
        pv=-3;
    }
    
    @Override
    public void parla(Player player) {
        if (!isIncontrato()) {
            System.out.println("- Ciao! Sono Vlad il simpaticone! e' una fortuna che tu mi abbia incontrato "
            + "sono una delle poche persone che non proveranno a ostacolarti, sai? \nIn questo posto tutti "
            + "cercano l'elicottero, ma io no... Anzi! Ti diro' come trovarlo immediatamente :D "
            + "\nSe vuoi trovare subito l'elicottero premi il tasto control e poi il tasto c. "
            + "\nVedrai, mi ringrazierai! Per questo prezioso consiglio credo che sia opportuno che tu mi dia i tuoi "
            + "scarponi in segno di ringraziamento. \nSono felice di averti incontrato " + player.getName() + " :D");
            incontrato= true;
            player.setPowerUps(f, i, a, rf, pv);
        } else {
            System.out.println("Non devi avere seguito il mio consiglio eh?! Vai al diavolo! Lo trovero' io l' elicottero!");
        }
    }
}