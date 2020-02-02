package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AlreadyPlacedException {
        Board board = new Board();
        fillBoard(board);
        System.out.println(board);
        GameMaster gameMaster = new GameMaster(board);
    }

    private static void fillBoard(Board board) throws AlreadyPlacedException {
        System.out.print("Enter cells ");
        String line = new Scanner(System.in).nextLine().trim();
        int i = 0;
        for (int x = 0; x < board.getxSize(); x++) {
            for (int y = 0; y < board.getySize(); y++) {
                String c = String.valueOf(line.charAt(i));
                if (c.equals("_")) {
                    c = "U";
                }
                board.placeValue(x, y, TicTacToeSymbol.valueOf(c));
                i++;
            }
        }
    }

}
