package com.life.lifegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOfLife extends Application {

    private static final int CELL_SIZE = 1;      // Pixel size of each cell
    private static final int BOARD_WIDTH = 800;    // Number of columns
    private static final int BOARD_HEIGHT = 800;   // Number of rows

    private boolean[][] board = new boolean[BOARD_HEIGHT][BOARD_WIDTH];
    private Board gameBoard;
    private int generation = 0;                   // Generation counter
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        initializeGenesisState();

        gameBoard = new Board(BOARD_WIDTH * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE);
        gameBoard.drawBoard(board);

        Label timerLabel = new Label("Generation: " + generation);
        timerLabel.setPadding(new Insets(5));

        Button stopButton = new Button("Stop");
        Button resumeButton = new Button("Resume");

        stopButton.setOnAction(e -> {
            if (timeline != null) {
                timeline.pause();
            }
        });

        resumeButton.setOnAction(e -> {
            if (timeline != null) {
                timeline.play();
            }
        });


        Slider speedSlider = new Slider(0.1, 3.0, 1.0);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        speedSlider.setMajorTickUnit(0.5);
        speedSlider.setBlockIncrement(0.1);

        Label speedLabel = new Label("Speed: " + String.format("%.1f", speedSlider.getValue()));

        speedSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (timeline != null) {
                timeline.setRate(newVal.doubleValue());
            }
            speedLabel.setText("Speed: " + String.format("%.1f", newVal.doubleValue()));
        });

        HBox bottomControls = new HBox(10);
        bottomControls.setPadding(new Insets(5));
        bottomControls.getChildren().addAll(timerLabel, stopButton, resumeButton, speedLabel, speedSlider);

        BorderPane root = new BorderPane();
        root.setCenter(gameBoard);
        root.setBottom(bottomControls);

        Scene scene = new Scene(root, BOARD_WIDTH * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE + 50);
        primaryStage.setTitle("Game Of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            board = nextGeneration(board);
            generation++;
            timerLabel.setText("Generation: " + generation);
            gameBoard.drawBoard(board);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void initializeGenesisState() {
        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                board[row][col] = Math.random() < 0.2;
            }
        }
    }

    private boolean[][] nextGeneration(boolean[][] currentBoard) {
        boolean[][] nextBoard = new boolean[BOARD_HEIGHT][BOARD_WIDTH];

        for (int row = 0; row < BOARD_HEIGHT; row++) {
            for (int col = 0; col < BOARD_WIDTH; col++) {
                int liveNeighbors = countLiveNeighbors(currentBoard, row, col);

                if (currentBoard[row][col]) {
                    nextBoard[row][col] = (liveNeighbors == 2 || liveNeighbors == 3);
                } else {
                    nextBoard[row][col] = (liveNeighbors == 3);
                }
            }
        }
        return nextBoard;
    }

    private int countLiveNeighbors(boolean[][] board, int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < BOARD_HEIGHT && c >= 0 && c < BOARD_WIDTH && board[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        launch(args);
    }
}