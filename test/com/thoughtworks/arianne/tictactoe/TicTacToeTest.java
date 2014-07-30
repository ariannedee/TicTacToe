package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

public class TicTacToeTest {
    PrintStream printStream;
    BufferedReader bufferedReader;
    TicTacToe ticTacToe;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        char[] gameState = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        ticTacToe = new TicTacToe(printStream, bufferedReader, gameState);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        ticTacToe.start();

        verify(printStream).println(
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }

    @Test
    public void shouldGetUserInput() throws IOException {
        ticTacToe.start();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldDrawNewBoardWithValidUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4");

        ticTacToe.newTurn();

        verify(printStream).println("   |   |  \n" +
                "-----------\n" +
                " X |   |  \n" +
                "-----------\n" +
                "   |   |  ");
    }

    @Test
    public void shouldNotDrawNewBoardWithInvalidUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("S");

        ticTacToe.newTurn();

        verify(printStream, times(0)).println(anyString());
    }
}
