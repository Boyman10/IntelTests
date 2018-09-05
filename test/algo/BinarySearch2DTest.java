package algo;

import algo.binarysearch.BinarySearch2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinarySearch2DTest {

    @Test
    void nextMoveGivenPositionAndClueTest() {

        int[][] myArray = new int[10][10];

        BinarySearch2D b2d = new BinarySearch2D(myArray);
        int[] pos = {2,5};
        int[] res = {6,2};

        assertArrayEquals(res,b2d.nextMoveGivenPositionAndClue(pos,"UR"));

    }
}