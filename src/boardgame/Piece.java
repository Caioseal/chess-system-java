package boardgame;

public abstract class Piece {

    //Attributes
    protected Position position;
    private Board board;

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
        for(int i = 0; i < matrix.length; i++) {
            for (int j=0; j < matrix.length; j++) {
                if (matrix[i][j]) {
                        return true;
                }
            }
        }
        return false;
    }

}
