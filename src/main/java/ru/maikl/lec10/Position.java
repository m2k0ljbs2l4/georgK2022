package ru.maikl.lec10;

public interface Position {
    Cell getTurn();

    boolean isValid(Move move);
}
