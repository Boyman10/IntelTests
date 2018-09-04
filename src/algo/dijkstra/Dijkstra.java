package algo.dijkstra;

import graph.Graph;

/**
 * Shortest path algorithm from 1 node to others in a graph - 1-to-*
 * Takes a weighted graph and an initial node
 * @see http://formations.telecom-bretagne.eu/pyrat/?p=138
 */
public class Dijkstra {

    /**
     * A graph variable which is already ordered by node from the nearest to the farthest
     */
    Graph myGraph;

    /**
     * Constructor class
     * @param graph is weighted graph
     * @param index represents an initial node
     */
    public Dijkstra(Graph graph, Object index) {

        this.myGraph = graph;

    }
}
