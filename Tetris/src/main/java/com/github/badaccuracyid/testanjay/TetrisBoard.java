package com.github.badaccuracyid.testanjay;

import com.github.badaccuracyid.testanjay.tetrominos.Tetromino;
import com.github.badaccuracyid.testanjay.tetrominos.TetrominoFactory;

import java.io.IOException;

public class TetrisBoard {
    private final int[][] board;
    private final int width;
    private final int height;

    private Tetromino activeTetromino;
    private int score = 0;

    public TetrisBoard() {
        this.width = 20;
        this.height = 20;
        board = new int[width][height];
    }

    public void printBoard() {
        clearConsole();

        for (int i = -1; i <= width; i++) {
            System.out.print("#");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            System.out.print("#");
            for (int j = 0; j < width; j++) {
                if (board[j][i] == 0) {
                    System.out.print(" ");
                } else {
                    if (board[j][i] == '1') {
                        System.out.print("*");
                    } else if (board[j][i] == '2') {
                        System.out.print("0");
                    }
                }
            }

            System.out.print("#");
            switch (i) {
                case 6 -> System.out.println("        Your score is: " + score);
                case 8 -> System.out.println("        Press 'a' to move left");
                case 9 -> System.out.println("        Press 'd' to move right");
                case 10 -> System.out.println("        Press 's' to move down");
                case 11 -> System.out.println("        Press 'w' to rotate");
                case 12 -> System.out.println("        Press 'q' to quit");
                case 13 ->
                        System.out.println("        Press 'auto' to toggle auto mode [" + (Main.autoMode.get() ? "ON" : "OFF") + "]");
                default -> System.out.println();
            }
        }

        for (int i = -1; i <= width; i++) {
            System.out.print("#");
        }
        System.out.println();
        System.out.println();
        System.out.print(">> ");
    }


    public void spawnTetromino(Tetromino tetromino) {
        this.activeTetromino = tetromino;

        // check collision of newly spawned tetromino
        Tetromino copy = tetromino.copy();

        char[][] copyTetrominoShape = copy.getTetrominoShape();
        int copyTetrominoX = copy.getX();
        int copyTetrominoY = copy.getY();

        for (int i = 0; i < copyTetrominoShape.length; i++) {
            for (int j = 0; j < copyTetrominoShape[i].length; j++) {
                if (copyTetrominoShape[i][j] != ' ') {
                    if (board[copyTetrominoX + i][copyTetrominoY + j] == '2') {
                        printAtBoard(tetromino, '1');
                        printBoard();

                        System.out.println();
                        System.out.println(" ========= ");
                        System.out.println("Game over!");
                        System.out.println(" ========= ");
                        System.out.println();
                        System.exit(0);
                        return;
                    }
                }
            }
        }

        printAtBoard(tetromino, '1');
        printBoard();
    }

