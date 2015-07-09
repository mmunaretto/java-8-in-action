package lambdas.templatemethod;

/**
 * Created by manuela on 09/07/15.
 */
class Chess extends Game {

    /* Implementation of necessary concrete methods */
    @Override
    public void initializeGame() {
        // Initialize players
        // Put the pieces on the board
    }

    @Override
    public void makePlay(int player) {
        // Process a turn for the player
    }

    @Override
    public boolean endOfGame() {
        // Return true if in Checkmate or
        // Stalemate has been reached
        return true;
    }

    @Override
    public void printWinner() {
        // Display the winning player
    }
    /* Specific declarations for the chess game. */

    // ...
}
