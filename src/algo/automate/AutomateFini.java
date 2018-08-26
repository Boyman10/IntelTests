package algo.automate;

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

    // Breaking bad :
    private static final char beer = 'B'; // Breaking definitively X

    private static final char teleport = 'T'; // jump from one T to the other one

    //******** STATES ***********//
    private boolean breaker = false;
    private boolean inverted = false;
    private char currentDirection = 'S'; // initial default direction

    //**********MAP**************//
    private char[][] map; // the map where Bender goes

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


    public void benderAutomate() {


    }
}


