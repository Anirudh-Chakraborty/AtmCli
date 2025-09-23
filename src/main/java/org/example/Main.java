package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //caller
        Main callMain = new Main();
        Creator callCreator = new Creator();
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Welcome to Atm =====");

        System.out.println("Please enter your Card number:");
        System.out.println("For new User press '2'");
        String cardNumber = sc.nextLine();

        if (cardNumber.equals("2")) {
            callCreator.addAccount();
        }

    }


}