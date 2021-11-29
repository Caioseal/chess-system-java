package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    //Constructor
    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getRows()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn()); //Pawn can move to the row above
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                ; //If position exists and there is no piece
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn()); //First movement the white pawn can move two rows above
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() -1); //Capture opponent's piece in the diagonal left
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;

            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1); //Capture opponent's piece in the diagonal right
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

        } else {
            p.setValues(position.getRow() + 1, position.getColumn()); //Pawn can move to the row above
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //If position exists and there is no piece
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(position.getRow() + 2, position.getColumn()); //First movement the white pawn can move two rows above
                Position p2 = new Position(position.getRow() + 1, position.getColumn());
                if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                    mat[p.getRow()][p.getColumn()] = true;
                }

                p.setValues(position.getRow() + 1, position.getColumn() -1); //Capture opponent's piece in the diagonal left
                if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                    mat[p.getRow()][p.getColumn()] = true;

                }

                p.setValues(position.getRow() + 1, position.getColumn() + 1); //Capture opponent's piece in the diagonal right
                if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }

            }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
