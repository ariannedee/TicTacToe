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

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawStartingBoard() {
        board.draw();

        verify(printStream).println(
                "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }

    @Test
    public void shouldDrawBoardWithPlayerOneMove() {
        board.makeMoveForPlayer(3, true);
        board.draw();

        verify(printStream).println(
                "   |   | X\n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }

    @Test
    public void shouldDrawBoardWithPlayerTwoMove() {
        board.makeMoveForPlayer(3, false);
        board.draw();

        verify(printStream).println(
                "   |   | O\n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }

    @Test
    public void shouldSeeThatLocationIsNotTaken() {
        assertThat(board.makeMoveForPlayer(3,false), is(true));
    }

    @Test
    public void shouldSeeIfLocationIsAlreadyTaken() {
        board.makeMoveForPlayer(3,true);

        assertThat(board.makeMoveForPlayer(3,false), is(false));
    }
}
