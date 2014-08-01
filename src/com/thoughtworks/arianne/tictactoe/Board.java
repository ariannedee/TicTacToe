package com.thoughtworks.arianne.tictactoe;

import java.io.PrintStream;

public class Board {
    private char[] gameState;
    private PrintStream printStream;

    public Board(PrintStream printStream, char[] gameState) {
        this.printStream = printStream;
        this.gameState = gameState;
    }

    public void draw() {
        String board = String.format(" %c | %c | %c\n" +
                        "-----------\n" +
                        " %c | %c | %c\n" +
                        "-----------\n" +
                        " %c | %c | %c\n", gameState[0], gameState[1], gameState[2], gameState[3], gameState[4],
                gameState[5], gameState[6], gameState[7], gameState[8]);
        printStream.println(board);
    }

    public boolean makeMoveWithSymbol(int location, char symbol) {
        if (gameState[location-1] == ' ') {
            gameState[location - 1] = symbol;
            return true;
        }
        return false;
    }

    public boolean isFilled() {
        for (char c : gameState) {
            if (c == ' ') {
                return false;
            }
        }

        printStream.println("Game is a draw");
        return true;
    }
}
