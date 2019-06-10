package maths;

import java.util.AbstractMap;

public class LineUtility {

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
