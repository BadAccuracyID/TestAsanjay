package com.github.badaccuracyid.testanjay.tetrominos.impl;

import com.github.badaccuracyid.testanjay.tetrominos.Tetromino;

public class Tetromino6 extends Tetromino {

    public Tetromino6() {
        this.rotation = 0;
        this.x = 9;
        this.y = 0;
        this.shape = new char[][][]{
                {
                        {'*', '*'},
                        {'*', '*'}
                }
        };
    }

    @Override
    public void rotate() {
        rotation = 0;
    }

    @Override
    public char[][] getTetrominoShape() {
        return shape[rotation];
    }

    @Override
    public int getHeight() {
        return 2;
    }

    @Override
    public int getWidth() {
        return 2;
    }

}
