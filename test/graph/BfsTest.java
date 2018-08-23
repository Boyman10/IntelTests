package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BfsTest {

    Bfs bfs;

    /**
     * Testing the follozing graph :
     *  [[1, 2, 5], [0, 2, 5], [0, 1], [4, 5], [3, 5], [0, 1, 3, 4]]
     * @return
     */

    @Test
    void routeMapTest() {

        // Our example graph
        bfs = new Bfs(6);
        bfs.addVertice(new ArrayList(Arrays.asList(1,2,5)));
        bfs.addVertice(new ArrayList(Arrays.asList(0,2,5)));
        bfs.addVertice(new ArrayList(Arrays.asList(0,1)));
        bfs.addVertice(new ArrayList(Arrays.asList(4,5)));
        bfs.addVertice(new ArrayList(Arrays.asList(3,5)));
        bfs.addVertice(new ArrayList(Arrays.asList(0,1,3,4)));

        // The source node :
        int sourceNode = 1;
        // our expected result :
        Hashtable route = new Hashtable();
        // expecting [null ot soutceNode, 0, 0, 5, 5, 0].
        route.put(0,1);

        route.put(1,1);
        route.put(2,1);
        route.put(3,5);
        route.put(4,5);
        route.put(5,1);

        assertEquals(route,bfs.routeMap(sourceNode));
    }
}
