package game;

import pieces.King;

import java.util.*;

public class Game {

    private Player[] players = new Player[2];
    private Board board = new Board();
    private Player currentTurn;
    private GameStatus status = GameStatus.ACTIVE;
    private ArrayList<Move> movesPlayed = new ArrayList<>();
    private int turnNumber = 1;

    public void initialise(Player p1, Player p2) {

        this.players[0] = p1;
        this.players[1] = p2;

        if (p1.getColour() == Colour.WHITE) {
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }

        System.out.println("Game Started");
    }

    public GameStatus getStatus(){
        return this.status;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public void playerMove(Player player, char startX, int startY, char endX, int endY){

        Square startSquare = board.getSquare(convertCharToInt(startX), convertYIndex(startY));
        Square endSquare = board.getSquare(convertCharToInt(endX), convertYIndex(endY));
        Move move = new Move(player, startSquare, endSquare);
        if (checkValidMove(move)) {
            makeMove(move);
        }
    }

    // two functions to convert the standard chess inputs from Main to written inputs
    // convert y index from 1-8 to 0-7
    private int convertYIndex(int i) {
        return (i-1);
    }

    // convert x index from a-h to 0-7
    private int convertCharToInt(char c){
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int converted = new String(chars).indexOf(c);
        return converted;
    }

    private boolean checkValidMove(Move move){

        // checking if game is still active
        if (status != GameStatus.ACTIVE){
            System.out.println("Game is finished");
            return false;
        }

        if (move.getPieceMoved() == null) {
            System.out.println("There is no piece in this position");
            return false;
        }

        // valid player
        if (move.getPlayer() != currentTurn) {
            System.out.println("It is not your current turn");
            return false;
        }

        // valid colour of piece
        if (move.getPieceMoved().getColour() != move.getPlayer().getColour()){
            System.out.println("That is not player's piece");
            return false;
        }

        // if valid move
        if (!(move.getPieceMoved().getLegalMoves(board, move.getStart()).contains(move.getEnd()))) {
            System.out.println("Illegal Move: \n" + move + "\n");
            return false;
        }

        return true;
    }

    private boolean makeMove(Move move){

        System.out.println("Turn: " + turnNumber + "\n" + move);

        // move piece from start square to end square
        move.getEnd().setPiece(move.getPieceMoved());
        move.getStart().setPiece(null);

        if (move.getPieceCaptured() instanceof King) {
            if (move.getPlayer().getColour() == Colour.WHITE) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
            System.out.println(status);
        }

        // store the move
        movesPlayed.add(move);

        // change turn to other player
        changeTurn();

        return true;
    }

    public void changeTurn(){
        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
            this.turnNumber++;
        }
    }
}
