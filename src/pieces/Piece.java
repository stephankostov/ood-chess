package pieces;/* An abstract class #inheritance representing the blueprint for all chess pieces */


import game.*;

import java.util.*;

public abstract class Piece {

    private boolean captured = false;
    private Colour colour;


    public Piece(Colour colour) {
        this.colour = colour;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }

    public abstract List<Square> getLegalMoves(Board board, Square currentSquare);

    public List<Square> getLinearMoves(Square[][] board, int x, int y) {

        // script increments through all linear directions a piece can move (starting from closest)
        // incrementally to find the limit of each direction
        // ie when it reaches another piece.

        ArrayList<Square> linearMoves = new ArrayList<Square>();

        // checking horizontal direction (right)
        for (int i = 1; x+i < 8; i++) {
            Square destinationSquare = board[x+i][y];
            if (!destinationSquare.isOccupied()) {
                linearMoves.add(destinationSquare);
            } else if (destinationSquare.getPiece().getColour() != this.colour) {
                linearMoves.add(destinationSquare);
                break;
            } else {
                break;
            }
        }

        // checking horizontal direction (left)
        for (int i = -1; x+i >= 0; i--) {
            Square destinationSquare = board[x+i][y];
            if (!destinationSquare.isOccupied()) {
                linearMoves.add(destinationSquare);
            } else if (destinationSquare.getPiece().getColour() != this.colour) {
                linearMoves.add(destinationSquare);
                break;
            } else {
                break;
            }
        }

        // upwards
        for (int i = 1; y+i < 8; i++) {
            Square destinationSquare = board[x][y+i];
            if (!destinationSquare.isOccupied()) {
                linearMoves.add(destinationSquare);
            } else if (destinationSquare.getPiece().getColour() != this.colour) {
                linearMoves.add(destinationSquare);
                break;
            } else {
                break;
            }
        }

        // downwards
        for (int i = -1; y+i >= 0; i--) {
            Square destinationSquare = board[x][y+i];
            if (!destinationSquare.isOccupied()) {
                linearMoves.add(destinationSquare);
            } else if (destinationSquare.getPiece().getColour() != this.colour) {
                linearMoves.add(destinationSquare);
                break;
            } else {
                break;
            }
        }
        return linearMoves;
    }

    public List<Square> getDiagonalMoves(Square[][] board, int x, int y) {
        ArrayList<Square> diagonalMoves = new ArrayList<Square>();

        int xNW = x+1;
        int yNW = y+1;
        int xSW = x+1;
        int ySW = y-1;
        int xSE = x-1;
        int ySE = y-1;
        int xNE = x-1;
        int yNE = y+1;

        while (xNW < 8 && yNW < 8) {
            Square destinationSquare = board[xNW][yNW];
            if (destinationSquare.isOccupied()) {
                if (destinationSquare.getPiece().getColour() != this.colour) {
                    diagonalMoves.add(destinationSquare);
                }
                break;
            } else {
                diagonalMoves.add(destinationSquare);
                xNW++;
                yNW++;
            }
        }

        while (xSW < 8 && ySW >= 0) {
            Square destinationSquare = board[xSW][ySW];
            if (destinationSquare.isOccupied()) {
                if (destinationSquare.getPiece().getColour() != this.colour) {
                    diagonalMoves.add(destinationSquare);
                }
                break;
            } else {
                diagonalMoves.add(destinationSquare);
                xSW++;
                ySW--;
            }
        }

        while (xSE >= 0 && ySE >= 0) {
            Square destinationSquare = board[xSE][ySE];
            if (destinationSquare.isOccupied()) {
                if (destinationSquare.getPiece().getColour() != this.colour) {
                    diagonalMoves.add(destinationSquare);
                }
                break;
            } else {
                diagonalMoves.add(destinationSquare);
                xSE--;
                ySE--;
            }
        }

        while (xNE >= 0 && yNE < 8) {
            Square destinationSquare = board[xNE][yNE];
            if (destinationSquare.isOccupied()) {
                if (destinationSquare.getPiece().getColour() != this.colour) {
                    diagonalMoves.add(destinationSquare);
                }
                break;
            } else {
                diagonalMoves.add(destinationSquare);
                xNE--;
                yNE++;
            }
        }

        return diagonalMoves;
    }
}
