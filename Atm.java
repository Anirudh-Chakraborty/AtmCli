import java.util.*;


public class Atm {
//Main class main method

    HashMap<String, Accounts> account = new HashMap<>();
    //objects
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static Atm callAtm = new Atm();

    
    //main method that runs and calls
    public static void main(String[] args) {
        
    //ClassCaller
    callAtm.Loginmenu();
    String loginReply = sc.nextLine();

    }

    void Loginmenu(){
        System.out.println();
        System.out.println("====== Welcome to Atm App ======");
        System.out.println();
        System.out.println("======= Do you have card =======");
        System.out.println();
        System.out.println("Yes or No");
        System.out.println();

        String reply = sc.nextLine();

        if (reply.charAt(0) == 'n'|| reply.charAt(0) == 'N' ) {
            Create();
        }

    }

    void MainMenu(){
        System.out.println("====== Welcome to Atm App ======");
        System.out.println();
        System.out.println("==== Chose one of the Option ====");
        System.out.println();
        System.out.println("1. Withdraw Money");
        System.out.println("2. Deposit Money"); 
        System.out.println("3. Check Balance");

    }

    void Create(){

        String card = String.valueOf(10000000 + rand.nextInt(90000000));

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
        System.out.println();
    
        

        account.put(card, new Accounts(name, pin, amount, card));
        System.out.println("✅ Card created!");
        System.out.println("Your name: " + name);
        System.out.println("Your card number: " + card);
        System.out.println("Your Pin is: " + pin);
        System.out.println("Current Balance " + amount);

        
    }
}

class Accounts {

    String name;
    String pin;
    double balance;
    String cardNumber;

    Accounts(String name, String pin, double balance, String cardNumber){

        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }
    
}





