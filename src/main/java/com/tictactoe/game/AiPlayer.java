package com.tictactoe.game;

import java.util.Random;

public class AiPlayer {
    public void makeMove(Board board) {
        if (board.getBoardSize() == 3) {
            Random random = new Random();
            int row, col;
            do {
                row = random.nextInt(3);
                col = random.nextInt(3);
            } while (board.getFigure(row, col) != ' ');

            board.setFigure(row, col, 'O');
        } else {
            Random random = new Random();
            int row, col;
            do {
                row = random.nextInt(10);
                col = random.nextInt(10);
            } while (board.getFigure(row, col) != ' ');

            board.setFigure(row, col, 'O');
        }
    }
}