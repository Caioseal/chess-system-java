package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    //Attribute
    private final Color color;
    private int moveCount;

    //Constructor
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
        this.moveCount = 0;
    }

    //Getter
    public Color getColor() {
        return color;
    }

    public ChessPosition getPosition() {
        return ChessPosition.fromPosition(position);
    }

    public ChessPosition getChesPosition() {
        return ChessPosition.fromPosition(position);
    }

    public int getMoveCount() { return moveCount;}

    //Functions

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
    }
}