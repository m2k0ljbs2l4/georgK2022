package ru.maikl.lec10;

public class SeqPlayer implements Player {


    @Override
    public Move move(Position position) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                final Move move = new Move(r, c, position.getTurn());
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new RuntimeException("Move not valid");
    }
}
