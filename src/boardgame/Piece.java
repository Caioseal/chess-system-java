package boardgame;

public class Piece {

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

}
