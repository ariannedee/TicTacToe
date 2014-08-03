package com.thoughtworks.arianne.tictactoe;

public class Player {
    private char symbol;
    private int numPlayer;

    private Board board;
    private Console console;

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
                boolean didPlayerWin = board.makeMoveWithSymbol(validLocation, symbol);
                board.draw();
                return didPlayerWin;
            }
        }
    }
}
