package ru.maikl.lec10;

public class Lec5Main {
    public static void main(String[] args) {
        Player player1 = new RandomPlayer();
        Player player2 = new SeqPlayer();

        new Game(player1, player2).play(new TicTacBoard());
    }
}
