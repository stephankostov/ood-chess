package pieces;

import game.*;

import java.util.*;

public class Bishop extends Piece {

    public Bishop(Colour colour){
        super(colour);
    }

    @Override
    public List<Square> getLegalMoves(Board b, Square currentSquare) {
        Square[][] board = b.getSquareArray();
        int x = currentSquare.getX();
        int y = currentSquare.getY();

        return getDiagonalMoves(board, x, y);
    }
}
