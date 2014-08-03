package com.thoughtworks.arianne.tictactoe;

public interface Player {
    void takeTurn();

    void printWinMessage();

    boolean didPlayerWin();
}
