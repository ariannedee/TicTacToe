package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    PrintStream printStream;
    Board board;
    private char[] gameState;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        gameState = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        board = new Board(printStream, gameState);
    }

    @Test
    public void shouldDrawStartingBoard() {
        board.draw();

        verify(printStream).println(
                "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n");
    }

    @Test
    public void shouldDrawBoardWithPlayerOneMove() {
        board.makeMoveWithSymbol(3, 'X');
        board.draw();

        verify(printStream).println(
                        "   |   | X\n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n");
    }

    @Test
    public void shouldDrawBoardWithPlayerTwoMove() {
        board.makeMoveWithSymbol(3, 'O');
        board.draw();

        verify(printStream).println(
                "   |   | O\n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n");
    }

    @Test
    public void shouldReturnTrueIfGameBoardFilled() {
        gameState = new char[]{
                'X', 'O', 'X',
                'X', 'O', 'X',
                'X', 'O', 'X'};
        board = new Board(printStream, gameState);

        assertThat(board.isFilled(), is(true));
    }

    @Test
    public void shouldReturnFalseIfGameBoardNotFilled() {
        boolean filled = board.isFilled();
        assertThat(filled, is(false));
    }

    @Test
    public void shouldReturnTrueIfBoardWonFromColumn() {
        gameState = new char[]{
                'X', 'O', 'X',
                'X', 'O', 'X',
                ' ', 'O', ' '};
        board = new Board(printStream, gameState);

        assertThat(board.isWinningBoard('O'), is(true));
    }

    @Test
    public void shouldReturnFalseIfBoardWonFromDifferentSymbol() {
        gameState = new char[]{
                'X', 'O', 'X',
                'X', 'O', 'X',
                ' ', 'O', ' '};
        board = new Board(printStream, gameState);

        assertThat(board.isWinningBoard('X'), is(false));
    }

    @Test
    public void shouldReturnTrueIfBoardWonFromRow() {
        gameState = new char[]{
                'X', 'O', 'O',
                'O', 'O', 'X',
                'X', 'X', 'X'};
        board = new Board(printStream, gameState);

        assertThat(board.isWinningBoard('X'), is(true));
    }

    @Test
    public void shouldReturnFalseIfNotWinningBoard() {
        gameState = new char[]{
                'O', 'O', 'X',
                'X', 'O', 'X',
                'X', ' ', ' '};
        board = new Board(printStream, gameState);

        assertThat(board.isWinningBoard('X'), is(false));
    }

    @Test
    public void shouldReturnTrueIfBoardWinWithDiagonal() {
        gameState = new char[]{
                'O', 'O', 'X',
                'X', 'X', 'O',
                'X', ' ', ' '};
        board = new Board(printStream, gameState);

        assertThat(board.isWinningBoard('X'), is(true));
    }

    @Test
    public void shouldReturnFreeLocations() {
        gameState = new char[]{
                'X', 'O', 'X',
                'X', 'O', 'X',
                ' ', ' ', ' '};
        board = new Board(printStream, gameState);

        List<Integer> freeLocations = board.getFreeLocations();
        assertThat(freeLocations.get(0), is(7));
        assertThat(freeLocations.get(1), is(8));
        assertThat(freeLocations.get(2), is(9));
        assertThat(freeLocations.size(), is(3));
    }
}
