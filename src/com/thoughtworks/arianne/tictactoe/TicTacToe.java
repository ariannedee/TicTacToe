package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {
    PrintStream printStream;
    private BufferedReader bufferedReader;
    private char[] gameState;

    public TicTacToe(PrintStream printStream, BufferedReader bufferedReader, char[] gameState) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.gameState = gameState;
    }

    public void start() {
        drawBoard(gameState);

        newTurn();
    }

    private void drawBoard(char[] gameState) {
        String board = String.format(" %c | %c | %c\n" +
                "-----------\n" +
                " %c | %c | %c\n" +
                "-----------\n" +
                " %c | %c | %c", gameState[0], gameState[1], gameState[2], gameState[3], gameState[4], gameState[5],
                gameState[6], gameState[7], gameState[8]);
        printStream.println(board);
    }


    public void newTurn() {
        String userMove;
        try {
            userMove = bufferedReader.readLine();
            int moveAsInt = Integer.parseInt(userMove);
            gameState[moveAsInt-1] = 'X';
            drawBoard(gameState);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            //printStream.println("Try again");
        }
    }
}
