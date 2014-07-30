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
        boolean isPlayer2 = false;
        boolean gameInProgress = true;

        while(gameInProgress) {
            gameInProgress = newTurn(isPlayer2);
            isPlayer2 = !isPlayer2;
        }
    }

    public boolean newTurn(boolean isPlayer2) {
        int player = isPlayer2? 2 : 1;

        printPrompt(player);
        int move = getPlayerMove();
        if (move == 0) return false;
        board.makeMove(move);
        board.draw();

        return true;
    }

    private int getPlayerMove() {
        try {
            String userMove = bufferedReader.readLine();
            return Integer.parseInt(userMove);

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
