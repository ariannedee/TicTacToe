package com.thoughtworks.arianne.tictactoe;

import java.io.PrintStream;

public class Board {
    private char[] gameState = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void draw() {
        String board = String.format(" %c | %c | %c\n" +
                        "-----------\n" +
                        " %c | %c | %c\n" +
                        "-----------\n" +
                        " %c | %c | %c", gameState[0], gameState[1], gameState[2], gameState[3], gameState[4],
                gameState[5], gameState[6], gameState[7], gameState[8]);
        printStream.println(board);
    }

    public void makeMoveForPlayer(int space, boolean isPlayer1) {
        char playerChar = isPlayer1? 'X' : 'O';
        gameState[space-1] = playerChar;
    }
}
