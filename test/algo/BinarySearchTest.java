package algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch bns;

    @Test
    void recursiveSearchTest() {

        // Array to test :
        // [1,5,8,12] - must find 8
        bns = new BinarySearch(new ArrayList(Arrays.asList(1,5,8,12)));

        assertEquals(2,(int) bns.recursiveSearch(8));
    }
}