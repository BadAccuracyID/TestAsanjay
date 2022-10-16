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
        int inputLength = scanner.nextInt();

        String input = scanner.next();
        input = input.chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        inputLength = input.length();
        int timesDivided = 0;
        while (inputLength >= 4) {
            inputLength -= 4;
            timesDivided++;
        }

        if (inputLength == 0) {
            System.out.println(timesDivided);
        } else {
            System.out.println(timesDivided + 1);
        }
    }

}
