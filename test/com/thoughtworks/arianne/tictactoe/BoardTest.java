package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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

//    @Test
//    public void shouldSeeThatLocationIsNotTaken() {
//        assertThat(board.makeMoveWithSymbol(3, 'X'), is(true));
//    }
//
//    @Test
//    public void shouldSeeIfLocationIsAlreadyTaken() {
//        board.makeMoveWithSymbol(3, 'X');
//
//        assertThat(board.makeMoveWithSymbol(3, 'O'), is(false));
//    }

    @Test
    public void shouldReturnTrueIfGameBoardFilled() {
        gameState = new char[]{'X', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'X'};
        board = new Board(printStream, gameState);

        assertThat(board.isFilled(), is(true));
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldReturnFalseIfGameBoardNotFilled() {
        boolean filled = board.isFilled();
        assertThat(filled, is(false));
    }
}
