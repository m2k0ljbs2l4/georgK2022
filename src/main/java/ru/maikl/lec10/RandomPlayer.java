package ru.maikl.lec10;

import java.util.Random;

public class RandomPlayer implements Player {
    private final Random rand = new Random();

    @Override
    public Move move(Position position) {
        while (true) {
            final Move move = new Move(
                    rand.nextInt(3),
                    rand.nextInt(3),
                    position.getTurn()
            );
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
