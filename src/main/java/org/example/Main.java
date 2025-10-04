package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Creator creator = new Creator();
    private final Transaction transaction = new Transaction();
    private final Scanner sc = new Scanner(System.in);
    private final AccountsService callAccountsService = new AccountsService();

    public static void main(String[] args) {
        Main atm = new Main();
        atm.start();
    }

    void start() {
        System.out.println("===== Welcome to ATM =====");
    boolean going = true;
        while (going) {
            System.out.println("\nAre you a new user or existing user?");
            System.out.println("1. Existing User");
            System.out.println("2. New User");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if (choice==2) {
                creator.addAccount();
            } else if (choice==1) {
                System.out.print("Enter Account Number: ");
                int accNumber = sc.nextInt();

                System.out.print("Enter PIN: ");
                int pin = sc.nextInt();

                List<Accounts> accounts = callAccountsService.getAccounts();
                Accounts loggedIn = null;

                for (Accounts acc : accounts) {
                    if (acc.getAccountNumber() == accNumber && acc.getPassword() == pin) {
                        loggedIn = acc;
                        break;
                    }
                }
                if (loggedIn != null) {
                    System.out.println("✅ Login successful!");
                    userMenu(loggedIn);
                } else {
                    System.out.println("❌ Invalid credentials, please try again.");
                }

            } else if (choice==3) {
                System.out.println("👋 Thank you for using ATM!");
                going = false;
            } else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }

        sc.close();
    }
    void userMenu(Accounts accounts) {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Change Password");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit to Main Menu");

            int option = sc.nextInt();

            switch (option) {
                case 1 -> creator.changePin();
                case 2 -> {
                    System.out.println("Amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    transaction.Withdraw(accounts, withdraw);
                    break;
                }
                case 3 ->
                        {
                            System.out.println("Amount to withdraw: ");

                        int deposit = sc.nextInt();
                        transaction.Deposit(accounts, deposit);
                        break;
                        }
                case 4 -> transaction.CheckBalance(accounts);
                case 5 -> {
                    creator.deleteAccount();
                    return; // back to main menu after deleting
                }
                case 6 -> {
                    return; // exit to main menu
                }
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}
