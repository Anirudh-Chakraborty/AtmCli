package org.example;

import java.util.List;

public class Transaction {
    private final AccountsService callAccountsService = new AccountsService();

    public void Deposit(Accounts account, int amount) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber()&& acc.getPassword()== account.getPassword()) {
                acc.setBalance(acc.getBalance()+amount);
                callAccountsService.saveAccounts(accounts);
                System.out.println("Deposited " + amount + " to " + account.getAccountNumber());
                System.out.println("New balance is " + acc.getBalance());
                return;
            }
        }
    }

    public void Withdraw(Accounts account, int amount) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber() && acc.getPassword() == account.getPassword()) {
                if (acc.getBalance() > amount) {
                    acc.setBalance(acc.getBalance() - amount);
                    callAccountsService.saveAccounts(accounts);
                    System.out.println("Withdraw Success");
                    System.out.println("New Balance is " + acc.getBalance());
                    return;
                }else  {
                    return;
                }
            }
        }
    }
    public void CheckBalance(Accounts account) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber() && acc.getPassword() == account.getPassword()) {
                System.out.println("The Current Balance is: "+acc.getBalance());
                return;
            }
        }
        System.out.println("Invalid");
    }


    public void transferMoney(Accounts from, int to, int amount) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        Accounts sender = null;
        Accounts receiver = null;

        // Find sender and receiver in the accounts list
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == from.getAccountNumber() && acc.getPassword()==from.getPassword()) {
                sender = acc;
            }
            if (acc.getAccountNumber() == to) {
                receiver = acc;
            }
        }

        if (sender == null) {
            System.out.println("Sender account not found or invalid credentials.");
            return;
        }

        if (receiver == null) {
            System.out.println("Receiver account not found.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        // Perform transfer
        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        callAccountsService.saveAccounts(accounts);

        System.out.println("Transfer successful!");
        System.out.println("Sender new balance: " + sender.getBalance());
        System.out.println("Receiver new balance: " + receiver.getBalance());
    }

}
