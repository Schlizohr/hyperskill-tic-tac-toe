package tictactoe;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GameMaster {

    private Board board;
    private GameState currentGameState = GameState.UNFINISHED;

    public GameMaster() {
        board = new Board();
    }

    public GameMaster(Board board) {
        this.board = board;
        evalGameState();
    }

    private void evalGameState() {
        evalWinner();
        evalImpossible();
        evalDraw();
        System.out.println(currentGameState.label);
    }

    private void evalWinner() {
        threeInARow();
        threeInAColumn();
        threeInADiagonal();
    }

    private void evalImpossible() {
        int x = countTicTacToeSymbol(TicTacToeSymbol.X);
        int o = countTicTacToeSymbol(TicTacToeSymbol.O);
        if (Math.abs(o - x) > 1) {
            currentGameState = GameState.IMPOSSIBLE;
        }
    }

    private void evalDraw() {
        if (countTicTacToeSymbol(TicTacToeSymbol.U) == 0 && currentGameState == GameState.UNFINISHED)
            currentGameState = GameState.DRAW;
    }

    private int countTicTacToeSymbol(TicTacToeSymbol ticTacToeSymbolReq) {
        int i = 0;
        for (TicTacToeSymbol[] ticTacToeSymbols : board.getField()) {
            for (TicTacToeSymbol ticTacToeSymbol : ticTacToeSymbols) {
                if (ticTacToeSymbol == ticTacToeSymbolReq) i++;
            }
        }
        return i;
    }

    private void threeInARow() {
        for (TicTacToeSymbol[] ticTacToeSymbols : board.getField()) {
            evalList(Arrays.asList(ticTacToeSymbols));
        }

    }

    private void threeInAColumn() {
        TicTacToeSymbol[][] field = board.getField();
        for (int y = 0; y < board.getxSize(); y++) {
            evalList(Arrays.asList(field[0][y], field[1][y], field[2][y]));
        }
    }

    private void threeInADiagonal() {
        TicTacToeSymbol[][] field = board.getField();
        evalList(Arrays.asList(field[0][0], field[1][1], field[2][2]));
        evalList(Arrays.asList(field[0][2], field[1][1], field[2][0]));
    }

    private void evalList(List<TicTacToeSymbol> ticTacToeSymbols) {
        if (new HashSet<>(ticTacToeSymbols).size() == 1 &&
                ticTacToeSymbols.get(0) != TicTacToeSymbol.U) {
            setCurrentGameStateWin(ticTacToeSymbols.get(0));
        }
    }

    private void setCurrentGameStateWin(TicTacToeSymbol ticTacToeSymbol) {
        if (currentGameState == GameState.UNFINISHED) {
            currentGameState = GameState.valueOf("" + ticTacToeSymbol + "_WIN");
        } else if (currentGameState != GameState.valueOf("" + ticTacToeSymbol + "_WIN")) {
            currentGameState = GameState.IMPOSSIBLE;
        }
    }
}
