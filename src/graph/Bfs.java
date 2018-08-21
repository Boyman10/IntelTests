package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Breadth First Search algorihtm for a graph
 * given a vertice, we  can not revisit it again
 *      * we explore adjacent vertices progressively
 *      * A stack keeps track of already visited vertices
 * @see https://fr.wikipedia.org/wiki/Algorithme_de_parcours_en_largeur
 * @see https://en.wikipedia.org/wiki/Breadth-first_search
 */
public class Bfs {
•
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
     * @param vertices
     */
    public void addVertice(List<Integer> vertices) {

        graph.add(vertices);
    }


    /**
     * Algorithm
     * given source node, provide the different routes from it
     */
    public List<Integer> bfsRoutes(int sourceNode) {

        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[sourceNode]=true;
        queue.add(sourceNode);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            sourceNode = queue.poll();

            System.out.print(sourceNode + " "); // @TODO change to result type

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = graph.get(sourceNode).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return null;
    }
}
