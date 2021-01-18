package pieces;

import game.*;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Colour colour){
        super(colour);
    }

    @Override
    public List<Square> getLegalMoves(Board b, Square currentSquare) {

        ArrayList<Square> validMoves = new ArrayList<Square>();

        Square[][] board = b.getSquareArray();

        int x = currentSquare.getX();
        int y = currentSquare.getY();

        for (int i = 1; i > -2; i--) {
            for (int k = 1; k > -2; k--) {
                if (!(i == 0 && k == 0)) {
                    try {
                        Square destinationSquare = board[x+i][y+k];
                        if (!destinationSquare.isOccupied()) {
                            validMoves.add(destinationSquare);
                        } else if (destinationSquare.getPiece().getColour() != this.getColour()) {
                            validMoves.add(destinationSquare);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                    }
                }
            }
        }

        return validMoves;
    }
}
