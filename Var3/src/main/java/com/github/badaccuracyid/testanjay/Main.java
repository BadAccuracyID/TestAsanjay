package com.github.badaccuracyid.testanjay;

import java.util.Scanner;

public class Main {

    /*
     * NOT MINE
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of one side of the block: ");
        int a = scanner.nextInt();
        int n = (a + 1) + ((a * 3) + 1) + (a * 2);
        int m = a + 1 + (a * 2);

        int[] space = {a, 1, (2 * a), (3 * a) + 1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < space[0]) {
                    System.out.print(" ");
                }

                if (i == 0 && j > a && j < (a + 1) + ((a * 3) + 1)) {
                    System.out.print("_");
                }

                if (i > 0 && i <= a) {
                    if (j > space[0] && j < space[0] + space[1]) {
                        System.out.print(" ");
                    } else if (j == space[0]) {
                        System.out.print("/");
                    } else if (j == space[0] + space[1]) {
                        System.out.print("\\");
                    } else if (j > space[0] + space[1] && j < space[0] + space[1] + space[3]) {
                        System.out.print(" ");
                    } else if (j == space[0] + space[1] + space[3]) {
                        System.out.print("\\");
                    }
                } else if (i > (2 * a)) {
                    if (j > space[0] && j < space[0] + space[1]) {
                        System.out.print(" ");
                    } else if (j == space[0]) {
                        System.out.print("\\");
                    } else if (j == space[0] + space[1]) {
                        System.out.print("/");
                    } else if (j > space[0] + space[1] && j < space[0] + space[1] + space[3]) {
                        if (i == m - 1) {
                            System.out.print("_");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (j == space[0] + space[1] + space[3]) {
                        System.out.print("/");
                    }
                } else if (i > a && i <= (2 * a)) {
                    if (j > space[0] && j < space[0] + space[2]) {
                        System.out.print(" ");
                    } else if (j == space[0]) {
                        System.out.print("\\");
                    } else if (j == space[0] + space[2]) {
                        System.out.print("\\");
                    } else if (j > space[0] + space[2] && j < space[0] + space[2] + space[3]) {
                        if (i == 2 * a) {
                            System.out.print("_");
                        } else {
                            System.out.print(" ");
                        }
                    } else if (j == space[0] + space[2] + space[3]) {
                        System.out.print("\\");
                    }
                }
            }

            if (i > a) {
                space[0]++;
            } else if (i < a) {
                space[0]--;
            }

            if (i > 0 && i < a) {
                space[1] += 2;
            } else if (i >= m - a && i <= m) {
                space[1] -= 2;
            }

            System.out.println();
        }
    }

}
