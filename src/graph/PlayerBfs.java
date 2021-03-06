package graph;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class PlayerBfs {

    public static void main(String args[]) {
        Scanner in;

        System.setIn(new ByteArrayInputStream("12\n23\n1\n".getBytes()));
        in = new Scanner(System.in);


        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        System.err.println("N : " + N + " L : " + L + " E : " + E);

        Graph myGraph = new Graph(N, L, E);

        System.setIn(new ByteArrayInputStream("11\n6\n0\n9\n1\n2\n0\n1\n10\n1\n11\n5\n2\n3\n4\n5\n8\n9\n6\n7\n7\n8\n0\n6\n3\n4\n0\n2\n11\n7\n0\n8\n0\n4\n9\n10\n0\n5\n0\n7\n0\n3\n0\n10\n5\n6\n".getBytes()));
        in = new Scanner(System.in);

        for (int i = 0; i < L; i++) {

            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();

            System.err.println("N1 : " + N1 + " N2 : " + N2 );

            myGraph.fillGraph2WV1(N1,N2);
        }

        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        in = new Scanner(System.in);

        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            myGraph.addExit(EI);
        }

        Bfs algo = new Bfs(N);
        algo.setGraph(myGraph.getGraphV1());


        System.setIn(new ByteArrayInputStream("11\n".getBytes()));
        in = new Scanner(System.in);

        // game loop
        while (true) {

            int SI = in.nextInt() ; // The index of the node on which the Skynet agent is positioned this turn
            int nextExit, nextNode = SI;

            // Do the math here ...
            // SI represents a src node, we need to cut the next best destination based on shortest path to next Exit.
            ArrayList<Integer> pathToNext = new ArrayList<>();

            // iterate through exits to get the smallest routing table :
            int sizeRoute = Graph.MAX_NODES; // the routing table can not be mode than the nb of nodes

            for(Integer nExit: myGraph.getExits()) {
                ArrayList<Integer> path = algo.shortestPath(SI, nExit);
                if (sizeRoute > path.size()) {
                    sizeRoute = path.size();
                    nextExit = nExit; // this one is the next best exit !
                    pathToNext = path;
                }
            }

            // now retrieve the next node to cut (link from src node to next one) :
            // That is second element of path array :
            try {
                nextNode = pathToNext.get(1);

            } catch (IndexOutOfBoundsException e) {
                System.err.println("Out of bounds on pathToNext : " + pathToNext.size());
            }


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            System.out.println(SI + " " + nextNode);
        }
    }
}

/*
class Graph {


    public static final int MAX_NODES = 500;
    public static final int MIN_NODES = 2;
    public static final int MAX_LINKS = 1000;
    public static final int MIN_LINKS = 1;
    public static final int MIN_EXITS = 1;
    public static final int MAX_EXITS = 20;


    private int V;   // No. of vertices
    private int L; // Nb of links
    private ArrayList<Integer> exits;

    private List<List<Integer>> graphV1; //Adjacency Lists - ex : [[1, 2, 5], [0, 2, 5], [0, 1], [4, 5], [3, 5], [0, 1, 3, 4]]

    public Graph(int nbNodes, int nbLinks, int nbExits) {

        if (nbNodes >= MIN_NODES && nbNodes <= MAX_NODES && nbLinks <= MAX_LINKS
                && nbLinks >= MIN_LINKS && nbExits >= MIN_EXITS && nbExits <= MAX_EXITS) {
            exits = new ArrayList<>();

            graphV1 = new ArrayList<>();

            V = nbNodes;

        } else {
            System.err.println("out of bounds...");
        }
    }


    public void fillGraphV1(int srcNode, int nextNode) {

        if (srcNode < V && srcNode >= 0 && nextNode < V && nextNode >= 0) {

            ArrayList<Integer> nodes = new ArrayList<>();

            try {
                System.err.println("Getting current array of src Node : " + srcNode);

                nodes =  (ArrayList<Integer>) graphV1.get(srcNode);

                // Adding dest to the array
                nodes.add(nextNode);

            } catch (IndexOutOfBoundsException e) {
                System.err.println("initializing nodes array for src node : " + srcNode);
                nodes.add(nextNode);
                graphV1.add(srcNode, nodes);
                return;
            }

            graphV1.set(srcNode, nodes);

        } else {
            System.err.println("OUt of bound Node!!");
        }
    }


    public List<List<Integer>> getGraphV1() {

        System.out.println(this.graphV1);

        return graphV1;
    }

    public void addExit(int exit) {

        if (exit >= 0 && exit < V)
            exits.add(exit);
    }

    public ArrayList<Integer> getExits() {
        return exits;
    }


}

class Bfs {


    private int V;   // No. of vertices
    private List<List<Integer>> graph; //Adjacency Lists


    public Bfs(int size) {
        V = size;
        graph = new ArrayList<>();
    }

    public void addVertice(List<Integer> vertices) {

        graph.add(vertices);
    }

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
                    //  System.out.println("new node added to stack ; " + node);
                }
            }

        }

        return routes;
    }



    public ArrayList<Integer> shortestPath(int srcNode, int destNode) {

        ArrayList<Integer> path = new ArrayList<>();

        // Get the routing table of the srcNode :
        Hashtable routing =  routeMap(srcNode);

        // Now the shortest path :
        int tmp = destNode;
        path.add(tmp);

        while (tmp != srcNode) {
            tmp = (int)routing.get(tmp);
            path.add(tmp);
        }

        // reverse it
        Collections.reverse(path);

        return path;
    }

    public void setGraph(List<List<Integer>> graph) {
        this.graph = graph;
    }
}

*/