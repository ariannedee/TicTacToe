package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private TicTacToe ticTacToe;
    private Board board;
    private Player player2;
    private Player player1;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(printStream, bufferedReader, board, player1, player2);
        when(board.makeMoveForPlayer(4, true)).thenReturn(true);
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
    public void shouldNotMakePlayerMoveWithNanInput() throws IOException {
        when(bufferedReader.readLine()).thenReturn("s");

        ticTacToe.start();

        verify(player1, times(0)).makeMove(anyInt());
    }

    @Test
    public void shouldPromptPlayer1ToMoveWhenGameStarts() throws IOException {
        when(player1.numPlayer()).thenReturn(1);
        ticTacToe.start();

        verify(printStream).println("Player 1: (enter a number from 1-9)");
    }

    @Test
    public void shouldMakePlayerMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn("4").thenReturn("");

        ticTacToe.start();

        verify(player1).makeMove(4);
    }

    @Test
    public void shouldPromptPlayer2ForTurnAfterPlayer1Moves() throws IOException {
        when(player2.numPlayer()).thenReturn(2);

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

        verify(player1).makeMove(4);
        verify(player2).makeMove(4);
    }

    @Test
    public void shouldRepeatTurnIfLocationTaken() throws IOException {
        when(player1.numPlayer()).thenReturn(1);

        when(bufferedReader.readLine()).thenReturn("5").thenReturn("5").thenReturn("s");
        when(player2.makeMove(5)).thenReturn(false);

        ticTacToe.start();

        verify(printStream, times(2)).println("Player 1: (enter a number from 1-9)");
    }
}
