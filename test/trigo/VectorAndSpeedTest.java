package trigo;

import maths.Equation3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VectorAndSpeedTest {

    @Test
    void test_is_on_path()
    {
        //System.out.println("On path ? : " + isOnPath(5716,3186,6557,3205,10305,3339, 800));
        Assertions.assertFalse(VectorAndSpeed.isOnPath(1,2,3,2,6,3, 0));
        Assertions.assertTrue(VectorAndSpeed.isOnPath(1,2,3,2,6,3, 1));
        Assertions.assertTrue(VectorAndSpeed.isOnPath(5716,3186,6557,3205,10305,3339, 800));

    }


}