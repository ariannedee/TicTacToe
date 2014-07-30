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
    Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        ticTacToe = new TicTacToe(printStream, bufferedReader, board);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        ticTacToe.start();

        verify(board).draw();
    }

    @Test
    public void shouldGetUserInput() throws IOException {
        ticTacToe.start();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldPromptPlayer1ToMoveWhenGameStarts() throws IOException {
        ticTacToe.start();

        verify(printStream).println("Player 1: (enter a number from 1-9)");
    }

    @Test
    public void shouldDrawNewBoardWithValidUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4");

        ticTacToe.newTurn();

        verify(board).draw();
    }

    @Test
    public void shouldMakeMoveWithValidUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4");

        ticTacToe.newTurn();

        verify(board).makeMove(4);
    }
}
