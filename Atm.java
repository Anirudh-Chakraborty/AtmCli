import java.util.*;

public class Atm {
    // Main class main method

    HashMap<String, Accounts> account = new HashMap<>();
    // objects
    static Scanner sc = new Scanner(System.in);
    static Atm callAtm = new Atm();
    static int lastDigit = 01;

    // while boolean to have the loop running till it stops

    static boolean whileRunning = true;

    // main method that runs and calls
    public static void main(String[] args) {

        // ClassCaller
        callAtm.Loginmenu();

        while (whileRunning) {

            callAtm.MainMenu();
            int optionChosen = sc.nextInt();
            sc.nextLine();

            switch (optionChosen) {
                case 1:
                    callAtm.Create();
                    break;
                case 2:
                    callAtm.Withdraw();
                    break;
                case 5:
                    System.out.println("Quitting the Program:");
                    whileRunning = false;
                default:
                    break;
            }
        }

    }

    // The very first Menu for Login
    void Loginmenu() {
        System.out.println();
        System.out.println("====== Welcome to Atm App ======");
        System.out.println();
        System.out.println("======= Do you have card =======");
        System.out.println();
        System.out.println("Yes or No");
        System.out.println();

        String reply = sc.nextLine();

        if (reply.charAt(0) == 'n' || reply.charAt(0) == 'N') {
            Create();
        }

    }

    // The Main Menu for Cards
    void MainMenu() {
        System.out.println("====== Welcome to Atm App ======");
        System.out.println();
        System.out.println("==== Chose one of the Option ====");
        System.out.println();
        System.out.println("1. Create New Card ");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Quit Program");

    }

    // Creating New Card
    void Create() {
        System.out.println("==== Creating New Card ====");

        String card = String.valueOf(100 + lastDigit);
        lastDigit++;

        System.out.println();
        System.out.println("Card Number generated: " + card);
        System.out.println();

        System.out.print("Set your 4-digit PIN: ");
        String pin = sc.nextLine();
        System.out.println();

        System.out.println("Please Enter your Name");
        String name = sc.nextLine();
        System.out.println();

        System.out.println("Enter initial deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println();

        account.put(card, new Accounts(name, pin, amount, card));
        System.out.println("✅ Card created!");
        System.out.println("Your name: " + name);
        System.out.println("Your card number: " + card);
        System.out.println("Your Pin is: " + pin);
        System.out.println("Current Balance " + amount);

        System.out.println();

        System.out.println(" Do You wish to Go to Main Menu ");
        System.out.println("Yes or No");

        String cont = sc.nextLine();
        if (cont.charAt(0) == 'n' || cont.charAt(0) == 'N') {
            System.out.println("quitting program");
            whileRunning = false;
        }

    }

    // Withdrawl System
    void Withdraw() {

        System.out.println("Enter card Number");
        String cardNumber = sc.nextLine();

        System.out.println(" Enter Pin ");
        String pin = sc.nextLine();

        System.out.println("Amount to Withdraw");
        Double withdrawl = sc.nextDouble();
        sc.nextLine();
        boolean runner = true;

        while (runner) {
            if (account.containsKey(cardNumber)) {

                if (account.get(cardNumber).pin.equals(pin)) {
                    System.out.println("Correct Pin!!");

                    if (account.get(cardNumber).balance >= withdrawl) {
                        System.out.println();
                        
                        System.out.println(withdrawl + " Disbursed Succesfully");
                        account.get(cardNumber).balance -= withdrawl;

                        System.out.println();
                        System.out.println("Remaining Balnce is: " + (account.get(cardNumber).balance));
                        
                        System.out.println();
                        System.out.println(" Do You wish to Go to Main Menu ");
                        System.out.println("Yes or No");

                        String cont = sc.nextLine();
                        if (cont.charAt(0) == 'n' || cont.charAt(0) == 'N') {
                            System.out.println("quitting program");
                            whileRunning = false;
                        } else {
                            runner = false;
                            return;
                        }
                    } else {
                        System.out.println("Not Sufficient Balance");
                        System.out.println("Enter correct Amount");
                        withdrawl = sc.nextDouble();
                        sc.nextLine();
                    }
                } else {
                    System.out.println("**** Invalid Pin ****");
                    System.out.println("ReEnter Pin!!");
                    pin = sc.nextLine();
                }
            } else {
                System.out.println("Invalid Credentials");
                System.out.println("Retype Card number");
                cardNumber = sc.nextLine();
            }
        }
    }
}

class Accounts {

    String name;
    String pin;
    Double balance;
    String cardNumber;

    Accounts(String name, String pin, Double balance, String cardNumber) {

        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

}
