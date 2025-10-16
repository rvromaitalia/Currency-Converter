package se.lexicon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class ValutaConverterHelper {
    private ValutaConverterHelper(){}//prevent object creation
    //currency rates

    public static final double SEK_TO_USD = 0.095;
    public static final double USD_TO_SEK = 10.50;
    public static final double SEK_TO_EUR = 0.088;
    public static final double EUR_TO_SEK = 11.35;


    public static String returnConsoleUi(){
        return
                "Currency Converter APP\n" +
                "1. Convert SEK to USD\n" +
                "2. Convert USD to SEK\n" +
                "3. Convert SEK to Euro\n" +
                "4. Convert Euro to SEK\n" +
                "0. Exit\n";

    }

    public static String calculateExchangeAmount(int choice, double amount) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String customDateFormat = localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        if(choice ==1) //SEK to USD
            return ("You get USD: " + SEK_TO_USD * amount + " " + "\n" + customDateFormat);
        else if (choice == 2 )
            return ("You get SEK: " + USD_TO_SEK * amount+ " " + "\n" + customDateFormat);
        else if (choice == 3)
            return ("You get EUR:" + SEK_TO_EUR * amount+ " " +"\n" +  customDateFormat);
        else
            return ( "You get SEK: " + EUR_TO_SEK *amount+ " " + "\n" + customDateFormat);
        // Invalid input will be handled in the main
        }


    // --- Input helpers -------------------------------------------------------

    public  static int readMenuChoice(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine(); // consume trailing newline
                if (val >= 0 && val <= 4) {
                    return val;
                } else {
                    System.out.println("Please enter a number between 0 and 4.");
                }
            } else {
                // consume the invalid token to avoid infinite loop
                String bad = sc.next();
                System.out.println("Invalid input: \"" + bad + "\". Please enter a number between 0 and 4.");
            }
        }
    }

    public static double readNonNegativeAmount(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                sc.nextLine(); // consume trailing newline
                if (val >= 0) {
                    return val;
                } else {
                    System.out.println("Amount cannot be negative. Try again.");
                }
            } else {
                String bad = sc.next();
                System.out.println("Invalid amount: \"" + bad + "\". Please enter a numeric value.");
            }
        }
    }
}



