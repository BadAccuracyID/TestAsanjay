package com.github.badaccuracyid.testanjay.tetrominos.impl;

import com.github.badaccuracyid.testanjay.tetrominos.Tetromino;

public class Tetromino1 extends Tetromino {

    public Tetromino1() {
        this.rotation = 0;
        this.x = 9;
        this.y = 0;
        this.shape = new char[][][]{
                {
                        {'*', '*', '*', '*'}
                },
                {
                        {'*'},
                        {'*'},
                        {'*'},
                        {'*'}
                }
        };
    }

    @Override
    public int getHeight() {
        if (rotation == 0) {
            return 4;
        } else {
            return 1;
        }
    }

    @Override
    public int getWidth() {
        if (rotation == 0) {
            return 1;
        } else {
            return 4;
        }
    }

}
