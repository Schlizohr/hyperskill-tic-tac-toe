package tictactoe;

public class Main {
    public static void main(String[] args) throws AlreadyPlacedException {
        Board board = new Board();
        fillBoard(board);
        System.out.println(board);
    }

    private static void fillBoard(Board board) throws AlreadyPlacedException {

        int i = 0;
        for (int x = 0; x < board.getxSize(); x++) {
            for (int y = 0; y < board.getySize(); y++) {
                TicTacToeSymbol ticTacToeSymbol = TicTacToeSymbol.X;
                if (i % 2 == 1) {
                    ticTacToeSymbol = TicTacToeSymbol.O;
                }
                board.placeValue(x, y, ticTacToeSymbol);
                i++;
            }
        }
    }

}
