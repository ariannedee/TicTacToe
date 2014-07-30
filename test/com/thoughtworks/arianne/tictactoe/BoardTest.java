package com.thoughtworks.arianne.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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
    public void drawStartingBoard() {
        board.draw();

        verify(printStream).println(
                "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }

    @Test
    public void drawBoardWithPlayerOneMove() {
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
    public void drawBoardWithPlayerTwoMove() {
        board.makeMoveForPlayer(3, false);
        board.draw();

        verify(printStream).println(
                "   |   | O\n" +
                        "-----------\n" +
                        "   |   |  \n" +
                        "-----------\n" +
                        "   |   |  ");
    }
}
