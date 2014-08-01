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

    public boolean takeTurn() {
        while (true) {
            console.promptForPlayerTurn(numPlayer);

            int move = console.getValidMove();

            if (move == 0) return false;

            if (makeMove(move)) {
                board.draw();
                return true;

            } else {
                console.printLocationTakenMessage();
            }
        }
    }

    public boolean makeMove(int move) {
        return board.makeMoveWithSymbol(move, symbol);
    }
}
