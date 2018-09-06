package algo.dijkstra;

import graph.Graph;
import graph.WeightedGraph;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Shortest path algorithm from 1 node to others in a graph - 1-to-*
 * Takes a weighted graph and an initial node
 *  ie : [[(1, 1), (2, 7), (5, 3)], [(0, 1), (2, 1), (5, 1)], [(0, 7), (1, 1)], [(4, 2), (5, 2)], [(3, 2), (5, 5)], [(0, 3), (1, 1), (3, 2), (4, 5)]]
 *  * Expected results for Dijkstra:
 *  * result = [0, 1, 2, 4, 6, 2].
 *  * routes = [None, 0, 1, 5, 3, 1].
 * @see http://formations.telecom-bretagne.eu/pyrat/?p=138
 */
public class Dijkstra {

    private static final Integer INFINITE_NB = 1_000_000;

    /**
     * A graph variable which is already ordered by node from the nearest to the farthest
     */
    WeightedGraph myGraph;

    private ArrayList<Object> paths;
    private Hashtable<Integer,Integer> minHeap; // ie : {(node 1, distance 1), (node 2, distance 7), (node 5, distance 3)}

    /**
     * Constructor class
     * @param graph is a weighted graph
     */
    public Dijkstra(WeightedGraph graph) {

        this.myGraph = graph;
        paths = new ArrayList<>();
        minHeap = new Hashtable<>();

        for (int i = 0; i < graph.getGraph().size();i++) {
            paths.add(INFINITE_NB);
        }
    }

    /**
     * Generate an array of distances to other nodes
     * @param sourceNode the source node from which we explore the graph
     */
    public void generatePathsFromNode(Object sourceNode) {

    }
}
