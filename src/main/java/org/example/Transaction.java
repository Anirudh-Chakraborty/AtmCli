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
}
