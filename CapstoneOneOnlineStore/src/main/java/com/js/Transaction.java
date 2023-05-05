package com.js;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transaction {public static List<Transaction> readAllTransactions() throws IOException {
    List<Transaction> transactions = new ArrayList<>();
    BufferedReader bufferedReader = null;
    try {
        bufferedReader = new BufferedReader(new FileReader("Transactions.txt"));
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    String line;
    while (true) {
        try {
            if (!((line = bufferedReader.readLine()) != null)) break;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] fields = line.split("\\|");
        String date = fields[0];
        String time = fields[1];
        String description = fields[2];
        String vendor = fields[3];
        double amount = Double.parseDouble(fields[4]);
        Transaction transaction = new Transaction();
        transactions.add(transaction);
    }
    bufferedReader.close();
    return transactions;
}
}
