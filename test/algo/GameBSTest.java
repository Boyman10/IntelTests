package algo;

import algo.binarysearch.GameBS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBSTest {

    GameBS gbs = new GameBS(10,10,6,2,5);

    @Test
    void getFrom2D() {
        assertEquals(52,gbs.getFrom2D(2,5));
    }

    @Test
    void setTo2D() {

        int[] tmp = {2,5};

        assertArrayEquals(tmp, (gbs.setTo2D(52)));
    }
}