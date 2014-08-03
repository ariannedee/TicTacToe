package com.thoughtworks.arianne.tictactoe;

import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(Board board, char symbol, int playerNum, Console console) {

        super(board, symbol, playerNum, console);
    }

    @Override
    public boolean startTurn() {
        List<Integer> freeLocations = board.getFreeLocations();

        Integer move = freeLocations.get(0);
        boolean didComputerWin = board.makeMoveWithSymbol(move, symbol);
        console.printMessage("Computer chose location " + move);

        board.draw();

        if (didComputerWin) {
            console.printMessage("Computer wins! Ha hah!");
        }

        return didComputerWin;
    }
}
