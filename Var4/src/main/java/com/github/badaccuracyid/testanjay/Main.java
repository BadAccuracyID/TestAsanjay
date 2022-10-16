package com.github.badaccuracyid.testanjay;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println();
            System.out.println("- BlueJackets 23-1 -");
            System.out.println(" Alongside courage and perseverance, we shape define our future.");
            System.out.println();
        }));

        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
    }

    private static void mainMenu(Scanner scanner) {
        System.out.println("Foda Shop");
        System.out.println("=============");
        System.out.println("1. Top up E-Wallet");
        System.out.println("2. Exit");
        System.out.print(">> ");

        int choice = scanner.nextInt();
        while (true) {
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice");
                System.out.print(">> ");
                choice = scanner.nextInt();
            } else {
                break;
            }
        }

        if (choice == 1) {
            topUp(scanner);
        } else {
            System.exit(0);
        }
    }

    private static void topUp(Scanner scanner) {
        System.out.println("Foda Wallet");
        System.out.println("=============");
        System.out.println("1. Buy E-Wallet");
        System.out.println("2. Back to Main Menu");
        System.out.print(">> ");

        int choice = scanner.nextInt();
        while (true) {
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice");
                System.out.print(">> ");
                choice = scanner.nextInt();
            } else {
                break;
            }
        }

        if (choice == 1) {
            buyEWallet(scanner);
        } else {
            mainMenu(scanner);
        }
    }

    private static void buyEWallet(Scanner scanner) {
        System.out.print("Input your email: ");
        String email = scanner.next();
        while (true) {
            if (validateEmail(email)) {
                break;
            } else {
                System.out.print("Input your email: ");
                email = scanner.next();
            }
        }

        System.out.print("Input Your Account Name: ");
        String accountName = scanner.next();
        while (true) {
            if (validateAccountName(accountName)) {
                break;
            } else {
                System.out.print("Input Your Account Name: ");
                accountName = scanner.next();
            }
        }

        System.out.print("Choose Voucher [50000 | 100000 | 1000000]: ");
        String voucher = scanner.next();
        while (true) {
            if (validateVoucher(voucher)) {
                break;
            } else {
                System.out.print("Choose Voucher [50000 | 100000 | 1000000]: ");
                voucher = scanner.next();
            }
        }

        printEWallet(email, accountName, voucher);
    }

    private static boolean validateEmail(String email) {
        if (!email.contains("@")) {
            System.out.println("Email must contain @");
            return false;
        } else if (email.startsWith("@")) {
            System.out.println("Email must not start with @");
            return false;
        } else if (!email.endsWith("gmail.com")) {
            System.out.println("Email must end with gmail.com");
            return false;
        }

        return true;
    }

    private static boolean validateAccountName(String accountName) {
        if (accountName.length() < 10) {
            System.out.println("Account Name must be at least 10 characters!");
            return false;
        }
        return true;
    }

    private static boolean validateVoucher(String voucher) {
        if (!voucher.equals("50000") && !voucher.equals("100000") && !voucher.equals("1000000")) {
            System.out.println("Voucher doesn't exist!");
            return false;
        }

        return true;
    }

    private static void printEWallet(String email, String accountName, String voucher) {
        System.out.println("New Transaction");
        System.out.println("=============");
        System.out.println("Email        : " + email);
        System.out.println("Account Name : " + accountName);
        System.out.println("Voucher      : " + voucher);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }

        System.exit(0);
    }

}
