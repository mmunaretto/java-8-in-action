package lambdas.templatemethod;

public class Chess extends Game {
	private int turn = 0;

	/* Implementation of necessary concrete methods */
	@Override
	public void initializeGame() {
		System.out.println("Chess initialized");
	}

	@Override
	public void makePlay(int player) {
		String message = String.format("It is the player's %S turn (%s)", player, turn);
		System.out.println(message);
		turn++;
	}

	@Override
	public boolean endOfGame() {
		if (turn >= 10)
			return true;
		return false;
	}

	@Override
	public void printWinner() {
		System.out.println("You win!");
	}
	/* Specific declarations for the chess game. */

	// ...
}
