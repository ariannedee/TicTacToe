package com.thoughtworks.arianne.tictactoe;

import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(Board board, char symbol, int playerNum, Console console) {

        super(board, symbol, playerNum, console);
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
}
