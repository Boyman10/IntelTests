package maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Equation3Test {

    @Test
    void test_compute_sarrus()
    {
        double[][] matrice = {{2,-1,-2},{6,-1,1},{4,5,3}};

        Assertions.assertEquals(Equation3.computeSarrus(matrice), -70);
    }
}