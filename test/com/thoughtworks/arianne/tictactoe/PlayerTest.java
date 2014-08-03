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
        player = new Player(board, 'X', 2, console);
        when(console.getPlayerMoveIfValid()).thenReturn(2);
        when(board.makeMoveWithSymbol(2, 'X')).thenReturn(true);
        when(board.isFreeLocation(2)).thenReturn(true);
    }

    @Test
    public void shouldTakeTurnWithValidMove() throws IOException {
        player.takeTurn();

        verify(board).makeMoveWithSymbol(2, 'X');
    }

    @Test
    public void shouldPromptForPlayerMove() throws IOException {
        player.takeTurn();

        verify(console).printPrompt("Player 2, enter a number from 1-9");
    }

    @Test
    public void shouldTakeTurnUntilValidMove() throws IOException {
        when(console.getPlayerMoveIfValid()).thenReturn(0).thenReturn(2);

        player.takeTurn();

        verify(console, times(2)).getPlayerMoveIfValid();
    }

    @Test
    public void shouldRepeatTurnIfLocationTaken() throws IOException {
        when(board.isFreeLocation(1)).thenReturn(false);
        when(console.getPlayerMoveIfValid()).thenReturn(1).thenReturn(2);

        player.takeTurn();

        verify(console, times(2)).printPrompt("Player 2, enter a number from 1-9");
    }

    @Test
    public void shouldCheckIfPlayerWon() {
        player.didPlayerWin();

        verify(board).isWinningBoard('X');
    }
}
