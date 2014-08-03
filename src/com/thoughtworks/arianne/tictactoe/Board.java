package com.thoughtworks.arianne.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isWinningBoard(char symbol) {
        boolean boardIsWon = false;
        for (int i=0; i<3; i++) {
            boardIsWon = boardIsWon || checkRow(i, symbol);
            boardIsWon = boardIsWon || checkColumn(i, symbol);
        }

        return boardIsWon || checkDiagonal1(symbol) || checkDiagonal2(symbol);
    }

    public List<Integer> getFreeLocations() {
        List<Integer> freeLocations = new ArrayList<Integer>();

        for (int i = 0; i<gameState.length; i++) {
            if (gameState[i] == ' ') {
                freeLocations.add(i+1);
            }
        }

        return freeLocations;
    }

    private boolean checkLineMatchesSymbol(List<Integer> indicesToCheck, char symbol) {
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

        List<Integer> indicesToCheck = new ArrayList(Arrays.asList(first, second, third));

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkColumn(int column, char symbol) {
        int first = column;
        int second = first+3;
        int third = second+3;

        List<Integer> indicesToCheck = new ArrayList(Arrays.asList(first, second, third));

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkDiagonal1(char symbol) {
        List<Integer> indicesToCheck = new ArrayList(Arrays.asList(0, 4, 8));

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    private boolean checkDiagonal2(char symbol) {
        List<Integer> indicesToCheck = new ArrayList(Arrays.asList(2, 4, 6));

        return checkLineMatchesSymbol(indicesToCheck, symbol);
    }

    public void printIsDrawMessage() {
        printStream.println("Game is a draw");
    }

    public int getWinningMove(char symbol) {
        List<Integer> freeLocations = getFreeLocations();
        for (Integer location : freeLocations) {
            if (wouldWinGame(location, symbol)) {
                return location;
            }
        }
        return 0;
    }

    private boolean wouldWinGame(Integer location, char symbol) {
        int index = location-1;
        int row = index/3;
        int column = index%3;

        List<Integer> rowToCheck = new ArrayList<Integer>(Arrays.asList(row*3, row*3+1, row*3+2));
        rowToCheck.remove(column);

        List<Integer> columnToCheck = new ArrayList<Integer>(Arrays.asList(column, column+3, column+6));
        columnToCheck.remove(row);

        boolean result = false;
        result = result || checkLineMatchesSymbol(rowToCheck, symbol);
        result = result || checkLineMatchesSymbol(columnToCheck, symbol);

        if (row == column) {
            List<Integer> diagonalToCheck = new ArrayList<Integer>(Arrays.asList(0, 4, 8));
            diagonalToCheck.remove(row);
            result = result || checkLineMatchesSymbol(diagonalToCheck, symbol);
        }

        if (row+column == 2) {
            List<Integer> diagonalToCheck = new ArrayList<Integer>(Arrays.asList(2, 4, 6));
            diagonalToCheck.remove(row);
            result = result || checkLineMatchesSymbol(diagonalToCheck, symbol);
        }

        return result;
    }
}
