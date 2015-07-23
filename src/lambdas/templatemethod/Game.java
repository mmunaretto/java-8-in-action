package lambdas.templatemethod;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class that is common to several games in
 * which players play against the others, but only one is
 * playing at a given time.
 */

abstract class Game {

    protected int playersCount;

    abstract void initializeGame();

    abstract void makePlay(int player);

    abstract boolean endOfGame();

    abstract void printWinner();

    /* A template method : */
    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()) {
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }

    public enum Type {
        CHESS, MONOPOLY;
    }

    public static class Factory {
        private Map<Type, Game> typeGameMap = new HashMap<Type, Game>() {
            {
                put(Type.CHESS, new Chess());
                put(Game.Type.MONOPOLY, new Monopoly());
            }
        };

        public Game create(Type gameType) {
            return typeGameMap.get(gameType);
        }
    }

    public static void main(String[] args) {
        Game game = new Game.Factory().create(Type.CHESS);
        game.playOneGame(2);
    }
}


