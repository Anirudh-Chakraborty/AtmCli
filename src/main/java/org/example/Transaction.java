package org.example;

import java.util.List;

public class Transaction {
    private final AccountsService callAccountsService = new AccountsService();

    public boolean Deposit(Accounts account,int amount) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber()&& acc.getPassword()== account.getPassword()) {
                acc.setBalance(acc.getBalance()+amount);
                callAccountsService.saveAccounts(accounts);
                return true;
            }
        }
        return false;
    }

    public boolean Withdraw(Accounts account, int amount) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber() && acc.getPassword() == account.getPassword()) {
                if (acc.getBalance() > amount) {
                    acc.setBalance(acc.getBalance() - amount);
                    callAccountsService.saveAccounts(accounts);
                    return true;
                }else  {
                    return false;
                }
            }
        }
        return false;
    }
    public int CheckBalance(Accounts account) {
        List<Accounts> accounts = callAccountsService.getAccounts();
        for (Accounts acc : accounts) {
            if (acc.getAccountNumber() == account.getAccountNumber() && acc.getPassword() == account.getPassword()) {
                return acc.getBalance();
            }
        }
        System.out.println("Invalid");
        return -1;
    }
}
