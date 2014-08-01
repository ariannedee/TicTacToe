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

            if (takeTurn()) return true;
        }
    }

    private boolean takeTurn() {
        int validLocationOr0 = console.getPlayerMoveIfValid();

        if (validLocation(validLocationOr0)) {
            boolean locationAvailable = makeMove(validLocationOr0);
            if (locationAvailable) return true;
        }
        return false;
    }

    private boolean validLocation(int validLocationOr0) {
        return validLocationOr0 > 0;
    }

    private boolean makeMove(int move) {
        boolean validMove = board.makeMoveWithSymbol(move, symbol);
        return handleMove(validMove);
    }

    private boolean handleMove(boolean validMove) {
        if (validMove) {
            board.draw();
            return true;
        } else {
            console.printLocationTakenMessage();
            return false;
        }
    }
}
