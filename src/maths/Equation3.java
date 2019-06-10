package maths;

import java.util.AbstractMap;

/**
 * Given 3 points, get the equation of a curve
 */
public class Equation3 {

    private AbstractMap.SimpleImmutableEntry<Double, Double> A;
    private AbstractMap.SimpleImmutableEntry<Double, Double> B;
    private AbstractMap.SimpleImmutableEntry<Double, Double> C;

    private double[] abc = new double[3];

    public double[] getAbc() {
        return abc;
    }

    public Equation3(AbstractMap.SimpleImmutableEntry<Double, Double> a,
                     AbstractMap.SimpleImmutableEntry<Double, Double> b,
                     AbstractMap.SimpleImmutableEntry<Double, Double> c) {
        A = a;
        B = b;
        C = c;
    }

    /**
     * Get the equation given the 3 points
     * Setter of a,b,c
     */
    public void computeEquation()
    {
        // Curve equation of type : y = ax^2 + bx + c
        // OR (x*x)a + (x)b + 1c = y
        // ex : 50 = 4a + 2b + c where y = 50 and x = 2 and z = 1
        double[][] matrice = {{Math.pow(A.getKey(),2),A.getKey(),1},
                {Math.pow(B.getKey(),2),B.getKey(),1},
                {Math.pow(C.getKey(),2),C.getKey(),1}};

        double deter = computeSarrus(matrice);

        double [][] matriceA = {{A.getValue(),A.getKey(),1},
                {B.getValue(),B.getKey(),1},
                {C.getValue(),C.getKey(),1}};

        double [][] matriceB = {{Math.pow(A.getKey(),2),A.getValue(),1},
                {Math.pow(B.getKey(),2),B.getValue(),1},
                {Math.pow(C.getKey(),2),C.getValue(),1}};

        double [][] matriceC = {{Math.pow(A.getKey(),2),A.getKey(),A.getValue()},
                {Math.pow(B.getKey(),2),B.getKey(),B.getValue()},
                {Math.pow(C.getKey(),2),C.getKey(),C.getValue()}};

        abc[0] = computeSarrus(matriceA) / deter;
        abc[1] = computeSarrus(matriceB) / deter;
        abc[2] = computeSarrus(matriceC) / deter;
    }

    /**
     * @see http://www.bibmath.net/dico/index.php?action=affiche&quoi=./s/sarrus.html
     * @return
     */
    protected static double computeSarrus(double[][] matrice)
    {
        return matrice[0][0]*matrice[1][1]*matrice[2][2]
                + matrice[0][1]*matrice[1][2]*matrice[2][0]
                + matrice[0][2]*matrice[1][0]*matrice[2][1]
                - matrice[2][0]*matrice[1][1]*matrice[0][2]
                - matrice[2][1]*matrice[1][2]*matrice[0][0]
                - matrice[2][2]*matrice[1][0]*matrice[0][1];
    }
}
