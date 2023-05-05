package com.js;
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {

    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    public static void main(String[] args) {
        displayHomeMenu();

    }

    private static void displayHomeMenu() {
    }


     int choice = 0;

    {
        while (choice != 5) {
            System.out.println("Please select an option:");
            System.out.println("1. Deposits");
            System.out.println("2. Ledger");
            System.out.println("3. Payment");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Deposits");
                    break;
                case 2:
                    System.out.println("You selected Ledger");
                    break;
                case 3:
                    System.out.println("You selected Payment");
                    break;
                case 4:
                    System.out.println("You selected Report");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    {
        String fileName = "Transactions.txt";
        String filePath = "src/main/java/com.js/Transactions.txt";
        try {
            FileReader FileReader = new FileReader(filePath + fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        writeTransaction("2023-04-15", "10:13:25", "ergonomic keyboard", "Amazon", -89.50);
        writeTransaction("2023-04-15", "11:15:00", "Invoice 1001 paid", "Joe", 1500.00);
        writeTransaction("2023-04-15", "04:45:34", "Alien-ware mouse", "James", 250.00);

        boolean exit = false;
         {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();


            switch (input.toUpperCase()) {
                case "D":

                    break;
                case "P":

                    break;
                case "L":

                    break;
                case "X":

                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void writeTransaction(String date, String time, String description, String vendor, double amount) {
        try {

            FileWriter fw = new FileWriter("src/main/java/js/Transactions.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            String amountFormatted = String.format("%.2f", amount);
            bw.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amountFormatted + "\n");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class Transaction {
        private String date;
        private String time;
        private String description;
        private String vendor;
        private static double amount;

        public Transaction(String date, String time, String description, String vendor, double amount) {
            this.date = date;
            this.time = time;
            this.description = description;
            this.vendor = vendor;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public static double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    public class LedgerScreen {
        private List<Transaction> transactions;
        private Scanner scanner;

        public LedgerScreen(List<Transaction> transactions, Scanner scanner) {
            this.scanner = scanner;
            this.transactions = transactions;


        }

        public void display() {
            System.out.println("\n=== LEDGER ===");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");

            String choice = scanner.nextLine();



            {
                System.out.println("\n=== ALL TRANSACTIONS ===");
                Collections.reverse(transactions);
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
                System.out.println();
            }
            {
                System.out.println("\n=== DEPOSITS ===");
                for (Transaction transaction : transactions) {
                    if (transaction.getAmount() >= 0) {
                        System.out.println(transaction.getDate() + " " + transaction.getTime() + " " +
                                transaction.getDescription() + " " + transaction.getVendor() + " " +
                                transaction.getAmount());
                    }
                }
            }
        }


        public void displayPayments() {
            System.out.println("\n=== PAYMENTS ===");
            Collections.reverse(transactions);
            for (Transaction transaction : transactions) {
                if (Transaction.getAmount() < 0) System.out.println(transaction);
            }
            System.out.println();
        }

        public void displayReports() {
            System.out.println("\n=== REPORTS ===");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayMonthToDateReport();
                    break;
                case "2":
                    displayPreviousMonthReport();
                    break;
                case "3":
                    displayYearToDateReport();
                    break;
                case "4":
                    displayPreviousYearReport();
                    break;
                case "0":
                    // Do nothing, just return to Ledger screen
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        private void displayMonthToDateReport() {

            System.out.println("Month to Date report is not in yet.");
        }

        private void displayPreviousMonthReport() {

            System.out.println("Previous Month report is not in yet.");
        }

        private void displayYearToDateReport() {

            System.out.println("Year to Date report is not in yet.");
        }

        private void displayPreviousYearReport() {

        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to my online store!");
            System.out.println("Press any key to continue, or 'q' to quit.");

            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }

            System.out.println("You chose to continue. Let's go!!!");
            // Rest of the program logic here

            scanner.close();
        }
    }

}





