package org.example;

import java.util.List;
import java.util.Scanner;

public class Creator {
    private final AccountsService callAccountsService = new AccountsService();
    private final Scanner sc = new Scanner(System.in);

   public void addAccount() {
       List<Accounts> accounts = callAccountsService.getAccounts();

       System.out.println("Enter Your Name: ");
       String name = sc.nextLine();

       System.out.print("Enter Password (PIN): ");
       int password = sc.nextInt();

       System.out.print("Enter Initial Balance: ");
       int balance = sc.nextInt();

       Accounts lastAccount = accounts.get(accounts.size() - 1);
       int newAccountNumber = lastAccount.getAccountNumber() + 1;

       System.out.println("New Account Number is: " + newAccountNumber);

       Accounts newAccount = new Accounts(name, password, newAccountNumber, balance);

       accounts.add(newAccount);
       callAccountsService.saveAccounts(accounts);
       System.out.println("Account Created Successfully");

   }

    public void deleteAccount() {
    List<Accounts> accounts = callAccountsService.getAccounts();

        System.out.println("Enter Account Number to Delete: ");
        int accountNumber = sc.nextInt();

        System.out.println("Enter Pin Number");
        int pinNumber = sc.nextInt();

        Accounts dummy = new Accounts("", pinNumber, accountNumber,0);

        boolean removed = callAccountsService.deleteAccounts(dummy);

        if (removed) {
            System.out.println("✅ Account Deleted Successfully");
        } else {
            System.out.println("❌ Account not found or wrong PIN");
        }
    }

    public void changePin() {
        List<Accounts> accounts = callAccountsService.getAccounts();
        System.out.println("Enter Account Number Whose Pin to Change: ");
        int accountNumber = sc.nextInt();

        System.out.println("Enter Pin Number: ");
        int pinNumber = sc.nextInt();

        System.out.println("Enter new Pin Number: ");
        int newPinNumber = sc.nextInt();

        boolean updated = false;

        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == accountNumber && acc.getPassword() == pinNumber) {
                acc.setPassword(newPinNumber);  // update PIN
                updated = true;
                break;
            }
        }

        if (updated) {
            callAccountsService.saveAccounts(accounts);
            System.out.println("✅ PIN changed successfully!");
        } else {
            System.out.println("❌ Account not found or old PIN is incorrect.");
        }

    }
}
