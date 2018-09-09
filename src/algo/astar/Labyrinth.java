package algo.astar;

import graph.WeightedGraph;

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

    int nbRows, nbCols;

    // our map : LINES & COLUMNS
    private Hashtable<Integer, ArrayList<Character>> labyrinth = new Hashtable<>();

    // Max turns to get back to initial position
    private int cpt_max;


    /**
     * Graph details
     */

    private WeightedGraph myGraph = new WeightedGraph();
    // Position and directions int the order from last to current node - the integer is in 1D to be converted to 2D
    private Hashtable<Integer,ArrayList<Direction>> weights = new Hashtable<>();

    /**
     * Initialize the map
     * @param R row
     * @param C columns
     * @param A max time
     */
    public Labyrinth(int R, int C, int A) {

        // R >= 10 && <= 100 && C >= 20 && C <= 200 && A >= 1 && A <= 100
        for (int i = 0;i < R; i++) {

            labyrinth.put(i,new ArrayList<>());
            this.cpt_max = A;
        }

        this.nbRows = R;
        this.nbCols = C;
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

    /**
     * Updating the map one line by one
     * @param row a row represented by a string
     * @param line the line with its content
     */
    public void updateLabyrinth(String row, int line) {

        Character[] str = row.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        this.labyrinth.put(line,new ArrayList<>(Arrays.asList(str)));

    }

    /**
     * Localizing an item in the map :
     * the item must be unique ! @TODO : implement anyMatch instead of forEach
     * @param item to get the position
     * @return the position
     */
    private int[] localizeItem(char item){

        int[] pos = new int[2];

        labyrinth.forEach((index,myArray) ->

            myArray.forEach((v) -> {
                if (v.equals(item)) {
                    pos[0] = index;
                    pos[1] = myArray.indexOf(v);
                }
            })
                );
        return pos;
    }


    public void setCurrentPos(int[] cur) {
        this.currentPos = cur;
    }

    /**
     * The map must be initialized first
     */
    public void setStartPos() {

        this.startPos = localizeItem(START);
    }

    /**
     * Let's build our weighted graph
     */
    public void buildGraph() {

        // 4 paths or less for each turn LEFT, RIGHT, UP, DOWN
        // fillGraph(int srcNode, int nextNode, int weight) the srcNode is the currentPosition
        int srcNode =

    }

    /**
     * Transform a 2D position into a 1D one
     * ex : 2 lines and 4 columns
     * @param l 1
     * @param 3
     * @return 7
     */
    public int getFrom2D(int l, int r) {

        // l x 4 + 3 -> 7
        // ex : l = 2, r = 2, (3 lines, 4 columns) 2x4 + 2 = 11
        return (l * this.nbCols + r );
    }
}
