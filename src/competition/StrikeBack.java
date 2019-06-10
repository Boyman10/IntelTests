package competition;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static final String BOOST = "BOOST";
    private static final double perimeter = 400d;
    private static final int SPEED_CHANGE = 20;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        boolean boost = false;
        boolean start = true;
        String power;

        int lastCheckpointX = 0;
        int lastCheckpointY = 0;
        int currentCheckpointX = 0;
        int currentCheckpointY = 0;

        int refNextCheckpointX = 0;
        int refNextCheckpointY = 0;

        double[] curveAbc = new double[3];

        // game loop
        while (true) {

            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // By default
            int thrust = 100;

            if (start)
            {
                currentCheckpointX = x;
                currentCheckpointY = y;
                refNextCheckpointX = nextCheckpointX;
                refNextCheckpointY = nextCheckpointY;

                start = false;
            }

            if (!boost && nextCheckpointDist > 3000) {
                power = BOOST;
                boost = true;
            }
            else {
                // case the boost is over :

                // case still same next checkpoint :
                if (refNextCheckpointX == nextCheckpointX && refNextCheckpointY == nextCheckpointY)
                {
                    // change nothing
                }
                else {
                    // Switch checkpoint ref and compute the curve formula :
                    lastCheckpointX = currentCheckpointX;
                    lastCheckpointY = currentCheckpointY;
                    currentCheckpointX = refNextCheckpointX;
                    currentCheckpointY = refNextCheckpointY;
                    refNextCheckpointX = nextCheckpointX;
                    refNextCheckpointY = nextCheckpointY;

                    Equation3 curve = new Equation3(new HashMap.SimpleImmutableEntry<>((double)lastCheckpointX, (double)lastCheckpointY),
                            new HashMap.SimpleImmutableEntry<>((double)currentCheckpointX, (double)currentCheckpointY),
                            new HashMap.SimpleImmutableEntry<>((double)refNextCheckpointX, (double)refNextCheckpointY)
                            );

                    curve.computeEquation();
                    curveAbc = curve.getAbc(); // current curve details
                }

                // Now are we on the curve if any ?
                if (lastCheckpointX > 0 && lastCheckpointY > 0) // already have a line !
                {
                    LineUtility lineUtility = new LineUtility(curveAbc);

                    double distanceToCurve = lineUtility.getDistanceToLine(new HashMap.SimpleEntry<>((double)x, (double)y));

                    System.err.println("Distance to curve : " + distanceToCurve);

                    if (Math.abs(distanceToCurve) > perimeter)
                    {
                        // very far from curve !
                        if (lineUtility.isAboveLine(new HashMap.SimpleEntry<>((double)x, (double)y)))
                        {
                            // reduce the speed by a number :
                            thrust = Math.max(thrust - SPEED_CHANGE, 10);
                            System.err.println("Above curve : " + thrust);
                        }
                        else {
                            thrust = Math.min(thrust + SPEED_CHANGE, 100);
                            System.err.println("Below curve : " + thrust);
                        }


                    }

                }


                power = String.valueOf(thrust);
            }




            System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + power);


       }
    }
}

class Equation3 {

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

class LineUtility {

    // a,b,c for formula : y = ax2 + bx + c
    private double[] line = new double[3];

    public LineUtility(double[] line) {
        this.line = line;
    }

    /**
     * Is y > f(x) ?
     * @param position
     * @return
     */
    public boolean isAboveLine(AbstractMap.SimpleEntry<Double,Double> position)
    {
        double f = line[0]* Math.pow(position.getKey(),2) + line[1]* position.getKey() + line[2];
        return f < position.getValue();
    }

    public boolean isOnLine(AbstractMap.SimpleEntry<Double,Double> position)
    {
        return Math.round(line[0]* Math.pow(position.getKey(),2) + line[1]* position.getKey() + line[2]) == Math.round(position.getValue());
    }

    public double getDistanceToLine(AbstractMap.SimpleEntry<Double,Double> position)
    {
        if (isOnLine(position))
            return 0;

        // y - ax2 - bx - c = 0
        double denom = position.getValue() - line[0]* Math.pow(position.getKey(),2) - line[1]* position.getKey() - line[2];
        double quot = Math.sqrt(Math.pow(line[0],2) + 1);

        return denom / quot;
    }
}
