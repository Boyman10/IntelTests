package algo.automate;

import java.util.Hashtable;

/**
 * Algorithm implementing a finite automate
 * @see http://deptinfo.cnam.fr/~barthe/NFP108/poly-automates.pdf
 */
public class AutomateFini {

    // case impossible to get to the target :
    private static String LOOP = "LOOP";

    private static final char INIT = '@'; // start
    private static final char END = '$'; // end of route

    // obstacles
    private static final char[] OBSTACLES = {'#', 'X'};

    // directions in order :
    private static final char[] DIRECTIONS = {'S', 'E', 'N', 'W'};
    private static final char[] INV_DIRECTIONS = {'W','N','E','S'};
    private static final char INVERTER = 'I';

    private static final Hashtable<Character,Byte[]> directionMove = new Hashtable<>();

    // Breaking bad :
    private static final char beer = 'B'; // Breaking definitively X

    private static final char teleport = 'T'; // jump from one T to the other one

    //******** STATES ***********//
    private boolean breaker = false;
    private boolean inverted = false;
    private char currentDirection = 'S'; // initial default direction

    //**********MAP**************//
    private char[][] map; // the map where Bender goes
    private byte[] position; // the current position of the head (bender)

    private static final byte MIN_COL = 4;
    private static final byte MAX_COL = 100;
    private static final byte MIN_ROW = 4;
    private static final byte MAX_ROW = 100;

    private byte indexOfMapRow = 0;
    /**
     * Constructor class initializing the map
     * @param R nb of rows
     * @param C nb of columns
     */
    public AutomateFini(byte R, byte C) {

        if (R >= MIN_ROW && R <= MAX_ROW && C >= MIN_COL && C <= MAX_COL) {
            map = new char[C][R];

            Byte[] tmpS = {0,1}, tmpN = {0,-1}, tmpE = {1,0}, tmpW = {-1,0};
            directionMove.put('S',tmpS);
            directionMove.put('N',tmpN);
            directionMove.put('E',tmpE);
            directionMove.put('W',tmpW);

        } else
            throw new RuntimeException("Error with size of map !");

    }

    /**
     * Adding a new line to the map
     * @param row the row to add to the map
     */
    public void addLine(String row) {

        map[indexOfMapRow++] = row.toCharArray();
    }


    /**
     * Output the next automate move
     * @return a string representing the move
     */
    public String benderAutomateMove() {

        if (position == null)
            position = locateElement(INIT);
        else {

            // do we have an element here ?
            char here = nextElement(position);

            if (here == OBSTACLES[1] && breaker)
                map[position[0]][position[1]] = ' '; // remove the obstacle


        }


        return charToMove(currentDirection);
    }

    /**
     * Given a char, output the string
     * @param move represents the move
     * @return a String
     */
    private String charToMove(char move) {
        switch(move) {
            case 'S' : return "SOUTH";
            case 'N' : return "NORTH";
            case 'E' : return "EAST";
            case 'W' : return "WEST";
            default : return "LOOP";
        }
    }

    /**
     * Localize an element in the map
     * @param elt the element to find
     * @return its position
     */
    private byte[] locateElement(char elt) {

        byte[] pos = new byte[2];

        for(byte i = 0;i < map.length;i++) {
            for(byte j=0;j < map[i].length;j++)
                if(map[i][j] == elt) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
        }

        return null;
    }

    /**
     * Return next element at map position
     * @param pos the position
     * @return the element
     */
    private char nextElement(byte[] pos) {
        return map[pos[0]][pos[1]];
    }

}


