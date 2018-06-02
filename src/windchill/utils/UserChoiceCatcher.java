package windchill.utils;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Contiene metodi di "utilita' per limitare gli errori che l'utente puo' commettere nell'inserimento
 * @version 0.1rc
 * @author capranorvegese
 */

public final class UserChoiceCatcher {
    
static byte userByte;
static double userDouble;
static char userChar;

    /**
     * Permette di inserire un byte, in caso il numero non sia giusto si chiede all'utente di reinserirlo
     * @return il byte inserito dall'utente
     */
    public static byte byteChoice() {
        try {
            Scanner userInput = new Scanner(System.in);
            userByte = userInput.nextByte();
        } catch (InputMismatchException  e) {
            System.out.println("Attenzione: devi inserire un numero intero inferiore a 127");
            byteChoice();
        } 
        return userByte;
    }
    
    /**
     * Permette di inserire un double, in caso il numero non sia giusto si chiede all'utente di reinserirlo
     * @return il double inserito dall'utente
     */
    public static double doubleChoice() {
        try {
            Scanner userInput = new Scanner(System.in);
            userDouble = userInput.nextDouble();
        } catch (InputMismatchException  e) {
            System.out.println("Attenzione: devi inserire un numero con virgola, inoltre fai attenzione se la tua lingua impone di usare "
                    + "un . al posto della virgola!");
            doubleChoice();
        } 
        return userDouble;
    }
    
    /**
     * Permette di inserire un carattere, in caso il carattere non sia giusto si chiede all'oggetto di reinserirlo
     * @return il carattere inserito dall'utente
     */
    public static char charChoice() {
        try {
            Scanner userInput = new Scanner(System.in);
            userChar = userInput.next().charAt(0);
            if (userChar<97 || userChar>122) {
                System.out.println("Attenzione: devi inserire un carattere minuscolo");  
                charChoice();
            }
        } catch (InputMismatchException  e) {
            System.out.println("Attenzione: devi inserire un carattere minuscolo");
            charChoice();
        } 
        return userChar;
    }       
}