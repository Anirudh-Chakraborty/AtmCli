package org.example;

public class Accounts {
    String Name;
    int password;
    int accountNumber;
    int balance;

    public Accounts(String name, int password, int accountNumber, int balance) {
        Name = name;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

}
