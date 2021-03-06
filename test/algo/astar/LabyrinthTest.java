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

        String str = "{14=?, 13=?, 12=?, 11=?, 10=?, 9=?, 8=?, 7=?, 6=?, 5=?, 4=?, 3=?, 2=?, 1=#, 0=?}";

        lab.updateLabyrinth("?????",0);
        lab.updateLabyrinth("# T #",1);
        lab.updateLabyrinth("?????",2);

        assertEquals(str,lab.toString());

    }

    @Test
    void longestPathInMap() {

        lab = new Labyrinth(3, 5, 0);
        lab.updateLabyrinth("?????",0);
        lab.updateLabyrinth("# T #",1);
        lab.updateLabyrinth("?????",2);

        lab.setStartPos();
        lab.setCurrentPos(lab.getStartPos());

        String str = "761LEFT"; // 7 6 1LEFT

        assertEquals(str,lab.longestPathInMap());


    }
}