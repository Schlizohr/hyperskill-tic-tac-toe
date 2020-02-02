package tictactoe;

public class Board {
    private TicTacToeSymbol[][] field;
    private Integer xSize;
    private Integer ySize;

    public Board() {
        field = new TicTacToeSymbol[3][3];
        xSize = 3;
        ySize = 3;
    }

    public void placeValue(int xPos, int yPos, TicTacToeSymbol ticTacToeSymbol) throws AlreadyPlacedException {
        if (field[xPos][yPos] == null) {
            field[xPos][yPos] = ticTacToeSymbol;
        } else {
            throw new AlreadyPlacedException("Position (" + xPos + "," + yPos + ") is not empty");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (TicTacToeSymbol[] ticTacToeSymbols : field) {
            for (TicTacToeSymbol ticTacToeSymbol : ticTacToeSymbols) {
                s.append(ticTacToeSymbol);
            }
            s.append("\n");
        }
        return s.toString().trim();
    }

    public TicTacToeSymbol[][] getField() {
        return field;
    }

    public void setField(TicTacToeSymbol[][] field) {
        this.field = field;
    }

    public Integer getxSize() {
        return xSize;
    }

    public Integer getySize() {
        return ySize;
    }
}
