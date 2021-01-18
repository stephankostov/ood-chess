package pieces;

import game.*;

import java.util.*;

public class Queen extends Piece {

    public Queen(Colour colour){
        super(colour);
    }

    public List<Square> getLegalMoves(Board b, Square currentSquare) {
        ArrayList<Square> validMoves = new ArrayList<Square>();
        Square[][] board = b.getSquareArray();

        int x = currentSquare.getX();
        int y = currentSquare.getY();

        validMoves.addAll(getLinearMoves(board, x, y));
        validMoves.addAll(getDiagonalMoves(board, x, y));

        return validMoves;
    }
}