    private void printAtBoard(Tetromino tetromino, char x) {
        char[][] tetrominoShape = tetromino.getTetrominoShape();
        int tetrominoX = tetromino.getX();
        int tetrominoY = tetromino.getY();

        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    board[tetrominoX + i][tetrominoY + j] = x;
                }
            }
        }
    }

    public void spawnFixedTetromino(Tetromino tetromino) {
        this.activeTetromino = tetromino;
        printAtBoard(tetromino, '2');
        printBoard();
    }

    private void clearConsole() {
        try {
            String os = System.getProperty("os.name");

            Process start;
            if (os.contains("windows")) {
                ProcessBuilder processBuilder;
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
                start = processBuilder.start();
            } else {
                ProcessBuilder processBuilder;
                processBuilder = new ProcessBuilder("clear");
                start = processBuilder.inheritIO().start();
            }

            start.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveTetrominoLeft() {
        char[][] tetrominoShape = this.activeTetromino.getTetrominoShape();
        int tetrominoX = this.activeTetromino.getX();
        int tetrominoY = this.activeTetromino.getY();

        // check bounds
        if (this.activeTetromino.getX() - 1 < 0) {
            this.spawnTetromino(this.activeTetromino);
            return;
        }

        // check collision
        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    if (board[tetrominoX + i - 1][tetrominoY + j] == '2') {
                        this.spawnTetromino(this.activeTetromino);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    board[tetrominoX + i][tetrominoY + j] = 0;
                }
            }
        }

        this.activeTetromino.moveLeft();
        this.spawnTetromino(this.activeTetromino);
    }

    public void moveTetrominoRight() {
        char[][] tetrominoShape = this.activeTetromino.getTetrominoShape();
        int tetrominoX = this.activeTetromino.getX();
        int tetrominoY = this.activeTetromino.getY();

        // check bounds
        if (this.activeTetromino.getX() + this.activeTetromino.getWidth() + 1 > width) {
            this.spawnTetromino(this.activeTetromino);
            return;
        }

        // check collision
        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    if (board[tetrominoX + i + 1][tetrominoY + j] == '2') {
                        this.spawnTetromino(this.activeTetromino);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    board[tetrominoX + i][tetrominoY + j] = 0;
                }
            }
        }


        this.activeTetromino.moveRight();
        this.spawnTetromino(this.activeTetromino);
    }

    public void moveTetrominoDown() {
        char[][] tetrominoShape = this.activeTetromino.getTetrominoShape();
        int tetrominoX = this.activeTetromino.getX();
        int tetrominoY = this.activeTetromino.getY();

        // clears old tetromino
        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    board[tetrominoX + i][tetrominoY + j] = 0;
                }
            }
        }

        if (tetrominoY + this.activeTetromino.getHeight() > height - 1) {
            this.spawnFixedTetromino(this.activeTetromino);
            this.checkForFullColumns();

            this.spawnTetromino(TetrominoFactory.getRandomTetromino());
        } else {
            // check for collision
            for (int i = 0; i < tetrominoShape.length; i++) {
                for (int j = 0; j < tetrominoShape[i].length; j++) {
                    if (tetrominoShape[i][j] != ' ') {
                        if (board[tetrominoX + i][tetrominoY + j + 1] == '2') {
                            this.spawnFixedTetromino(this.activeTetromino);
                            this.checkForFullColumns();

                            this.spawnTetromino(TetrominoFactory.getRandomTetromino());
                            return;
                        }
                    }
                }
            }
            this.activeTetromino.moveDown();
            this.spawnTetromino(this.activeTetromino);
        }
    }

    public void rotateTetromino() {
        char[][] tetrominoShape = this.activeTetromino.getTetrominoShape();
        int tetrominoX = this.activeTetromino.getX();
        int tetrominoY = this.activeTetromino.getY();

        // check bounds
        Tetromino copy = this.activeTetromino.copy();
        copy.rotate();
        if (copy.getX() + copy.getWidth() > width) {
            this.spawnTetromino(this.activeTetromino);
            return;
        }
        if (copy.getY() + copy.getHeight() > height) {
            this.spawnTetromino(this.activeTetromino);
            return;
        }

        // check collision of copy
        char[][] copyTetrominoShape = copy.getTetrominoShape();
        for (int i = 0; i < copyTetrominoShape.length; i++) {
            for (int j = 0; j < copyTetrominoShape[i].length; j++) {
                if (copyTetrominoShape[i][j] != ' ') {
                    if (copy.getX() + i > width - 1 || copy.getY() + j > height - 1) {
                        this.spawnTetromino(this.activeTetromino);
                        return;
                    }
                    if (board[copy.getX() + i][copy.getY() + j] == '2') {
                        this.spawnTetromino(this.activeTetromino);
                        return;
                    }
                }
            }
        }

        for (int i = 0; i < tetrominoShape.length; i++) {
            for (int j = 0; j < tetrominoShape[i].length; j++) {
                if (tetrominoShape[i][j] != ' ') {
                    board[tetrominoX + i][tetrominoY + j] = 0;
                }
            }
        }

        this.activeTetromino.rotate();
        this.spawnTetromino(this.activeTetromino);
    }

    public void checkForFullColumns() {
        for (int i = 0; i < board[0].length; i++) {
            boolean isFull = true;
            for (int[] ints : board) {
                if (ints[i] != '2') {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                this.score += 500;
                // pull from row higher
                for (int j = i; j > 0; j--) {
                    for (int k = 0; k < board.length; k++) {
                        board[k][j] = board[k][j - 1];
                    }
                }
            }
        }
    }

}
