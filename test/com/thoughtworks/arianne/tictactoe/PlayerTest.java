package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    private Player player;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        player = new Player(board, 'X', 1);
    }

    @Test
    public void shouldTakeTurn() {

        player.takeTurn();
    }

    @Test
    public void shouldMakeMove() {
        player.makeMove(5);

        verify(board).makeMoveWithSymbol(5, 'X');
    }

    @Test
    public void shouldUpdateBoard() {

    }

}
