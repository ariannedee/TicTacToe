package com.thoughtworks.arianne.tictactoe;

public class Player {
    protected char symbol;
    private int numPlayer;

    protected Board board;
    protected Console console;

    public Player(Board board, char symbol, int numPlayer, Console console) {
        this.board = board;
        this.symbol = symbol;
        this.numPlayer = numPlayer;
        this.console = console;
    }

    public void takeTurn() {
        boolean turnInProgress = true;
        while (turnInProgress) {
            console.printPrompt("Player " + numPlayer + ", enter a number from 1-9");

            int validLocation = console.getPlayerMoveIfValid();

            if (board.isFreeLocation(validLocation)) {
                makeMove(validLocation);
                turnInProgress = false;
            }
        }
    }

    private void makeMove(int validLocation) {
        board.makeMoveWithSymbol(validLocation, symbol);
        board.draw();
    }

    public void printWinMessage() {
        console.printMessage("Player " + numPlayer + " won!");
    }

    public boolean didPlayerWin() {
        return board.isWinningBoard(symbol);
    }
}
