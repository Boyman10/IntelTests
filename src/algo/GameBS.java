package algo;

/**
 * A game implementing the BinarySearch Algorithm
 */
public class GameBS {

    public static final int MAX_WIDTH = 10000;
    public static final int MIN_WIDTH = 1;
    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 10000;
    public static final int MAX_JUMPS = 100;
    public static final int MIN_JUMPS = 2;

    private int jumps;
    private int width, height;
    private int position;

    public GameBS(int W, int H, int N, int X0, int Y0) {

        if (W >= MIN_WIDTH && W <= MAX_WIDTH && H >= MIN_HEIGHT && H <= MAX_HEIGHT && N >= MIN_JUMPS && N <= MAX_JUMPS) {

            this.jumps = N;
            this.width = W;
            this.height = H;

            // Transform 2D position into 1D :


        } else
            throw new RuntimeException("Out of bounds entries!!");

    }

    /**
     * Transform a 2D position into a 1D one
     * @param x 2
     * @param y 5
     * @return 52
     */
    public int getFrom2D(int x, int y) {

        return (x + y * this.width);
    }

    /**
     * Transform a 1D position into a 2D one
     * @param position 52
     * @return [2,5]
     */
    public int[] setTo2D(int position) {

        int pos[] = new int[2];
        pos[0] = position % this.width; // ex : 2
        pos[1] = position / this.height;

        return pos;
    }

}
