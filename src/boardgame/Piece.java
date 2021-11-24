package boardgame;

public abstract class Piece {

    //Attributes
    protected Position position;
    private final Board board;

    //Constructor
    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    //Getter
    protected Board getBoard() {
        return board;
    }

    //Functions
    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][]matrix = possibleMoves();
        for (boolean[] booleans : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (booleans[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
