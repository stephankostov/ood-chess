package game;

import pieces.*;

public class Board {

    Square[][] board = new Square[8][8];

    public Board(){
        this.resetBoard();
    }

    public Square[][] getSquareArray() {
        return this.board;
    }

    public Square getSquare(int x, int y) {

     /*   if (x < 0 || x > 7 || y > 7){
            //@todo: try implementing exceptions in OOP week 2
            // should I use throws exception in the title?
            throw new Exception("Index out of bounds");
        } */

        return board[x][y];
    }

    public Piece getOccupyingPiece(int x, int y) {
        return this.getSquare(x, y).getPiece();
    }

    public void resetBoard(){

        // initialising pawn pieces
        for (int x = 0; x < 8; x++) {
            board[x][1] = new Square(x, 1, new Pawn(Colour.WHITE));
        }
        for (int x = 0; x < 8; x++) {
            board[x][6] = new Square(x, 6, new Pawn(Colour.BLACK));
        }

        // initialise white pieces
        board[0][0] = new Square(0, 0, new Rook(Colour.WHITE));
        board[1][0] = new Square(1, 0, new Knight(Colour.WHITE));
        board[2][0] = new Square(2, 0, new Bishop(Colour.WHITE));
        board[3][0] = new Square(3, 0, new Queen(Colour.WHITE));
        board[4][0] = new Square(4, 0, new King(Colour.WHITE));
        board[5][0] = new Square(5, 0, new Bishop(Colour.WHITE));
        board[6][0] = new Square(6, 0, new Knight(Colour.WHITE));
        board[7][0] = new Square(7, 0, new Rook(Colour.WHITE));

        // initialise black pieces
        board[0][7] = new Square(0, 7, new Rook(Colour.BLACK));
        board[1][7] = new Square(1, 7, new Knight(Colour.BLACK));
        board[2][7] = new Square(2, 7, new Bishop(Colour.BLACK));
        board[3][7] = new Square(3, 7, new Queen(Colour.BLACK));
        board[4][7] = new Square(4, 7, new King(Colour.BLACK));
        board[5][7] = new Square(5, 7, new Bishop(Colour.BLACK));
        board[6][7] = new Square(6, 7, new Knight(Colour.BLACK));
        board[7][7] = new Square(7, 7, new Rook(Colour.BLACK));

        // initialise remaining squares without a piece
        for (int x = 0; x < 8; x++) {
            for (int y = 2; y < 6; y++) {
                board[x][y] = new Square(x, y, null);
            }
        }
    }

}
