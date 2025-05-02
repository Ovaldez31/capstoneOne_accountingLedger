package com.ps;
import java.util.Scanner;

public class HomeScreen {

    static Scanner scanner = new Scanner(System.in);
    static boolean insertTransaction = true;

    public static void main(String[] args) {
        boolean mainOption = true;

        int option;
        do {
            System.out.println("---\nWelcome to the General Ledger!\n---");
            System.out.println("1) Add Deposit");
            System.out.println("2) Make Payment");
            System.out.println("3) Go to Ledger");
            System.out.println("0) Exit");
            System.out.println(" Please enter the option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addDeposit();
                    break;
                case 2:
                    makePayment();
                    break;
                case 3:
                    ledgerScreen();
                    break;
                case 0:
                    System.out.println("Have a good one!");
                    break;
                default:
                    System.out.println("Invalid. Please try again.");

            }

        } while (option != 0);

    }

    private static void addDeposit() {
        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter deposit amount: ");
        String depositAmount = scanner.nextLine();

        System.out.println("Deposit saved successfully");
        System.out.println("Thank you!");
        float amount = Float.parseFloat(scanner.nextLine());
    }

    private static void makePayment() {

        System.out.println("Enter vendor: ");
        String vendor = scanner.nextLine();

        System.out.println("Enter payment amount: ");
        String paymentAmount = scanner.nextLine();

        System.out.println("Payment successful!");
        System.out.println("Thank you!");
        float amount = Float.parseFloat(scanner.nextLine());

    }

    public static void ledgerScreen () {
        LedgerScreen ledgerScreenInstance = new LedgerScreen();
    }


}



