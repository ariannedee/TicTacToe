package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {
    private Player computerPlayer;
    private Board board;
    private Console console;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        console = mock(Console.class);
        computerPlayer = new ComputerPlayer(board, 'O', 1, console);
        when(board.makeMoveWithSymbol(1, 'O')).thenReturn(true);
        List<Integer> freeLocations = Arrays.asList(3, 4, 6, 7, 9);
        when(board.getFreeLocations()).thenReturn(freeLocations);
    }

    @Test
    public void shouldTakeNextFreeLocationOnTurnWithEmptyBoard() {
        List<Integer> freeLocations = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        when(board.getFreeLocations()).thenReturn(freeLocations);

        computerPlayer.startTurn();

        verify(board).makeMoveWithSymbol(1, 'O');
    }

    @Test
    public void shouldTakeNextFreeLocationOnTurn() {
        computerPlayer.startTurn();

        verify(board).makeMoveWithSymbol(3, 'O');
    }

    @Test
    public void shouldDrawNewBoardAtEndOfTurn() {
        computerPlayer.startTurn();

        verify(board).draw();
    }

    @Test
    public void shouldPrintComputerMoveOnTurn() {
        computerPlayer.startTurn();

        verify(console).printMessage("Computer chose location 3");
    }

    @Test
    public void shouldPrintComputerWinWhenWins() {
        when(board.makeMoveWithSymbol(3, 'O')).thenReturn(true);
        computerPlayer.startTurn();

        verify(console).printMessage("Computer wins! Ha hah!");
    }
}
