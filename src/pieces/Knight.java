package pieces;

import game.*;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Colour colour){
        super(colour);
    }

    @Override
    public List<Square> getLegalMoves(Board b, Square currentSquare){

        ArrayList<Square> validMoves = new ArrayList<Square>();
        Square[][] board = b.getSquareArray();

        int x = currentSquare.getX();
        int y = currentSquare.getY();

        for (int i = 2; i > - 3; i--) {
            for (int k = 2; k > -3; k--) {
                if (Math.abs(i) == 2 ^ Math.abs(k) == 2) {
                    if (k != 0 && i !=0) {
                        try {
                            Piece locatedPiece = b.getOccupyingPiece(x+i, y+k);
                            if (locatedPiece == null || locatedPiece.getColour() == this.getColour())
                            validMoves.add(board[x+i][y+k]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            continue;
                        }
                    }
                }
            }
        }

        return validMoves;
    }

}
