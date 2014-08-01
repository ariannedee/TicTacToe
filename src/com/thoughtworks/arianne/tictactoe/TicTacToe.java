package com.thoughtworks.arianne.tictactoe;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;

    public TicTacToe(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        board.draw();
        boolean isPlayer1Turn = true;
        boolean gameInProgress = true;

        while(gameInProgress) {
            Player player = isPlayer1Turn? player1 : player2;

            gameInProgress = player.takeTurn();

            isPlayer1Turn = !isPlayer1Turn;
        }
    }
}
