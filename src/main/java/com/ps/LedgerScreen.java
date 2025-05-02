package com.ps;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LedgerScreen {
    public static void main(String[] args) {
    }

    static String fileName = "transaction.csv";
    static boolean backToHome = false;
    static Scanner scanner = new Scanner(System.in);

    public LedgerScreen() {

        int option;

        System.out.println("\n--- Ledger Menu ---\n");
        System.out.println("1) All");
        System.out.println("2) Deposits");
        System.out.println("3) Payments");
        System.out.println("4) Reports");
        System.out.println("0) Back to Home Screen");
        System.out.println("Enter your option: ");


        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                showAllLedgers();
                break;
            case 2:
                showDeposits();
                break;
            case 3:
                showPayments();
                break;
            case 4:
                showReports();
                break;
            case 0:
                backToHome = true;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

    }
    private void showAllLedgers() {

        String allTransactions = fileName;
        if (allTransactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;

        }
        int option;
        System.out.println("\n--- All Ledgers ---\n");
        System.out.println("1) Date: ");
        System.out.println("0) Home");
        System.out.println("Please chose an option");
        option = scanner.nextInt();
        scanner.nextLine();


        switch (option) {
            case 1:
                System.out.printf("%-12s %-10s %-25s %-10s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println(allTransactions);
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] tx = line.split("\\|");
                        if (tx.length >= 5) {
                            System.out.printf("%-12s %-10s %-25s %-20s %10s%n",
                                    tx[0], tx[1], tx[2], tx[3], tx[4]);
                        }
                    }
                } catch (IOException e) {

                }
                break;

            case 0:
                System.out.println("Going back to Ledger Menu...");
                new LedgerScreen(); // Re-display the main menu
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                showAllLedgers();
        }
    }
    private void showDeposits() {
        System.out.println("\n--- All Deposits ---");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("------------------------------------------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tx = line.split("\\|");
                if (tx.length >= 5) {
                    float amount = Float.parseFloat(tx[4]);
                    if (amount > 0) {
                        System.out.printf("%-12s %-10s %-25s %-20s %10.2f%n",
                                tx[0], tx[1], tx[2], tx[3], amount);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }


    }

    private void showPayments() {
        System.out.println("\n--- All Payments ---");
        System.out.printf("%-12s %-10s %-25s %-20s %10s%n", "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("------------------------------------------------------------------------------------");

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tx = line.split("\\|");
                if (tx.length >= 5) {
                    double amount = Double.parseDouble(tx[4]);
                    if (amount < 0) {
                        System.out.printf("%-12s %-10s %-25s %-20s %10.2f%n",
                                tx[0], tx[1], tx[2], tx[3], amount);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void showReports () {
        ReportsScreen reportsScreenInstance = new ReportsScreen();
    }

    /// /////////////////////////

    private String date;
    private String time;
    private String vendor;
    private String type;
    private float amount;

    public void transaction(String date, String time, String vendor, String type, float amount) {
        this.date = date;
        this.time = time;
        this.vendor = vendor;
        this.type = type;
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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return String.format("%-12s %-10s %-20s %-10.2f%n", date, time, vendor, amount);
    }

}


//            System.out.println("\n--- Transactions for Vendor: " + searchVendor + " ---");
//            System.out.printf("%-12s %-10s %-20s %-10s %-10s%n", "Date", "Time", "Description", "Deposit", "Payment");
//            System.out.println("------------------------------------------------------------------");
