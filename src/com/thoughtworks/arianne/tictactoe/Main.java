package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(board, 'X', 1);
        Player player2 = new Player(board, 'O', 2);
        TicTacToe ticTacToe = new TicTacToe(System.out, bufferedReader, board, player1, player2);
        ticTacToe.start();
    }
}
