package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Console {
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public Console(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }


    public int getValidMove() {
        try {
            String userInput = bufferedReader.readLine();
            int userMove = Integer.parseInt(userInput);
            return (userMove > 0 && userMove < 10)? userMove : 0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return 0;
    }

    public void promptForPlayerTurn(int playerNum) {
        printStream.println("Player " + playerNum + ": (enter a number from 1-9)");
    }
}
