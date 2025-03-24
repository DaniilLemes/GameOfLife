package com.life.lifegame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

class Board extends Canvas {
    public Board(double width, double height) {
        super(width, height);
    }

    public void drawBoard(boolean[][] board) {
        GraphicsContext gc = this.getGraphicsContext2D();
        double cellWidth = getWidth() / board[0].length;
        double cellHeight = getHeight() / board.length;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col]) {
                    gc.setFill(Color.WHEAT);
                } else {
                    gc.setFill(Color.BLACK);
                }
                gc.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }
}