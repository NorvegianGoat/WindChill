package windchill.model;

/**
 * Contiene i metodi per calcolare la temperatura percepita con il sistema metrico e quello imperiale, sono anche 
 * presenti metodi per effettuare la conversione fra i due sistemi
 * @version 0.1rc
 * @author capranorvegese
 */

public final class WindChill {

    private double temperature;
    private double windSpeed;

    
    public WindChill(double temperature, double windSpeed) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    /**
     * Calcola la temperatura percepita utilizzando le miglia
     * orarie e gradi Fahrenheit
     * @return Viene ritornato un double contenente la temperatura percepita in Fharenheit
     */
    public double imperialChillCalculator() {
        double c1 = 35.74;
        double c2 = 0.6215;
        double c3 = 35.75;
        double c4 = 0.4275;
        double calculatedWindChill = c1 + (c2 * temperature) - (c3 * Math.pow(windSpeed, 0.16)) + c4 * (temperature * Math.pow(windSpeed, 0.16));
        calculatedWindChill = (double) Math.round(calculatedWindChill*100)/100;
        return calculatedWindChill;
    }

    /**
     * Calcola la temperatura percepita utilizzando i chilometri
     * orari e i gradi Celsius
     * @return Viene ritornata un double contenente la temperatura percepita in gradi Centigradi
     */
    public double metricChillCalculator() {
        double c1 = 13.12;
        double c2 = 0.6215;
        double c3 = 11.37;
        double c4 = 0.3965;
        double calculatedWindChill = c1 + (c2 * temperature) - (c3 * Math.pow(windSpeed, 0.16)) + c4 * (temperature * Math.pow(windSpeed, 0.16));
        calculatedWindChill = (double) Math.round(calculatedWindChill*100)/100;
        return calculatedWindChill;
    }
    
    /**
     * Converte i dati da imperiale a metrico e ricalcola la
     * temperatura percepita
     * @return un double contenente la temperatura percepita in gradi Celsius
     */
    public double imperialToMetricCC() {
        temperature = (temperature - 32) / 1.8;
        windSpeed = windSpeed * 1.60934;
        double calculatedWindChill = metricChillCalculator();
        calculatedWindChill = (double) Math.round(calculatedWindChill*100)/100;
        return calculatedWindChill;
    }

    /**
     * Converte i dati da metrico a imperiale e ricalcola la
     * temperatura percepita
     * @return un double contenente la temperatura percepita in gradi Fharenheit
     */
    public double metricToImperialCC() {
        temperature = (temperature * 1.8) + 32;
        windSpeed = windSpeed * 0.6621371;
        double calculatedWindChill = imperialChillCalculator();
        calculatedWindChill = (double) Math.round(calculatedWindChill*100)/100;
        return calculatedWindChill;
    }

    /**
     * Cambia lo stato dell'oggetto settando nuovamente la temperatura
     * e la velocita' del vento
     * @param temperature un double contenente la nuova temperaruta
     * @param windSpeed un double contenente la nuova velocita' del vento
     * @param locale una stringa rappresentante la lingua della jvm
     * 
     */
    public void setNewTemperatureAndWind(double temperature, double windSpeed, String locale) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        if (locale.equals("metrico")) {
            System.out.println("La temperatura percepita in gradi Centigradi e' " + metricChillCalculator());
            System.out.println("La temperatura percepita in gradi Fharenheit e' " + metricToImperialCC());
        } else { 
            System.out.println("La temperatura percepita in gradi Fharenheit e' " + imperialChillCalculator());
            System.out.println("La temperatura percepita in gradi Centigradi e' " + imperialToMetricCC());
        }
    }
}