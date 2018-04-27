import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Trigonometry {

    public static void main(String args[]) {



        String LON = "40.0";
        String LAT = "20.20";

        // User position :
        Position defaultPos = new Position("0;default;here;nophone;3.879483;43.608177");

        // Number of items :
        int N = 2;

        String[] defibList = new String[N];
        ArrayList<Position> posItems = new ArrayList<>();

        // ex : id;name;address;phone;long;lat
        for (int i = 0; i < N; i++) {
            posItems.add(new Position(defibList[i]));
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println("answer");


        /**
         * Exemple of use DISTANCE calculation
         */
        Position position1 = new Position("1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217");

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

        double x = (two.getLongPos() - one.getLongPos()) * (Math.cos((one.getLatPos() + two.getLatPos())) / 2.0);
        double y = two.getLatPos() - one.getLongPos();

        distance = (double)Math.sqrt((double)(Math.pow(x,2)) + (double)Math.pow(y,2)) * 6371;

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

        try {

            allData = allData.replace(',','.');
            String[] data = allData.split(";");

            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.address = data[2];
            this.phone = data[3];
            this.longPos = Math.PI * Float.parseFloat(data[4]) / 180;
            this.latPos = Math.PI * Float.parseFloat(data[5]) / 180.0;

        } catch(Exception e) {
            System.err.println(e + allData);
        }
    }


}

/*
import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();


        // User position :
        Position defaultPos = new Position("0;default;here;nophone;" + LON + ";" + LAT);


        // Number of items :
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }


        String[] defibList = new String[N];
        ArrayList<Position> posItems = new ArrayList<>();

        // ex : id;name;address;phone;long;lat
        for (int i = 0; i < N; i++) {
            posItems.add(new Position(in.nextLine()));
        }

        Position reference = posItems.get(0);

        // Get the closest here :
        for (int i = 1; i < N; i++) {

            reference = getClosest(defaultPos,reference,posItems.get(i));
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(reference.getName());
    }


    public static Float getDistance(Position one, Position two) {

        Float distance;

        Double x = (two.getLongPos() - one.getLongPos()) * (Math.cos((one.getLatPos() + two.getLatPos())) / 2.0);
        Float y = two.getLatPos() - one.getLongPos();

        distance = (float)Math.sqrt((float)(Math.pow(x,2)) + (float)Math.pow(y,2)) * 6371;

        return distance;
    }


    public static Position getClosest(Position fromPos, Position a, Position b) {

        return (getDistance(fromPos,a) < getDistance(fromPos,b))?a:b;
    }
}



class Position {

    private int id;
    private String name;
    private String address;
    private String phone;
    private float longPos;
    private float latPos;

    public float getLongPos() {
        return longPos;
    }

    public void setLongPos(float longPos) {
        this.longPos = longPos;
    }

    public float getLatPos() {
        return latPos;
    }

    public String getName() {
        return name;
    }

    public void setLatPos(float latPos) {
        this.latPos = latPos;
    }

    public Position(String allData) {

        try {

            allData = allData.replace(',','.');
            String[] data = allData.split(";");

            this.id = Integer.parseInt(data[0]);
            this.name = data[1];
            this.address = data[2];
            this.phone = data[3];
            this.longPos = Float.parseFloat(data[4]);
            this.latPos = Float.parseFloat(data[5]);

        } catch(Exception e) {
            System.err.println(e + allData);
        }
    }


}
 */