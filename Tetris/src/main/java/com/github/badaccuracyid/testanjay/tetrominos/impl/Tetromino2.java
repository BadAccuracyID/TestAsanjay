package com.github.badaccuracyid.testanjay.tetrominos.impl;

import com.github.badaccuracyid.testanjay.tetrominos.Tetromino;

public class Tetromino2 extends Tetromino {

    public Tetromino2() {
        this.rotation = 0;
        this.x = 9;
        this.y = 0;
        this.shape = new char[][][]{
                {
                        {'*', '*', ' '},
                        {' ', '*', '*'}
                },
                {
                        {'*', ' '},
                        {'*', '*'},
                        {' ', '*'}
                },
                {
                        {' ', '*', '*'},
                        {'*', '*', ' '}
                },
                {
                        {' ', '*'},
                        {'*', '*'},
                        {'*', ' '}
                }
        };
    }

    @Override
    public char[][] getTetrominoShape() {
        return shape[rotation];
    }

    @Override
    public int getHeight() {
        if (rotation == 0 || rotation == 2) {
            return 3;
        } else {
            return 2;
        }
    }

    @Override
    public int getWidth() {
        if (rotation == 0 || rotation == 2) {
            return 2;
        } else {
            return 3;
        }
    }

}