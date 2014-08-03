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

            return checkForWin(location, symbol);
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

    public boolean isFreeLocation(int location) {
        int index = location-1;
        if (index >= 0 && index < gameState.length) {
            if (gameState[location-1] == ' ') {
                return true;
            } else {
                printStream.println("Location is taken!\n");
            }
        }

        return false;
    }

    private boolean checkForWin(int location, char symbol) {
        int index = location-1;
        int row = index/3;
        int column = index%3;

        boolean win;

        win = checkRow(row, symbol);
        win = win || checkColumn(column, symbol);
        if (row == column) {
            win = win || checkDiagonal1(symbol);
        }
        if (row+column == 2) {
            win = win || checkDiagonal2(symbol);
        }
        return win;
    }

    private boolean checkLineMatchesSymbol(int[] indicesToCheck, char symbol) {
        boolean result = true;

        for (int index : indicesToCheck) {
            result = result && gameState[index] == symbol;
        }

        return result;
    }

    private boolean checkRow(int row, char symbol) {
        int first = row*3;
        int second = first+1;
        int third = second+1;

        int[] indicesToCheck = {first, second, third};

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkColumn(int column, char symbol) {
        int first = column;
        int second = first+3;
        int third = second+3;

        int[] indicesToCheck = {first, second, third};

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkDiagonal1(char symbol) {
        int[] indicesToCheck = {0, 4, 8};

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkDiagonal2(char symbol) {
        int[] indicesToCheck = {2, 4, 6};

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }
}
