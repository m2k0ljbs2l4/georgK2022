package ru.maikl.lec10;

public class Game {
    Player player1;
    Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public int play(final Board board) {
        while (true) {
            final int result1 = makeMove(board, player1, 1);
            if (result1 >= 0) {
                return result1;
            }
            final int result2 = makeMove(board, player2, 2);
            if (result2 >= 0) {
                return result2;
            }
        }
    }

    private static int makeMove(Board board, Player player, int no) {
        Move move = player.move(board.getPosition());
        Result result = board.makeMove(move);
        if (result == Result.WIN) {
            return no;
        } else if (result == Result.LOSE) {
            return 3 - no;
        } else if (result == Result.DRAW) {
            return 0;
        } else {
            return -1;
        }
    }


}
