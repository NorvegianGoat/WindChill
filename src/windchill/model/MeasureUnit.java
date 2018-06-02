package windchill.model;

import java.util.Locale;
import windchill.utils.UserChoiceCatcher;


/**
 * Questa classe consente di impostare il metodo di misurazione in base alla lingua rilevata sulla macchina o alla
 * decisione dell'utente
 * @version 0.1rc
 * @author CapraNorvegese
 */
public final class MeasureUnit {
    
    private String userLocale;
    private String measurementSystem;
    
    /**
     * Inizializza l'oggetto measureUnit ottenendo i dati
     * sulla lingua della jvm dell'utente,
     */
    public MeasureUnit() {
        //getDefault restituisce il valore della lingua della jvm, getLanguage ritorna il language code di quella lingua 
        userLocale = Locale.getDefault().getLanguage();
        switch (userLocale) {
            case "en" : measurementSystem = "imperial";
                break;
            case "zh" : measurementSystem = "imperial";
                break;
            default : measurementSystem = "metrico";
        } 
    }
    
    /**
     * Questo metodo consente di cambiare il sistema di misurazione in caso
     * esso non sia di gradimento dell'utente
     */
    public void changeMeasurementSystem() {
        byte userChoice;
        //getDisplayLanguage scrive in modo esteso e nella lingua dell'utente a cosa corrisponde il codice cella lingua
        System.out.println("La lingua del tuo sistema operativo sembra essere l'" + Locale.getDefault().getDisplayLanguage() + " e' stato quindi settato il sistema " + measurementSystem);
        System.out.println("Il sistema di misurazione di default non ti va bene? Premi 0 per cambiarlo, altrimenti un altro numero qualsiasi per proseguire");
        userChoice= UserChoiceCatcher.byteChoice();
        if (userChoice==0) {
            System.out.println("Scegli metrico con 0 o imperiale con 1");
            userChoice = UserChoiceCatcher.byteChoice();
            switch (userChoice) {
                case 0 : measurementSystem = "metrico";
                break;
                case 1 : measurementSystem = "imperiale";
                break;
                default : while (userChoice!=0 && userChoice!=1) {
                    System.out.println("Ooooh ohhh sembra che il numero da te scelto non vada bene, inserici 0 per il sistema metrico e 1 per l'imperiale");
                    userChoice = UserChoiceCatcher.byteChoice();
                    }
            }
        }
    }
    
    /**
     * Ritorna il sistema di misurazione dell'utente. 
     * Il sistema puo' variare fra metrico e imperiale
     * @return String contenente il sistema di riferimento dell'utente
     */
    public String getMeasurementSystem() {
        return measurementSystem;
    }
}