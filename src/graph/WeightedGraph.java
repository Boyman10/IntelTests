package graph;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Class representing a weighted graph
 * ie : [[(1, 1), (2, 7), (5, 3)], [(0, 1), (2, 1), (5, 1)], [(0, 7), (1, 1)], [(4, 2), (5, 2)], [(3, 2), (5, 5)], [(0, 3), (1, 1), (3, 2), (4, 5)]]
 * Expected results for Dijkstra:
 * result = [0, 1, 2, 4, 6, 2].
 * routes = [None, 0, 1, 5, 3, 1].
 */
public class WeightedGraph {


    private Hashtable<Object,Hashtable<Object,Object>> graph;

    public WeightedGraph() {


        graph = new Hashtable<>();


    }

    /**
     * Filling the graph one by one given the following
     * @param srcNode source Node
     * @param nextNode linked node
     * @param weight represents the weight
     */
    public void fillGraph(int srcNode, int nextNode, int weight) {


            Hashtable<Object,Object> nodes = graph.get((Integer)srcNode);

            // Adding dest to the array
            if (nodes == null) {
                nodes = new Hashtable<>();
            }

            // adding weight next to the linked node
            nodes.put(nextNode,weight);
            // Then add the node details to the graph
            graph.put(srcNode, nodes);


    }

    /**
     * REtrieve the generated graph
     * @return
     */
    public Hashtable<Object,Hashtable<Object,Object>> getGraph() {

        System.out.println(this.graph);

        return this.graph;
    }
}
