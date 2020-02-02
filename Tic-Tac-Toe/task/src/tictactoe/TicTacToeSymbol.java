package tictactoe;

public enum TicTacToeSymbol {
    X('X'), O('O'), U('_');
    public final char label;

    private TicTacToeSymbol(char label) {
        this.label = label;
    }
}
