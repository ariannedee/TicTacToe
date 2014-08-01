package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleTest {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Console console;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        console = new Console(bufferedReader, printStream);
    }

    @Test
    public void shouldPromptForPlayerTurn() throws IOException {
        console.promptForPlayerTurn(1);

        verify(printStream).println("Player 1: (enter a number from 1-9)");
    }

    @Test
    public void shouldGetValidMove() throws IOException {
        console.getValidMove();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldPrintLocationTakenMessage() {
        console.printLocationTakenMessage();

        verify(printStream).println("Location already taken, please try again");
    }
}
