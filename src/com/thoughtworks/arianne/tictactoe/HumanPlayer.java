package com.thoughtworks.arianne.tictactoe;

public class HumanPlayer implements Player {
    protected char symbol;
    private int numPlayer;

    protected Board board;
    protected Console console;

    public HumanPlayer(Board board, char symbol, int numPlayer, Console console) {
        this.board = board;
        this.symbol = symbol;
        this.numPlayer = numPlayer;
        this.console = console;
    }

    @Override
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

    @Override
    public void printWinMessage() {
        console.printMessage("Player " + numPlayer + " won!");
    }

    @Override
    public boolean didPlayerWin() {
        return board.isWinningBoard(symbol);
    }
}
