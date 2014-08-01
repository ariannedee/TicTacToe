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

//    @Test
//    public void shouldTakeTurnUntilValidMove() throws IOException {
//        when(console.getValidMove()).thenReturn(2).thenReturn(2);
//        when(board.makeMoveWithSymbol()).thenReturn(2).thenReturn(2);
//
//        player.takeTurn();
//
//        verify(board).makeMoveWithSymbol(2, 'X');
//    }

    @Test
    public void shouldRepeatTurnIfLocationTaken() throws IOException {
        when(board.makeMoveWithSymbol(1, 'X')).thenReturn(false);
        when(console.getValidMove()).thenReturn(1).thenReturn(0);

        player.takeTurn();

        verify(console, times(2)).promptForPlayerTurn(1);
        verify(console).printLocationTakenMessage();
    }
}
