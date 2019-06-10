package trigo;

/**
 * A few utils to deal with speed, angle and position
 * ex : plane and directions...
 */
public class VectorAndSpeed {

    private static int refDistance;
    private static int refAngle;
    private static int refSpeed;

    public static void main(String[] args)
    {
        //refDistance = 8000;
        //refAngle = 0;

        System.out.println("Computed speed : " + getSpeed(170d, 1000));

        System.out.println("On path ? : " + isOnPath(5716,3186,6557,3205,10305,3339, 800));
//path between (5716,3186) and (6557,3205) plus the target : (10305,3339)
    }

    public static Integer getSpeed(Double angle, Integer distance)
    {
        int distPos;
        int speed = 100;

        double halfDistance = distance / 2.0;
        // converting values to radians
        double b = Math.toRadians(angle);

        if (Math.abs(angle) >= 90) {
            distPos = (int) (getSizeOfTriangle(angle, distance) / Math.cos(Math.toRadians(angle/2.0)));
            speed = (int)(getSizeOfTriangle(angle, distance) * 100 / distPos );
        }
        else {
            distPos = (int) (halfDistance / Math.cos(b));
            speed = (int)(halfDistance * 100 / distPos );
        }

        return Math.abs(speed);
   }

    private static Integer getSizeOfTriangle(Double angle, int distance)
    {
        // mid angle, we draw a bissectrice to obtain the size of second triangle and ...
        double a =  Math.toRadians(angle / 2.0);

        return (int)(distance / Math.tan(a));
    }

    /**
     * tell if Opponent is on Path between position and targer
     *
     * @param x
     * @param y
     * @param oppX
     * @param oppY
     * @param targetX
     * @param targetY
     * @return
     */
    protected static boolean isOnPath(int x, int y, int oppX, int oppY, int targetX, int targetY, int width)
    {
        double coefDir = 0;
        double originOrd = 0;

        if ((targetX - x) != 0)
        {
            coefDir = (double)(targetY - y) / (double)(targetX - x);
            originOrd = y - coefDir * x;

            if (isOnLine(coefDir, originOrd, width, oppX, oppY))
                return true;
        }
        else {
            // case droite // à ordonnéés
            return true;
        }

        return false;
    }

    /**
     * Check if point is on line
     */
    private static boolean isOnLine(double coef, double p, int width, int x, int y)
    {
       return (y >= (coef * x + p - width) && y<= (coef * x + p + width));
    }

    private static int getDistance(int x, int y, int u, int v)
    {
        return (int)Math.sqrt(Math.pow(u-x,2) + Math.pow(v - y,2));
    }
}
