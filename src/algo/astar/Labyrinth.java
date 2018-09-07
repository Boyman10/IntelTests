package algo.astar;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Implementing BFS, A* for a specific labyrinth 2D game
 * @see https://www.youtube.com/watch?v=8_dGurEKXDk&t=0s&list=PL6Xpj9I5qXYGhsvMWM53ZLfwUInzvYWsm&index=9
 */
public class Labyrinth {

    /**
     * Constants
     */
    private static final char WALL = '#';
    private static final char EMPTY = ' ';
    private static final char START = 'T';
    private static final char COMMAND = 'C';
    private static final char NOT_SCANNED = '?';

    /**
     * Properties
     */
    int startPos[] = new int[2];
    int commandPos[] = new int[2];

    int currentPos[] = new int[2];

    // our map : LINES & COLUMNS
    private Hashtable<Integer, ArrayList<Character>> labyrinth;

    // Max turns to get back to initial position
    int cpt_max;

    // initialize the map
    public Labyrinth(int R, int C, int A) {

        // R >= 10 && <= 100 && C >= 20 && C <= 200 && A >= 1 && A <= 100
        for (int i = 0;i<R;i++) {

            labyrinth.put(i,new ArrayList<>());
            this.cpt_max = A;
        }
    }



}
