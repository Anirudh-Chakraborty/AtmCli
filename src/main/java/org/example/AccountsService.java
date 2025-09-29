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

    private static final String File_Path = "src/main/resources/Accounts.json";
    private final Gson gson = new Gson();

    //list accounts

    public List<Accounts>  getAccounts() {
        List<Accounts> accounts = new ArrayList<>();

    }
    //save accounts

    //delete accounts



}
