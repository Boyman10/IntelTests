package graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static javax.swing.UIManager.put;
import static org.junit.jupiter.api.Assertions.*;

class WeightedGraphTest {

    WeightedGraph wGraph = new WeightedGraph();

    @Test
    void fillGraphTest() {

        // * ie : [[(1, 1), (2, 7), (5, 3)],
        // [(0, 1), (2, 1), (5, 1)],
        // [(0, 7), (1, 1)],
        // [(4, 2), (5, 2)],
        // [(3, 2), (5, 5)],
        // [(0, 3), (1, 1), (3, 2), (4, 5)]]

        Hashtable<Integer,Hashtable<Integer,Integer>> myGraph = new Hashtable<>();
        Hashtable<Integer,Integer> node ;

        node = new Hashtable<Integer, Integer>() {{ put(1, 1); put(2, 7); put(5,3) ;}};
        myGraph.put(0,node);
        node = new Hashtable<Integer, Integer>() {{ put(0, 1); put(2, 1); put(5,1) ;}};
        myGraph.put(1,node);
        node = new Hashtable<Integer, Integer>() {{ put(0, 7); put(1, 1);}};
        myGraph.put(2,node);
        node = new Hashtable<Integer, Integer>() {{ put(4, 2); put(5, 2);}};
        myGraph.put(3,node);

        node = new Hashtable<Integer, Integer>() {{ put(3, 2); put(5, 5);}};
        myGraph.put(4,node);
        node = new Hashtable<Integer, Integer>() {{ put(0, 3); put(1, 1); put(3,2); put(4,5);}};
        myGraph.put(5,node);
        // Object WeightedGraph :

        wGraph.fillGraph(0, 1, 1);
        wGraph.fillGraph(0, 2, 7);
        wGraph.fillGraph(0, 5, 3);
        wGraph.fillGraph(1, 0, 1);
        wGraph.fillGraph(1, 2, 1);
        wGraph.fillGraph(1, 5, 1);
        wGraph.fillGraph(2, 0, 7);
        wGraph.fillGraph(2, 1, 1);
        wGraph.fillGraph(3, 4, 2);
        wGraph.fillGraph(3, 5, 2);
        wGraph.fillGraph(4, 3, 2);
        wGraph.fillGraph(4, 5, 5);
        wGraph.fillGraph(5, 0, 3);
        wGraph.fillGraph(5, 1, 1);
        wGraph.fillGraph(5, 3, 2);
        wGraph.fillGraph(5, 4, 5);

        assertEquals(myGraph,wGraph.getGraph());

    }
}