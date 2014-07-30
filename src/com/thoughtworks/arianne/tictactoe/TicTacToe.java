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
        newTurn();
    }

    public void newTurn() {
        printStream.println("Player 1: (enter a number from 1-9)");

        try {
            String userMove = bufferedReader.readLine();
            int moveAsInt = Integer.parseInt(userMove);
            board.makeMove(moveAsInt);
            board.draw();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
    }
}
