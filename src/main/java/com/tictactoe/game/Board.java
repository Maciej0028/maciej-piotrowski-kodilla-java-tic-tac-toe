package com.tictactoe.game;

public class Board {
    public final char[][] board;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = ' ';
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < boardSize; i++) {
            sb.append("|");
            for (int j = 0; j < boardSize; j++) {
                sb.append(board[i][j] + "|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean setFigure(int row, int col, char figure) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            System.out.println("Row or column out of bounds.");
            return false;
        }
        if (board[row][col] != ' ') {
            System.out.println(row + "," + col + " is already occupied.");
            return false;
        } else {
            board[row][col] = figure;
            return true;
        }
    }

    public char getFigure(int row, int col) {
        return board[row][col];
    }

    public boolean checkWinner(char player) {
        if (player == 'T') {
            return !checkWinner('X') && !checkWinner('O') && noFreeCelsOnBoard();
        } else if (boardSize == 10) {
            for (int row = 0; row < boardSize; row++) {
                for (int col = 0; col < boardSize - 4; col++) {
                    if (getFigure(row, col) == player &&
                            getFigure(row, col + 1) == player &&
                            getFigure(row, col + 2) == player &&
                            getFigure(row, col + 3) == player &&
                            getFigure(row, col + 4) == player) {
                        return true;
                    }
                }
            }
            for (int col = 0; col < boardSize; col++) {
                for (int row = 0; row < boardSize - 4; row++) {
                    if (getFigure(row, col) == player &&
                            getFigure(row + 1, col) == player &&
                            getFigure(row + 2, col) == player &&
                            getFigure(row + 3, col) == player &&
                            getFigure(row + 4, col) == player) {
                        return true;
                    }
                }
            }
            for (int row = 0; row < boardSize - 4; row++) {
                for (int col = 0; col < boardSize - 4; col++) {
                    if (getFigure(row, col) == player &&
                            getFigure(row + 1, col + 1) == player &&
                            getFigure(row + 2, col + 2) == player &&
                            getFigure(row + 3, col + 3) == player &&
                            getFigure(row + 4, col + 4) == player) {
                        return true;
                    }
                }
            }
            for (int row = 0; row < boardSize; row++) {
                for (int col = 0; col < boardSize; col++) {
                    if (row + 4 < boardSize && col - 4 >= 0) {
                        if (getFigure(row, col) == player &&
                                getFigure(row + 1, col - 1) == player &&
                                getFigure(row + 2, col - 2) == player &&
                                getFigure(row + 3, col - 3) == player &&
                                getFigure(row + 4, col - 4) == player) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int row = 0; row < 3; row++) {
                if (getFigure(row, 0) == player &&
                        getFigure(row, 1) == player &&
                        getFigure(row, 2) == player) {
                    return true;
                }
            }
            for (int col = 0; col < 3; col++) {
                if (getFigure(0, col) == player &&
                        getFigure(1, col) == player &&
                        getFigure(2, col) == player) {
                    return true;
                }
            }
            if (getFigure(0, 0) == player &&
                    getFigure(1, 1) == player &&
                    getFigure(2, 2) == player) {
                return true;
            }
            if (getFigure(0, 2) == player &&
                    getFigure(1, 1) == player &&
                    getFigure(2, 0) == player) {
                return true;
            }
        }
        return false;
    }

    private boolean noFreeCelsOnBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (getFigure(row, col) == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int getBoardSize() {
        return boardSize;
    }
}