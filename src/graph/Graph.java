package graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Class which purpose is to generate a graph given vertices and links
 * Made for a game : skynet
 * @author Boyman
 * @version 1.0.0
 */
public class Graph {

    /**
     * Constants
     */
    public static final int MAX_NODES = 500;
    public static final int MIN_NODES = 2;
    public static final int MAX_LINKS = 1000;
    public static final int MIN_LINKS = 1;


    /**
     * Properties
     */
    private int V;   // No. of vertices
    private int L; // Nb of links
    private List<List<Integer>> graphV1; //Adjacency Lists - ex : [[1, 2, 5], [0, 2, 5], [0, 1], [4, 5], [3, 5], [0, 1, 3, 4]]

    private Hashtable<Object,List<Integer>> graphV2; // Another type of graph with keys which can be of any type - @Todo genericity


    /**
     * Class constructor giving the nb of nodes, nb of links and nb of exits,
     * @param nbNodes total nodes
     * @param nbLinks total links
     * @param nbExits total exits
     */
    public Graph(int nbNodes, int nbLinks, int nbExits) {

        graphV1 = new ArrayList<>();
        V = nbNodes;

    }



}
