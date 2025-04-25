package ru.maikl.lec10;

public interface Board {
    Position getPosition();

    Result makeMove(Move move);
}
