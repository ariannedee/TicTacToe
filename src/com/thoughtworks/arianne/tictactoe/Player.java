package com.thoughtworks.arianne.tictactoe;

public class Player {
    private char symbol;
    private Board board;
    public int numPlayer;

    public Player(Board board, char symbol, int numPlayer) {
        this.board = board;
        this.symbol = symbol;
        this.numPlayer = numPlayer;
    }

    public void takeTurn() {
    }

    public boolean makeMove(int move) {
        return board.makeMoveWithSymbol(move, symbol);
    }

    public int numPlayer() {
        return numPlayer;
    }
}
