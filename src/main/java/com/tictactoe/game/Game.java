package com.tictactoe.game;


public class Game {
    private Board board;
    private final AiPlayer aiPlayer = new AiPlayer();

    public void play() {
        boolean playAgain = true;
        while (playAgain) {
            int boardSize = Comunication.askForBoardSelection();
            board = new Board(boardSize);
            playAgain = handleBoard();
        }
    }

    private boolean handleBoard() {
        boolean playAgain;
        Coords coords;
        char turn = 'X';
        while (true) {
            if (turn == 'X') {
                Comunication.displayTurnDetails(turn);
                coords = Comunication.getUserMove(board.getBoardSize());
                if (board.setFigure(coords.getRow(), coords.getCol(), turn)) {
                    if (board.checkWinner(turn)) {
                        Comunication.displayWinner(turn);
                        System.out.println(board);
                        playAgain = Comunication.askForRematch();
                        break;
                    }
                    if (board.checkWinner('T')) {
                        System.out.println("It's a tie!");
                        playAgain = Comunication.askForRematch();
                        break;
                    }
                    turn = opositePlayer(turn);
                }
                System.out.println(board);
            } else {
                System.out.println("Computer Turn: " + turn + "\nProcessing...");
                aiPlayer.makeMove(board);
                System.out.println(board);
                if (board.checkWinner(turn)) {
                    Comunication.displayWinner(turn);
                    System.out.println(board);
                    playAgain = Comunication.askForRematch();
                    break;
                }
                if (board.checkWinner('T')) {
                    System.out.println("It's a tie!");
                    playAgain = Comunication.askForRematch();
                    break;
                }
                turn = opositePlayer(turn);
            }
        }
        return playAgain;
    }

    private char opositePlayer(char turn) {
        return turn == 'X' ? 'O' : 'X';
    }
}