package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void bfsRoutesTest() {

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
        List<Integer> route = new ArrayList<>();
        route.add(sourceNode);

        route.add(0);
        route.add(0);
        route.add(5);
        route.add(5);
        route.add(0);

        assertEquals(route,bfs.bfsRoutes(sourceNode));

    }
}
