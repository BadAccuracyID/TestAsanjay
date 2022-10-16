package com.github.badaccuracyid.testanjay.tetrominos;

import com.github.badaccuracyid.testanjay.tetrominos.impl.*;

public class TetrominoFactory {

    public static Tetromino getRandomTetromino() {
        int random = (int) (Math.random() * 6);
        return switch (random) {
            case 1 -> new Tetromino2();
            case 2 -> new Tetromino3();
            case 3 -> new Tetromino4();
            case 4 -> new Tetromino5();
            case 5 -> new Tetromino6();
            default -> new Tetromino1();
        };
    }
}
