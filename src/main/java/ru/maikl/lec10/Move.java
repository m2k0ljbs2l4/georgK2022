package ru.maikl.lec10;

public class Move {
    private int row;
    private int col;
    private Cell cell;

    public Move(int row, int col, Cell cell) {
        this.row = row;
        this.col = col;
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Cell getCell() {
        return cell;
    }
}
