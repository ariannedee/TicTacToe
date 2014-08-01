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
        when(board.makeMoveWithSymbol(2, 'X')).thenReturn(true);
    }

    @Test
    public void shouldTakeTurnWithValidMove() throws IOException {
        when(console.getPlayerMoveIfValid()).thenReturn(2);

        player.startTurn();

        verify(board).makeMoveWithSymbol(2, 'X');
        verify(console).promptForPlayerTurn(1);
    }

    @Test
    public void shouldTakeTurnUntilValidMove() throws IOException {
        when(console.getPlayerMoveIfValid()).thenReturn(0).thenReturn(2);

        player.startTurn();

        verify(console, times(2)).getPlayerMoveIfValid();
    }

    @Test
    public void shouldRepeatTurnIfLocationTaken() throws IOException {
        when(board.makeMoveWithSymbol(1, 'X')).thenReturn(false).thenReturn(true);
        when(console.getPlayerMoveIfValid()).thenReturn(1).thenReturn(1);

        player.startTurn();

        verify(console, times(2)).promptForPlayerTurn(1);
        verify(console).printLocationTakenMessage();
    }
}
