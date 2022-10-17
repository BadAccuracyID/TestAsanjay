package com.github.badaccuracyid.testanjay.tetrominos;

import com.github.badaccuracyid.testanjay.tetrominos.impl.Tetromino1;

public abstract class Tetromino {

    public int rotation;
    public int x;
    public int y;
    public char[][][] shape;

    public void rotate() {
        rotation = (rotation + 1) % shape.length;
    }

    public void moveLeft() {
        this.x = x - 1;
    }

    public void moveRight() {
        this.x = x + 1;
    }

    public void moveDown() {
        this.y = y + 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public char[][] getTetrominoShape() {
        return shape[rotation];
    }

    abstract public int getHeight();

    abstract public int getWidth();

    // copy
    public Tetromino copy() {
        Tetromino copy = new Tetromino1();
        copy.rotation = this.rotation;
        copy.x = this.x;
        copy.y = this.y;
        copy.shape = this.shape;
        return copy;
    }
}
