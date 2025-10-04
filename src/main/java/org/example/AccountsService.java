package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AccountsService {

    private static final String File_Path = "/Users/anirudhchakraborty/IdeaProjects/ATMCli/src/main/resources/accountes.json";
    private final Gson gson = new Gson();

    //Get accounts
    public List<Accounts> getAccounts() {
        try (FileReader reader = new FileReader(File_Path)) {
            //not sure of the type so we use Type file to get the type
            //Concept: Java Generics
            Type listType = new TypeToken<List<Accounts>>() {
            }.getType();
            List<Accounts> accounts = gson.fromJson(reader, listType);
            return accounts != null ? accounts : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Error reading file");
            return new ArrayList<>();
        }
    }


    //save accounts
    public void saveAccounts(List<Accounts> accounts) {
        try (FileWriter writer = new FileWriter(File_Path)) {
            gson.toJson(accounts, writer);
        } catch (IOException e) {
            System.out.println("Failed to save file");
        }
    }

    //add accounts

    public void addAccount(Accounts account) {
        List<Accounts> accounts = getAccounts();
        accounts.add(account);
        saveAccounts(accounts);
    }
    //delete accounts

    public boolean deleteAccounts(Accounts account) {
        List<Accounts> accounts = getAccounts();
        boolean removed = accounts.removeIf(acc ->
                acc.getAccountNumber() == account.getAccountNumber() &&
                        acc.getPassword() == account.getPassword()
        );

        if (removed) {
            saveAccounts(accounts);
        }

        return removed;
    }
}
