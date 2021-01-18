package game;

public class Main {

    public static void main(String[] args) {

        Player p1 = new Player(Colour.WHITE);
        Player p2 = new Player(Colour.BLACK);

        Game game = new Game();
        game.initialise(p1, p2);

        // 4 Move CheckMate
        game.playerMove(p1, 'e', 2, 'e', 4);
        game.playerMove(p2, 'e', 7, 'e', 5);

        game.playerMove(p1, 'd', 1, 'h', 5);
        game.playerMove(p2, 'b', 8, 'c', 6);

        game.playerMove(p1, 'f', 1, 'c', 4);
        game.playerMove(p2, 'c', 6, 'e', 5);

        game.playerMove(p1, 'h', 5, 'f', 7);
        game.playerMove(p2, 'e', 8, 'f', 7);
        // King captured
        game.playerMove(p1, 'c', 4, 'f', 7);

        /*/ Testing Different Moves (unfinished)
        game.playerMove(p1, 'e', 2, 'e', 3); // pawn can move 1 space
        game.playerMove(p2, 'e', 7, 'e', 5); // pawn can move 2 spaces
        game.playerMove(p1, 'd', 1, 'f', 3); // queen can move diagonally (getDiagonalMoves
        game.playerMove(p2, 'b', 8, 'c', 6); // knight can move
        game.playerMove(p1, 'f', 3, 'f', 5); // queen can move horizontally (getLinearMoves)
        @todo JUnit unit tests */


    }

}
