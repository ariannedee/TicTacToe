package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;
    private Player player1;
    private Player player2;

    public TicTacToe(PrintStream printStream, BufferedReader bufferedReader, Board board, Player player1, Player player2) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.draw();
        boolean isPlayer1Turn = true;

        while(true) {
            Player player = isPlayer1Turn? player1:player2;
            printPrompt(player.numPlayer());
            int move = getPlayerMoveInput();

            if (move == 0) break;

            if(!player.makeMove(move)) break;

            board.draw();
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private int getPlayerMoveInput() {
        try {
            String userInput = bufferedReader.readLine();
            int userMove = Integer.parseInt(userInput);
            return (userMove > 0 && userMove < 10)? userMove : 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void printPrompt(int player) {
        printStream.println("Player " + player + ": (enter a number from 1-9)");
    }
}
