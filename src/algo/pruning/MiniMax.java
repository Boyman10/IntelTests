package algo.pruning;

import java.util.ArrayList;

/**
 * This class update a graph or tree to add labels to nodes so it can be treated in another algorithm such as AlphaBeta Pruning
 * @see https://fr.wikipedia.org/wiki/%C3%89lagage_alpha-b%C3%AAta
 * @eee https://www.youtube.com/watch?v=QTw8VJzRW6g&t=0s&list=PL6Xpj9I5qXYGhsvMWM53ZLfwUInzvYWsm&index=18
 */
public abstract class MiniMax implements MiniMaxInterface {

    public static final int MIN_INFINITE = 1000;
    public static final int MAX_INFINITE = -1000;

    protected int depth = 0;
    protected boolean endOfGame = false;

    protected ArrayList<Move> moves;
    protected int currentIndexMove;

    /**
     * Class constructor
     */
    public MiniMax() {


    }

    public abstract void play();

    @Override
    public int min() {

        if (depth == 0 || endOfGame) {
            return eval();
        }

        int min = MIN_INFINITE;

        for(Move move : moves) {

            move.simulateMove();
            depth--;
            int val = max();

            min = (val < min)? val : min;

            move.cancelMove();
        }

        return min;
    }

    @Override
    public int max() {
        if (depth == 0 || endOfGame) {
            return eval();
        }

        int max = MAX_INFINITE;

        for(Move move : moves) {

            move.simulateMove();
            depth--;
            int val = min();

            max = (val > max)? val : max;

            move.cancelMove();
        }

        return max;
    }

    @Override
    public abstract int eval();
}
