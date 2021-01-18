package game;

import pieces.*;

public class Square {

    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOccupied() {
        return this.getPiece() != null;
    }

    @Override
    public String toString() {
        char[] letters = {'a','b','c','d','e','f','g','h'};
        return "Square{" +
                letters[x] +
                (y+1) +
                " : (" + piece +
                ")}";
    }


}
