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

    public boolean startTurn() {
        while (true) {
            console.promptForPlayerTurn(numPlayer);

            int validLocation = console.getPlayerMoveIfValid();

            if (board.isFreeLocation(validLocation)) {
                return makeMove(validLocation);
            }
        }
    }

    protected boolean makeMove(int validLocation) {
        boolean didPlayerWin = board.makeMoveWithSymbol(validLocation, symbol);
        board.draw();
        handleWin(didPlayerWin);
        return didPlayerWin;
    }

    private void handleWin(boolean didPlayerWin) {
        if (didPlayerWin) {
            console.displayWinMessage(numPlayer);
        }
    }
}
