package com.thoughtworks.arianne.tictactoe;

import java.util.List;

public class ComputerPlayer implements Player {
    private char symbol;
    private Board board;
    private Console console;

    public ComputerPlayer(Board board, char symbol, Console console) {
        this.symbol = symbol;
        this.board = board;
        this.console = console;
    }

    @Override
    public void takeTurn() {
        List<Integer> freeLocations = board.getFreeLocations();

        Integer move = freeLocations.get(0);
        makeMove(move);
    }

    private void makeMove(Integer move) {
        board.makeMoveWithSymbol(move, symbol);
        console.printMessage("Computer chose location " + move);
        board.draw();
    }

    @Override
    public void printWinMessage() {
        console.printMessage("Computer won! In yo face!");
    }

    @Override
    public boolean didPlayerWin() {
        return board.isWinningBoard(symbol);
    }
}
