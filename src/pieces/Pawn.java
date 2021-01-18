package pieces;

import game.*;

import java.util.*;

public class Pawn extends Piece {
    
    private boolean wasMoved = false; //@todo implement this in move function (getters and setters)

    public Pawn(Colour colour){
        super(colour);
    }

    public List<Square> getLegalMoves(Board b, Square currentSquare) {
        ArrayList<Square> validMoves = new ArrayList<>();

        Square[][] board = b.getSquareArray();

        int x = currentSquare.getX();
        int y = currentSquare.getY();

        Piece currentPiece = currentSquare.getPiece();

        //@todo tidy code - no need for repetitions
        if (currentPiece.getColour() == Colour.WHITE) {
            if (!wasMoved) {
                if (!board[x][y+2].isOccupied()) {
                    validMoves.add(board[x][y+2]);
                }
            }

            if (y+1 < 8) {
                if (!board[x][y+1].isOccupied()) {
                    validMoves.add(board[x][y+1]);
                }
                if (x+1 < 8) {
                    if (board[y+1][x+1].isOccupied()) {
                        validMoves.add(board[x+1][y+1]);
                    }
                }
                if (x-1 >= 0) {
                    if (board[y+1][x - 1].isOccupied()) {
                        validMoves.add(board[x-1][y+1]);
                    }
                }
            }
        }

        if (currentPiece.getColour() == Colour.BLACK) {
            if (!wasMoved) {
                if (!board[x][y-2].isOccupied()) {
                    validMoves.add(board[x][y-2]);
                }
            }

            if (y-1 >= 0) {
                if (!board[x][y-1].isOccupied()) {
                    validMoves.add(board[x][y-1]);
                }
                if (x-1 >= 0) {
                    if (board[x-1][y-1].isOccupied()) {
                        validMoves.add(board[x-1][y-1]);
                    }
                }
                if (x+1 < 8) {
                    if (board[x+1][y-1].isOccupied()) {
                        validMoves.add(board[x+1][y-1]);
                    }
                }
            }
        }
        
        
        return validMoves;
    }
}
