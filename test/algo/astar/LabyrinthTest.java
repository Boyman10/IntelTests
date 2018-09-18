package algo.astar;

import org.junit.jupiter.api.Test;

import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class LabyrinthTest {

    Labyrinth lab ;

    @Test
    void getFrom2D() {

        lab = new Labyrinth(3, 5, 0);

        // Retrieve 1D index from 2D position in the lab : ex : (2,3)
        assertEquals(13 ,lab.getFrom2D(2, 3));
        assertEquals(9 ,lab.getFrom2D(1, 4));
    }

    @Test
    void updateLabyrinth() {
        lab = new Labyrinth(3, 5, 0);

        String str = "";

        lab.updateLabyrinth("?????",0);
        lab.updateLabyrinth("# T #",1);
        lab.updateLabyrinth("?????",2);

        assertEquals(str,lab.toString());

    }

    @Test
    void longestPathInMap() {

        lab = new Labyrinth(3, 5, 0);




    }
}