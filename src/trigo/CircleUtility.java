package trigo;

import java.util.AbstractMap;

public class CircleUtility {

    private double rayon;
    private AbstractMap.SimpleImmutableEntry<Double, Double> center;

    public CircleUtility(double rayon, AbstractMap.SimpleImmutableEntry<Double, Double> center) {
        this.rayon = rayon;
        this.center = center;
    }

    public boolean isWithinCircle(AbstractMap.SimpleImmutableEntry<Double, Double> point)
    {
        return distanceBetweenCenter(point) <= rayon;
    }

    private double distanceBetweenCenter(AbstractMap.SimpleImmutableEntry<Double, Double> point)
    {
        return Math.sqrt(Math.pow(center.getKey()-point.getKey(),2) + Math.pow(center.getValue() - point.getValue(),2));
    }
}
