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
    public void shouldDrawNewBoardWithValidUserMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4");

        ticTacToe.newTurn(true);

        verify(board).draw();
    }

    @Test
    public void shouldNotDrawNewBoardWithNanInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("s");

        ticTacToe.newTurn(true);

        verify(board, times(0)).draw();
    }

    @Test
    public void shouldNotDrawNewBoardWithUserMoveOutOfRange() throws IOException {
        when(bufferedReader.readLine()).thenReturn("10");

        ticTacToe.newTurn(true);

        verify(board, times(0)).draw();
    }

    @Test
    public void shouldPromptPlayer1ToMoveWhenGameStarts() throws IOException {
        ticTacToe.start();

        verify(printStream).println("Player 1: (enter a number from 1-9)");
    }

    @Test
    public void shouldMakeMoveForPlayer1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4").thenReturn("");

        ticTacToe.start();

        verify(board).makeMoveForPlayer(4, true);
    }

    @Test
    public void shouldPromptPlayer2ForTurnAfterPlayer1Moves() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4").thenReturn("");

        ticTacToe.start();

        verify(printStream).println("Player 2: (enter a number from 1-9)");
    }

    @Test
    public void shouldMakeMoveForPlayer2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4")
        .thenReturn("4")
        .thenReturn("s");

        ticTacToe.start();

        verify(board).makeMoveForPlayer(4, true);
        verify(board).makeMoveForPlayer(4, false);
    }
}
