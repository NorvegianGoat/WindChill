package windchill;

import windchill.model.WindChill;
import windchill.model.MeasureUnit;
import windchill.utils.UserChoiceCatcher;
import windchill.game.model.Partita;



/**
 * Permette l'avvio e la scelta del programma tramite un menu'
 * @version 0.1beta
 * @author capranorvegese
 */

public class Main {
    
    static MeasureUnit measureSystem = new MeasureUnit();
    
    /**
     * Avvia il menu'
     */
    public static void main(String[] args) {
        measureSystem.changeMeasurementSystem();
        while (true) {
            System.out.println("Benvenuto, scegli cosa fare: 1) Gioca a Winchill - Game, 2) calcola la temperatura percepita, 3) Esci");
            byte attivita = UserChoiceCatcher.byteChoice();
            while (attivita<1 || attivita>3) {
              System.out.println("Attenzione, devi scegliere un numero compreso fra 0 e 3!");
              attivita = UserChoiceCatcher.byteChoice();
            }
            switch(attivita) {
                case 1 : Partita partita = new Partita();
                      partita.gameLogic();
                break;
                case 2 : windChillLogic();
                break;
                case 3 : System.exit(0);
            }   
        }
    }
    
    /**
     * Contiene la logica di windchill
     */
    private static void windChillLogic() {
        System.out.println("Benvenuto in Winchill - calculator!");
        System.out.println("Inserire la velocita' del vento (l'unita' di misura dipende dalla lingua della tua macchina \ne non devi scriverla manualmente)");
        double windSpeed = UserChoiceCatcher.doubleChoice();
        while (windSpeed<0) {
            System.out.println("Attenzione, la velocita' del vento non puo' essere negativa, reinserirla");
            windSpeed = UserChoiceCatcher.doubleChoice();
        }
        System.out.println("Inserire la temperatura (senza unita' di misura)");
        double temperature = UserChoiceCatcher.doubleChoice();
        if (measureSystem.getMeasurementSystem().equals("metrico")) {
            WindChill percipiedTemperatureInCelsius = new WindChill(temperature , windSpeed);
            System.out.println("La temperatura percepita in gradi Centigradi e' " + percipiedTemperatureInCelsius.metricChillCalculator());
            System.out.println("La temperatura percepita in gradi Fharenheit e' " + percipiedTemperatureInCelsius.metricToImperialCC());
        } else { 
            WindChill percipiedTemperaturatureInFharenheit = new WindChill(temperature , windSpeed);
            System.out.println("La temperatura percepita in gradi Fharenheit e' " + percipiedTemperaturatureInFharenheit.imperialChillCalculator());
            System.out.println("La temperatura percepita in gradi Centigradi e' " + percipiedTemperaturatureInFharenheit.imperialToMetricCC());
        }
    }
}