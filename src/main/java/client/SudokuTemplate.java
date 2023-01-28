package client;

import java.io.Serializable;

public class SudokuTemplate implements Serializable {

    //	private static final long serialVersionUID = 1L;
    private String id;
    private String difficulty;
    private int[][] grid;

    public SudokuTemplate() {}

    public String getId() {
        return this.id;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setGridPoint(int i, int j, int value) {
        this.grid[i][j] = value;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }



}
