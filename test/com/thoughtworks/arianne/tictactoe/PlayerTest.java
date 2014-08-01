package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player player;
    private Board board;
    private Console console;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        console = mock(Console.class);
        player = new Player(board, 'X', 1, console);
    }

    @Test
    public void shouldTakeTurn() throws IOException {

        player.takeTurn();

        verify(console).promptForPlayerTurn(1);
    }

    @Test
    public void shouldMakeMove() {
        player.makeMove(5);

        verify(board).makeMoveWithSymbol(5, 'X');
    }

    @Test
    public void shouldNotMakePlayerMoveWithNanInput() throws IOException {
        when(console.getValidMove()).thenReturn(0);

        player.takeTurn();

        verify(board, times(0)).makeMoveWithSymbol(0, 'X');
    }

    @Test
    public void shouldUpdateBoard() {

    }

    //    @Test
//    public void shouldRepeatTurnIfLocationTaken() throws IOException {
//        when(player1.numPlayer()).thenReturn(1);
//
//        when(bufferedReader.readLine()).thenReturn("5").thenReturn("5").thenReturn("s");
//        when(player2.makeMove(5)).thenReturn(false);
//
//        ticTacToe.start();
//
//        verify(printStream, times(2)).println("Player 1: (enter a number from 1-9)");
//    }
}
