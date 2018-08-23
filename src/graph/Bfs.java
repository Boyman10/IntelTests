package graph;

import java.util.*;

/**
 * Breadth First Search algorihtm for a graph
 * given a vertice, we  can not revisit it again
 *      * we explore adjacent vertices progressively
 *      * A stack keeps track of already visited vertices
 * @see https://fr.wikipedia.org/wiki/Algorithme_de_parcours_en_largeur
 * @see https://en.wikipedia.org/wiki/Breadth-first_search
 */
public class Bfs {

    /**
     * Properties
     */
    private int V;   // No. of vertices
    private List<List<Integer>> graph; //Adjacency Lists

    /**
     * Class constructor
     * initialize tree
     * ie: [[1, 2, 5], [0, 2, 5], [0, 1], [4, 5], [3, 5], [0, 1, 3, 4]]
     */
    public Bfs(int size) {
        V = size;
        graph = new ArrayList<>();
    }

    /**
     * Adding a node to the graph
     *
     * @param vertices
     */
    public void addVertice(List<Integer> vertices) {

        graph.add(vertices);
    }

    /**
     * Given sourceNode, retrieves the route table so we can get the shortest path from any the sourceNode to any vertice
     *
     * @param int sourceNode
     * @return routes
     */
    public Hashtable routeMap(int sourceNode) {

        LinkedList<Integer> queue = new LinkedList<>();  // size of graph

        // the thing we need to build here
        Hashtable routes = new Hashtable();
        routes.put(sourceNode,sourceNode);

        // insert first node
        queue.add(sourceNode);

        // Tracking the visited vertices
        ArrayList<Integer> visited = new ArrayList<>();

        // let's now explore the graph :
        while(!queue.isEmpty()) {

            Integer elt = queue.poll(); // retrieves and removes the head of the queue FIFO mode
            // Mark the current node as Visited
            visited.add(elt);

            // loop throught neighbors of current node :
            for(Integer node : graph.get(elt)) {

                if (!visited.contains(node)) {
                    routes.put(node,elt);
                    queue.add(node);
                    visited.add(node);
                    System.out.println("new node added to stack ; " + node);
                }
            }

        }

        return routes;
    }
}