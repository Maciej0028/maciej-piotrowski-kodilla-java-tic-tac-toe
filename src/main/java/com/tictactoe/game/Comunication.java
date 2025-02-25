package com.tictactoe.game;

import java.util.Scanner;

public class Comunication {
    public static Coords getUserMove(int boardSize) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (boardSize == 3) {
                System.out.println("Enter your move coordinates by write (x,y): ");
                String move = scanner.nextLine();
                String[] moves = move.split(",");
                try {
                    int x = Integer.parseInt(moves[0]);
                    int y = Integer.parseInt(moves[1]);
                    if (x < 0 || x > 2 || y < 0 || y > 2) {
                        System.out.println("Wrong move try again out of bounds");
                    } else {
                        return new Coords(y, x);
                    }
                } catch (Exception e) {
                    System.out.println("Wrong move try again format ~ (x,y) = (0,1)");
                }
            } else {
                System.out.println("Enter your move coordinates by write (x,y): ");
                String move = scanner.nextLine();
                String[] moves = move.split(",");
                try {
                    int x = Integer.parseInt(moves[0]);
                    int y = Integer.parseInt(moves[1]);
                    if (x < 0 || x > 9 || y < 0 || y > 9) {
                        System.out.println("Wrong move try again out of bounds");
                    } else {
                        return new Coords(y, x);
                    }
                } catch (Exception e) {
                    System.out.println("Wrong move try again format ~ (x,y) = (0,1)");
                }
            }
        }
    }

    public static void displayTurnDetails(char turn) {
        System.out.println("Next move : " + turn);
    }

    public static void displayFieldAlreadyOccupy() {
        System.out.println("This field is already occupied.");
    }

    public static void displayWinner(char turn) {
        System.out.println("CONGRATULATIONS WINNER IS  : \uD83D\uDE0E " + turn + " \uD83D\uDE0E");
    }

    public static boolean askForRematch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wanna play again? type 'yes' or 'no': ");
        String ask = scanner.nextLine();
        return ask.equalsIgnoreCase("yes");
    }

    public static int askForBoardSelection() {
        Scanner scanner = new Scanner(System.in);
        String size;
        while (true) {
            System.out.println("Choose a board size: 3x3 or 10x10\nBy typing (3x3) or (10x10)");
            size = scanner.nextLine();

            if (!size.equals("3x3") && !size.equals("10x10")) {
                System.out.println("Wrong board size, try again.\nType example: '3x3' or '10x10'");
            } else {
                break;
            }
        }
        if (size.equals("3x3")) {
            return 3;
        } else {
            return 10;
        }
    }
}