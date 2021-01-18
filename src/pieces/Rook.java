package pieces;

import game.*;

import java.util.*;

public class Rook extends Piece {

    public Rook(Colour colour){
        super(colour);
    }

    @Override
    public List<Square> getLegalMoves(Board b, Square currentSquare) {
        Square[][] board = b.getSquareArray();
        int x = currentSquare.getX();
        int y = currentSquare.getY();

        return getLinearMoves(board, x, y);
    }
}
