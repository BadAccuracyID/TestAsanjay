package com.github.badaccuracyid.testanjay;

import com.github.badaccuracyid.testanjay.tetrominos.TetrominoFactory;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    private static final AtomicBoolean autoMode = new AtomicBoolean(false);

    public static void main(String[] args) {
        TetrisBoard board = new TetrisBoard();
        board.printBoard();
        board.spawnTetromino(TetrominoFactory.getRandomTetromino());

        initAuto(board);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("auto")) {
                autoMode.set(!autoMode.get());
                continue;
            }

            // split input for each char
            String[] inputArray = input.split("");
            for (String s : inputArray) {
                switch (s) {
                    case "a" -> board.moveTetrominoLeft();
                    case "d" -> board.moveTetrominoRight();
                    case "s" -> board.moveTetrominoDown();
                    case "w" -> board.rotateTetromino();
                    case "q" -> System.exit(0);
                }
            }
        }
    }

    private static void initAuto(TetrisBoard board) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> {
                    if (autoMode.get()) {
                        board.moveTetrominoDown();
                    }
                }, 0, 1, TimeUnit.SECONDS);
    }

}
