package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;

    public TicTacToe(PrintStream printStream, BufferedReader bufferedReader, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }

    public void start() {
        board.draw();
        boolean isPlayer1 = true, gameInProgress = true;

        while(gameInProgress) {
            gameInProgress = newTurn(isPlayer1);
            isPlayer1 = !isPlayer1;
        }
    }

    public boolean newTurn(boolean isPlayer1) {
        int player = isPlayer1? 1 : 2;

        printPrompt(player);
        int move = getPlayerMoveInput();
        if (move == 0) return false;
        board.makeMoveForPlayer(move, isPlayer1);
        board.draw();

        return true;
    }

    private int getPlayerMoveInput() {
        try {
            String userInput = bufferedReader.readLine();
            int userMove = Integer.parseInt(userInput);
            return (userMove > 0 && userMove < 10)? userMove : 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        return 0;
    }

    private void printPrompt(int player) {
        printStream.println("Player " + player + ": (enter a number from 1-9)");
    }
}
