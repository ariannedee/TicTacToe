package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private TicTacToe ticTacToe;
    private Board board;
    private Player player2;
    private Player player1;

    @Before
    public void setUp() {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(board, player1, player2);
        when(board.isFilled()).thenReturn(true);
    }

    @Test
    public void shouldDrawBoardWhenGameStarts() {
        ticTacToe.start();

        verify(board).draw();
    }

    @Test
    public void shouldStartPlayer1TurnWhenGameStarts() throws IOException {
        ticTacToe.start();

        verify(player1).takeTurn();
    }

    @Test
    public void shouldMakePlayerMove() throws IOException {
        ticTacToe.start();

        verify(player1).takeTurn();
    }

    @Test
    public void shouldMakeMoveForPlayer2() throws IOException {
        when(player1.didPlayerWin()).thenReturn(false);
        when(board.isFilled()).thenReturn(false).thenReturn(true);

        ticTacToe.start();

        verify(player2).takeTurn();
    }

    @Test
    public void shouldCheckForWinBeforeCheckingForDraw() {
        when(player1.didPlayerWin()).thenReturn(true);

        ticTacToe.start();

        verify(board, times(0)).isFilled();
    }

    @Test
    public void shouldCheckIfBoardFilledIfPlayerDidNotWin() {
        when(player1.didPlayerWin()).thenReturn(false);

        ticTacToe.start();

        verify(board).isFilled();
    }
}
