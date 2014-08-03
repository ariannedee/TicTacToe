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
    public void shouldGetValidMove() throws IOException {
        console.getPlayerMoveIfValid();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldPrintMessage() {
        console.printMessage("Computer chose location 3");

        verify(printStream).println("Computer chose location 3");
    }

    @Test
    public void shouldPrintPromptWithMessage() {
        console.printPrompt("Player 1 move");

        verify(printStream).print("Player 1 move: ");
    }
}
