package algo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    BinarySearch bns;

    @Test
    void recursiveSearchTest() {

        // Array to test :
        // [1,5,8,12] - must find 8
        bns = new BinarySearch(new ArrayList(Arrays.asList(1,5,8,12)));

        assertEquals(2,(int) bns.recursiveSearch(8));
    }


    /**
     * Testing entries 10x10 map - 6 objects to find - starting position 2,5
     */
    @Test
    void batmanTest() {

        Scanner in ;

        System.setIn(new ByteArrayInputStream("10\n10\n6\n2\n5\n".getBytes()));
        in = new Scanner(System.in);


        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // the location of the next window Batman should jump to.
            System.out.println("0 0");
        }
    }


    }
}