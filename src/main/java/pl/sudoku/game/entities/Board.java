package pl.sudoku.game.entities;

import java.util.Arrays;

public class Board {

    private int[][] values;

    public Board(int[][] values) {
        this.values = values;
    }

    public Board(int size) {
        this.values = new int[size][size];
    }


    public int[][] getValues() {
        return values;
    }

    public void setValues(int[][] values) {
        this.values = values;
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
