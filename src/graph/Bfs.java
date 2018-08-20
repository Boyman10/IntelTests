package graph;

import java.util.LinkedList;

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
    private LinkedList<Integer> adj[]; //Adjacency Lists

    /**
     * Class constructor
     *
     */
    public Bfs() {

    }
}
