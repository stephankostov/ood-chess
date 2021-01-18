package game;

import game.*;
import pieces.*;

public class Move {

    private Player player;
    private Square start;
    private Square end;
    private Piece pieceMoved;
    private Piece pieceCaptured;

    public Move(Player player, Square start, Square end){

        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
        this.pieceCaptured = end.getPiece();
    }

    @Override
    public String toString() {
        return "---------------- \n" +
                "Move: " + "\n" +
                "Side=" + player.getColour() + ",\n" +
                "Start=" + start + ",\n" +
                "End=" + end + ",\n" +
                "pieceCaptured=" + pieceCaptured + "\n";
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Square getStart() {
        return start;
    }

    public void setStart(Square start) {
        this.start = start;
    }

    public Square getEnd() {
        return end;
    }

    public void setEnd(Square end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceCaptured() {
        return pieceCaptured;
    }

    public void setPieceCaptured(Piece pieceCaptured) {
        this.pieceCaptured = pieceCaptured;
    }
}
