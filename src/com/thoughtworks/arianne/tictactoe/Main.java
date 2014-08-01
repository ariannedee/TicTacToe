package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        char[] gameState = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        Board board = new Board(System.out, gameState);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Console console = new Console(bufferedReader, System.out);
        Player player1 = new Player(board, 'X', 1, console);
        Player player2 = new Player(board, 'O', 2, console);
        TicTacToe ticTacToe = new TicTacToe(board, player1, player2);
        ticTacToe.start();
    }
}
