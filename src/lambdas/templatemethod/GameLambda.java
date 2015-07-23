package lambdas.templatemethod;

import java.util.function.Function;

public class GameLambda {

	private int numberOfPlayers;
	private int turn;

	public GameLambda(int playersCount) {
		this(playersCount, 0);
	}

	private GameLambda(int playersCount, int turn) {
		this.numberOfPlayers = playersCount;
		this.turn = turn;
	}

	private static GameLambda initializeGame(GameLambda game) {
		System.out.println("Chess initialized");
		return game;
	}

	private static GameLambda makePlay(GameLambda game, int player) {
		String message = String.format("It is the player's %S turn (%s)", player, game.turn);
		System.out.println(message);
		return new GameLambda(game.numberOfPlayers, game.turn + 1);
	}

	private static boolean endOfGame(GameLambda game) {
		if (game.turn >= 10)
			return true;
		return false;
	}

	private static GameLambda play(GameLambda game) {
		int player = 0;
		while (!endOfGame(game)) {
			game = makePlay(game, player);
			player = (player + 1) % game.numberOfPlayers;
		}
		return new GameLambda(player, game.turn);
	}

	private static GameLambda printWinner(GameLambda game) {
		System.out.println("You Win!");
		return new GameLambda(game.numberOfPlayers, game.turn);
	}

	public static void main(String[] args) {
		Function<GameLambda, GameLambda> initializeGame = GameLambda::initializeGame;
		Function<GameLambda, GameLambda> transformationPipeline = initializeGame
				.andThen(GameLambda::play)
				.andThen(GameLambda::printWinner);

		transformationPipeline.apply(new GameLambda(2));
	}

}
