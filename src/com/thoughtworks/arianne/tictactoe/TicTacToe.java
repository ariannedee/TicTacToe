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

            player.takeTurn();

            gameInProgress = !isGameOver(player);

            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private boolean isGameOver(Player player) {
        return playerWon(player) || gameIsDraw();
    }

    private boolean gameIsDraw() {
        boolean isBoardFull = board.isFilled();

        if (isBoardFull) {
            board.printIsDrawMessage();
            return true;
        }
        return false;
    }

    private boolean playerWon(Player player) {
        boolean playerWon = player.didPlayerWin();

        if (playerWon) {
            player.printWinMessage();
            return true;
        }
        return false;
    }
}
