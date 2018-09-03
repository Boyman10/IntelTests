package algo.pruning;

import java.util.ArrayList;

/**
 * This class update a graph or tree to add labels to nodes so it can be treated in another algorithm such as AlphaBeta Pruning
 * @see https://fr.wikipedia.org/wiki/%C3%89lagage_alpha-b%C3%AAta
 * @eee https://www.youtube.com/watch?v=QTw8VJzRW6g&t=0s&list=PL6Xpj9I5qXYGhsvMWM53ZLfwUInzvYWsm&index=18
 */
public class MiniMax implements MiniMaxInterface {

    public static final int MIN_INFINITE = 1000;
    public static final int MAX_INFINITE = -1000;

    private int depth = 0;
    private boolean endOfGame = false;

    private ArrayList<Move> moves;
    private int currentIndexMove;

    /**
     * Class constructor
     */
    public MiniMax() {


    }


    @Override
    public int min() {

        if (depth == 0 || endOfGame) {
            return eval();
        }

        int min = MIN_INFINITE;

        for(Move move : moves.get(currentIndexMove)) {

        }

        return 0;
    }

    @Override
    public int max() {
        return 0;
    }

    @Override
    public int eval() {
        return 0;
    }
}
