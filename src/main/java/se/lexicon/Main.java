    package se.lexicon;
    import java.util.Scanner;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int choice;
            double amount;
            
            //Initialize console UI
            System.out.println(ValutaConverterHelper.returnConsoleUi());

            while (true){
                choice = ValutaConverterHelper.readMenuChoice(scanner, "Enter your choice: ");
                if (choice == 0){
                    System.out.println("Bye!");
                    break;
                }
                amount = ValutaConverterHelper.readNonNegativeAmount(scanner, "Enter your amount: ");
                System.out.println(ValutaConverterHelper.calculateExchangeAmount(choice, amount));
            }
        }
    }