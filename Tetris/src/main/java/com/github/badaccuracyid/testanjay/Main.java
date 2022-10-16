package com.github.badaccuracyid.testanjay;

import com.github.badaccuracyid.testanjay.tetrominos.TetrominoFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TetrisBoard board = new TetrisBoard();
        board.printBoard();
        board.spawnTetromino(TetrominoFactory.getRandomTetromino());

        Scanner scanner = new Scanner(System.in);

        String input;
        while (true) {
            input = scanner.nextLine();
            switch (input) {
                case "a" -> board.moveTetrominoLeft();
                case "d" -> board.moveTetrominoRight();
                case "s" -> board.moveTetrominoDown();
                case "w" -> board.rotateTetromino();
                case "q" -> System.exit(0);
            }
        }
    }


}
