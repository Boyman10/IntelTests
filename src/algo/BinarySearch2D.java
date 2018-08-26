package algo;

/**
 * Binary search algorithm - non recursive - just 1 move at a time
 * Integer version for 2D implementation
 * @see https://fr.wikipedia.org/wiki/Recherche_dichotomique
 */
public class BinarySearch2D {

    private int maxRows ,maxCols , minRows , minCols ;
    /**
     * Constructor initializing the array
     * @param array
     */
    public BinarySearch2D(int[][] array) {

        maxRows = array[0].length - 1;
        maxCols = array.length - 1;
        minRows = 0;
        minCols = 0;
    }

    /**
     * Altering array given current position and the clue As string
     * @param pos [2,5]
     * @param clue UR  (Up Right)
     * @return [5,4]
     */
    public int[] nextMoveGivenPositionAndClue(int[] pos, String clue) {

        int[] next = new int[2];

        if(clue.contains("U")) {
            // our new array is looking at the top !
            maxRows = pos[1] - 1;
        } else if (clue.contains("D")) {
            minRows = pos[1] + 1;
        }

        if(clue.contains("L")) {
            // our new array is looking at the top !
            maxCols = pos[0] - 1;
        } else if (clue.contains("R")) {
            minCols = pos[0] + 1;
        }

        // Now obtain the best move :
        next[0] = ((maxCols - minCols) / 2 + minCols ) ;
        next[1] = ((maxRows - minRows ) / 2 +  minRows) ;

        System.out.println();
        return next;
    }
}
