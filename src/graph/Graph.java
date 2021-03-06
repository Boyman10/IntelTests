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
    public static final int MIN_EXITS = 1;
    public static final int MAX_EXITS = 20;

    /**
     * Properties
     */
    private int V;   // No. of vertices
    private int L; // Nb of links
    private ArrayList<Integer> exits;

    @Deprecated
    private List<List<Integer>> graphV1; //Adjacency Lists - ex : [[1, 2, 5], [0, 2, 5], [0, 1], [4, 5], [3, 5], [0, 1, 3, 4]]
    private Hashtable<Object,ArrayList<Integer>> graphV2; // Another type of graph with keys which can be of any type - @Todo genericity


    /**
     * Class constructor giving the nb of nodes, nb of links and nb of exits,
     * @param nbNodes total nodes
     * @param nbLinks total links
     * @param nbExits total exits
     */
    public Graph(int nbNodes, int nbLinks, int nbExits) {

        if (nbNodes >= MIN_NODES && nbNodes <= MAX_NODES && nbLinks <= MAX_LINKS
                && nbLinks >= MIN_LINKS && nbExits >= MIN_EXITS && nbExits <= MAX_EXITS) {
            exits = new ArrayList<>();

            graphV1 = new ArrayList<>();
            graphV2 = new Hashtable<>();

            // Initialize GraphV1 with -1 values :
            for(int i = 0;i<nbNodes;i++)
                graphV1.add(new ArrayList<>());


            V = nbNodes;

        } else {
            System.err.println("out of bounds...");
        }
    }


    /**
     * Filling the graph one by one given the following
     * This is one way linking version
     * @see fillGraph2WV1 for 2 way linking
     * @param srcNode source Node
     * @param nextNode linked node
     */
    public void fillGraphV1(int srcNode, int nextNode) {

        if (srcNode < V && srcNode >= 0 && nextNode < V && nextNode >= 0) {

            ArrayList<Integer> nodes = new ArrayList<>();

            try {
                System.out.println("Getting current array of src Node : " + srcNode);

                nodes =  (ArrayList<Integer>) graphV1.get(srcNode);

                // Adding dest to the array
                nodes.add(nextNode);

            } catch (IndexOutOfBoundsException e) {
                System.out.println("initializing nodes array for src node : " + srcNode);
                nodes.add(nextNode);
                graphV1.add(srcNode, nodes);
                return;
            }

            graphV1.set(srcNode, nodes);

        } else {
            System.err.println("OUt of bound Node!!");
        }
    }

    /**
     * 2 way linking graph version
     * @param srcNode source Node which can also be destination
     * @param nextNode linked node which can be source as well
     */
    public void fillGraph2WV1(int srcNode, int nextNode) {

        if (srcNode < V && srcNode >= 0 && nextNode < V && nextNode >= 0) {

            ArrayList<Integer> nodes = new ArrayList<>();
            ArrayList<Integer> destnodes = new ArrayList<>();

            try {
                System.out.println("Getting current array of src Node : " + srcNode);

                nodes =  (ArrayList<Integer>) graphV1.get(srcNode);
                destnodes = (ArrayList<Integer>) graphV1.get(nextNode);

                // Adding dest to the array
                nodes.add(nextNode);
                // and src
                destnodes.add(srcNode);

            } catch (Exception e) {

                e.printStackTrace();
                System.err.println(e.getMessage());
            }

            graphV1.set(srcNode, nodes);
            graphV1.set(nextNode, destnodes);

        } else {
            System.err.println("OUt of bound Node!!");
        }
    }

    /**
     * Filling the graph one by one given the following
     * @param srcNode source Node
     * @param nextNode linked node
     */
    public void fillGraphV2(int srcNode, int nextNode) {

        if (srcNode < V && srcNode >= 0 && nextNode < V && nextNode >= 0) {

            ArrayList<Integer> nodes = (ArrayList<Integer>) graphV2.get(srcNode);
            // Adding dest to the array
            if (nodes == null) {
                nodes = new ArrayList<>();
            }

            nodes.add(nextNode);
            graphV2.put(srcNode, nodes);

        } else {
            System.err.println("OUt of bound Node!!");
        }
    }

    /**
     * REtrieve the generated graph
     * @return
     */
    public Hashtable<Object,ArrayList<Integer>> getGraphV2() {

        System.out.println(this.graphV2);

        return graphV2;
    }

    /**
     * REtrieve the generated graph
     * @return
     */
    public List<List<Integer>> getGraphV1() {

        System.out.println("THe graph : " + this.graphV1);

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
