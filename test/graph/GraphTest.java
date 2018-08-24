package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * testing graph generation
 */
class GraphTest {

   private Graph graph;

    @Test
    void fillingGraphV1Test() {

        //Example of graph to test :
        graph = new Graph(4,4,1);

        graph.fillGraphV1(0,1);
        graph.fillGraphV1(0,2);
        graph.fillGraphV1(1,3);
        graph.fillGraphV1(2,3);

        // the graph to obtain :
        List<List<Integer>> graphV1 = new ArrayList<>();
        graphV1.add(0,(new ArrayList(Arrays.asList(1,2))));
        graphV1.add(1,(new ArrayList(Arrays.asList(3))));
        graphV1.add(2,(new ArrayList(Arrays.asList(3))));

        assertEquals(graphV1,graph.getGraphV1());

    }
    @Test
    void fillingGraphV2Test() {

        //Example of graph to test :
        graph = new Graph(4,4,1);

        graph.fillGraphV2(0,1);
        graph.fillGraphV2(0,2);
        graph.fillGraphV2(1,3);
        graph.fillGraphV2(2,3);

        // the graph to obtain :
        Hashtable<Object,ArrayList<Integer>> graphV2 = new Hashtable<>();
        graphV2.put(0,(new ArrayList(Arrays.asList(1,2))));
        graphV2.put(1,(new ArrayList(Arrays.asList(3))));
        graphV2.put(2,(new ArrayList(Arrays.asList(3))));

        assertEquals(graphV2,graph.getGraphV2());

    }

}