import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * @link https://www.movable-type.co.uk/scripts/latlong.html
 **/
class Trigonometry {

    public static void main(String args[]) {


        // west East
        String LON = "40.0";
        // South North
        String LAT = "20.20";

        // User position :
        // long then lat
        Position defaultPos = new Position("0;default;here;nophone;3.879483;43.608177");

        // Number of items :
        int N = 2;

        String[] defibList = new String[N];
        ArrayList<Position> posItems = new ArrayList<>();

        // ex : id;name;address;phone;long;lat
        for (int i = 0; i < defibList.length; i++) {
            if (defibList[i] != null)
             posItems.add(new Position(defibList[i]));
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");


        /**
         * Exemple of use DISTANCE calculation
         */
        Position position1 = new Position(
                "1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217");

        System.out.println("Distance " + getDistance(defaultPos,position1));

    }


    /**
     * Get distance between 2 points
     * @param one
     * @param two
     * @return
     */
    public static double getDistance(Position one, Position two) {

        double distance;

        double lat1 = one.getLatPos();
        double lat2 = two.getLatPos();
        double long1 = one.getLongPos();
        double long2 = two.getLongPos();

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(long2 - long1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        distance = c * 6371;

        System.out.println("Distance Between " + " long 1 " + one.getLongPos() + " lat 1 " + one.getLatPos()
                            + " long 2 " + two.getLongPos() + " lat 2 " + two.getLatPos());

        return distance;
    }



    /**
     * Get closest position from default point
     * @param fromPos
     * @param a
     * @param b
     * @return position
     */
    public static Position getClosest(Position fromPos, Position a, Position b) {

        return (getDistance(fromPos,a) < getDistance(fromPos,b))?a:b;
    }

}

/**
 * Entity Class for position of item
 */
class Position {

    private int id;
    private String name;
    private String address;
    private String phone;
    private double longPos;
    private double latPos;

    public double getLongPos() {
        return longPos;
    }

    public void setLongPos(double longPos) {
        this.longPos = longPos;
    }

    public double getLatPos() {
        return latPos;
    }

    public void setLatPos(double latPos) {
        this.latPos = latPos;
    }

    public Position(String allData) {
        String[] data;
        allData = allData.replace(',','.');
        data = allData.split(";");

        try {
            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.address = data[2];
            this.phone = data[3];
            this.longPos = Float.parseFloat(data[4]);
            this.latPos = Float.parseFloat(data[5]);

        } catch(Exception e) {
            System.err.println(e.getMessage() + "Size : " + data.length + " long : " + this.longPos + " lat : " + this.latPos);
        }
    }


}
