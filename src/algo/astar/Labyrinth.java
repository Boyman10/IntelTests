package algo.astar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Hashtable<Integer, ArrayList<Character>> labyrinth = new Hashtable<>();

    // Max turns to get back to initial position
    private int cpt_max;

    // initialize the map
    public Labyrinth(int R, int C, int A) {

        // R >= 10 && <= 100 && C >= 20 && C <= 200 && A >= 1 && A <= 100
        for (int i = 0;i < R; i++) {

            labyrinth.put(i,new ArrayList<>());
            this.cpt_max = A;
        }
    }

    /*
     * Transposing the game play into a graph :
     * at each turn, the map is updated, we are looking for the control room (the final node)
     * we are starting from a certain position (original node)
     * What kind of heuristic can be applied here ?
     * -> take first direction where no wall and continue
     * -> take the direction where there is more space left to discover ?
     * a new node can be a spot defined as the next current destination (end of visible space in the taken destination :))
     *
     * This is going to be a bi directed weighted graph which is constructed at each turn with a new node
     * a node is represented by its position in the map
     * At each turn we analyse the best next node, if it changes, we add the current position as a node
     * and update the weights (a weight can be represented by  number and a direction ! - opposite in case of reverse !).
     */

    public void updateLabyrinth(String row, int line) {

        this.labyrinth.put(line, Arrays.asList(row));

    }


}
