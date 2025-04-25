package ru.maikl.lec10;

import java.util.Arrays;

public class TicTacBoard implements Board, Position {
    private final Cell[][] fields = new Cell[3][3];
    private Cell turn;


    public TicTacBoard() {
        for (Cell[] row : fields) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Result makeMove(Move move) {
        fields[move.getRow()][move.getCol()] = move.getCell();
        if (!isValid(move)) {
            return Result.LOSE;
        }
        fields[move.getRow()][move.getCol()] = move.getCell();
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] == turn && fields[i][1] == turn && fields[i][2] == turn) {
                return Result.WIN;
            }
            if (fields[0][i] == turn && fields[1][i] == turn && fields[2][i] == turn) {
                return Result.WIN;
            }
            if (fields[0][0] == turn && fields[1][1] == turn && fields[2][2] == turn ||
                fields[0][2] == turn && fields[1][1] == turn && fields[2][0] == turn) {
                return Result.WIN;
            }
        }
        turn = turn == Cell.X ? Cell.O : Cell.X;
        int empty = 0;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (fields[r][c] == Cell.E) {
                    empty++;
                }
            }
        }

        return empty > 0 ? Result.UNKNOWN : Result.DRAW;
    }

    public boolean isValid(Move move) {
        return 0 <= move.getRow() && move.getRow() < 3 &&
               0 <= move.getCol() && move.getCol() < 3 &&
               fields[move.getRow()][move.getCol()] == Cell.E &&
               move.getCell() == turn;
    }
}
