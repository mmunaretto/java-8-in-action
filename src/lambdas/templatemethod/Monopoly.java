package lambdas.templatemethod;

public class Monopoly extends Game {

    /* Implementation of necessary concrete methods */
    @Override
    public void initializeGame() {
        System.out.println("Monopoly initialized");
    }

    @Override
    public void makePlay(int player) {
        // Process one turn of player
    }

    @Override
    public boolean endOfGame() {
        // Return true if game is over
        // according to Monopoly rules
        return true;
    }

    @Override
    public void printWinner() {
        // Display who won
    }
    /* Specific declarations for the Monopoly game. */

    // ...
}
