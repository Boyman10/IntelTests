package algo.astar;

import graph.WeightedGraph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;


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
    private int startPos[] = new int[2];
    private int commandPos[] = new int[2];

    private int currentPos[] = new int[2];

    private int nbRows, nbCols;

    // our map : 1D POSITION - CHARACTER
    private Hashtable<Integer,Character> labyrinth = new Hashtable<>();

    // Max turns to get back to initial position
    private int cpt_max;


    /**
     * Graph details
     */

    private WeightedGraph myGraph = new WeightedGraph();


    /**
     * Initialize the map
     * @param R row
     * @param C columns
     * @param A max time
     */
    public Labyrinth(int R, int C, int A) {

        // R >= 10 && <= 100 && C >= 20 && C <= 200 && A >= 1 && A <= 100
        for (int i = 0;i < C*R; i++) {

            labyrinth.put(i,NOT_SCANNED);
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
        for (int i = 0; i < str.length; i++) {
            this.labyrinth.put(line + i,str[i]);
        }
       // this.labyrinth.put(line,new ArrayList<>(Arrays.asList(str)));

    }

    /**
     * Localizing an item in the map :
     * the item must be unique ! @TODO : implement anyMatch instead of forEach
     * @param item to get the position
     * @return the position
     */
    private int localizeItem(char item){

        int pos = -1;

        for(int i = 0; i < labyrinth.size();i ++)
        {
                    if (labyrinth.get(i).equals(item)) {
                        pos = i;
                    }
        }


        return pos;
    }


    public void setCurrentPos(int[] cur) {
        this.currentPos = cur;
    }

    /**
     * The map must be initialized first
     */
    public void setStartPos() {

        this.startPos = setTo2D(localizeItem(START));
    }

    public int[] getStartPos() {
        return this.startPos;
    }

    /**
     * Let's build our weighted graph
     */
    public void buildGraph() {

        // first time :
        if (this.currentPos == null) {

            setStartPos();
            this.myGraph.fillGraph(getFrom2DArray(this.startPos),getFrom2DArray(this.startPos),0);
            this.currentPos = this.startPos;

        } else {

            // 4 paths or less for each turn LEFT, RIGHT, UP, DOWN
            // fillGraph(int srcNode, int nextNode, int weight) the srcNode is the currentPosition
            int srcNode = getFrom2DArray(this.currentPos);
            List nextNode = longestPathInMap(); // with direction ex: 2RIGHT then the weight ex : 3

        }

    }

    /**
     * Transform a 2D position into a 1D one
     * ex : 2 lines and 4 columns
     * @param l row position
     * @param r col position
     * @return position 1D
     */
    public int getFrom2D(int l, int r) {

        return (l * (this.nbCols) + r);
    }

    public int getFrom2DArray(int [] arr) {

        return (arr[0] * (this.nbCols) + arr[1]);
    }

    /**
     * Get the longest path with no wall given the visible map and current position
     * @return a position along with direction and the length size of List = 2 as we concatenate the position and direction
     * it is a 3 elements list of int and Object
     */
    public List<String> longestPathInMap() {

        List<String> longest = new ArrayList<>();

        int thePos = getFrom2DArray(this.currentPos);
        longest.add(String.valueOf(thePos)); // origin
        longest.add(String.valueOf(thePos)); // destination
        longest.add(String.valueOf(0)); // distance + direction

        int dist = 0;

        // Left direction :
        while (labyrinth.get(thePos).equals(EMPTY)) {
            thePos = getNext(Direction.LEFT, thePos);
            dist++;
        }

        longest.set(1,String.valueOf(thePos));
        longest.set(2,dist + Direction.LEFT.toString());

        int tmp = dist;
        dist = 0;
        thePos = getFrom2DArray(this.currentPos);

        // right direction :
        while (labyrinth.get(thePos).equals(EMPTY)) {
            thePos = getNext(Direction.RIGHT, thePos);
            dist++;
        }

        if (tmp < dist) {
            tmp = dist;
            longest.set(1,String.valueOf(thePos));
            longest.set(2,dist + Direction.RIGHT.toString());
        }

        thePos = getFrom2DArray(this.currentPos);

        dist = 0;

        // top direction :
        while (labyrinth.get(thePos).equals(EMPTY)) {
            thePos = getNext(Direction.UP, thePos);
            dist++;
        }

        if (tmp < dist) {
            tmp = dist;
            longest.set(1,String.valueOf(thePos));
            longest.set(2,dist + Direction.UP.toString());
        }

        thePos = getFrom2DArray(this.currentPos);

        // top direction :
        while (labyrinth.get(thePos).equals(EMPTY)) {
            thePos = getNext(Direction.DOWN, thePos);
            dist++;
        }

        if (tmp < dist) {
            tmp = dist;
            longest.set(1,String.valueOf(thePos));
            longest.set(2,dist + Direction.DOWN.toString());
        }


        return longest;

    }

    /**
     * Transform a 1D position into a 2D one
     * @param position 52
     * @return [2,5]
     */
    public int[] setTo2D(int position) {

        int pos[] = new int[2];
        pos[0] = position % this.nbCols; // ex : 2
        pos[1] = position / this.nbRows;

        return pos;
    }


    public int getNext(Direction dir, int pos) {

        if (dir == Direction.LEFT) {
            return pos - 1;
        } else if (dir == Direction.RIGHT) {
            return pos + 1;
        } else if (dir == Direction.UP) {
            return pos - this.nbCols;
        } else {
            return pos + this.nbCols;
        }
    }

    @Override
    public String toString() {
        return labyrinth.toString() ;
    }
}
