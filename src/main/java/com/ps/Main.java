package com.ps;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);
        static ArrayList<LedgerScreen> date = new ArrayList<>();
        static ArrayList<LedgerScreen> time = new ArrayList<>();

    public static void main(String[] args) {

        int mainMenu;

        do{
            System.out.println("Welcome to the Accounting Ledger!");
            System.out.println("1) Add Deposit:");
            System.out.println("2) Make Payment:");
            System.out.println("3) Go to Ledger Page");
            System.out.println("0) Exit");
            System.out.println(" Please choose an option to continue.");
            mainMenu = scanner.nextInt();

            switch (mainMenu) {
                case 1:
                    displayDeposit();
                    break;
                case 2:
                    displayPayment();
                    break;
                case 3:
                    displayLedgerMenu();
                    break;
                case 0:
                    System.out.println("Wonderful! Let us help you with that!");
                    break;
                default:
                    System.out.println("Not found. Please try again.");

            }

        }while (mainMenu != 0);
    }

    private static void displayLedgerMenu() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transations.csv"));

            String input;

            while((input = bufferedReader.readLine()) != null){
                String[] fields = input.split("\\|");
                double date = Double.parseDouble(fields[0]);
                String time = fields[1];
                String description = fields[2];
                String vendor = fields[3];
                float amount = Float.parseFloat(fields[4]);



            }

            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void displayPayment() {
    }

    private static void displayDeposit() {
    }


}