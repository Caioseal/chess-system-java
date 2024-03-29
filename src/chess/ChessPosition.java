package chess;

import boardgame.Position;

public class ChessPosition {

    //Attributes
    private final char column;
    private final int row;

    //Constructor
    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error! Please type a position from A1 to H8");
        }
        this.column = column;
        this.row = row;
    }

    //Getters
    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //Functions
    protected Position toPosition(){
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
