package com.thoughtworks.arianne.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        char[] gameState = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        TicTacToe ticTacToe = new TicTacToe(System.out, new BufferedReader(new InputStreamReader(System.in)), gameState);
        ticTacToe.start();
    }
}
