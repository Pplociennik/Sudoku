package pl.sudoku.game.entities;

import java.util.Arrays;

public class Board {

    private int height;
    private int width;
    private int[][] values;
    private int[][] resultBoard;

    public Board(int[][] values) {
        this.values = values;
    }

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.values = new int[height][width];
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
    }

    public int[][] getResultBoard() {
        return resultBoard;
    }

    public void setResultBoard(int[][] resultBoard) {
        this.resultBoard = resultBoard;
    }

    public int getSpecificValue(int height, int width) {
        return this.values[height][width];
    }

    public void setSpecificValue(int height, int width, int value) {
        this.values[height][width] = value;
    }

    public boolean checkIfEquals(int[][] toCompare) {
        return Arrays.deepEquals(this.values, toCompare);
    }
}
