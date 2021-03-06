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


    public int getPlayerMoveIfValid() {
        try {
            String userInput = bufferedReader.readLine();
            int userMove = Integer.parseInt(userInput);
            if (userMove > 0 && userMove < 10) {
                return userMove;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }

        printStream.println("Invalid number\n");

        return 0;
    }

    public void printMessage(String message) {
        printStream.println(message);
    }

    public void printPrompt(String promptMessage) {
        printStream.print(promptMessage + ": ");
    }
}
