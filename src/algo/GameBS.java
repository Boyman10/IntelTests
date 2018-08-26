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
     * @param x
     * @param y
     * @return
     */
    public int getFrom2D(int x, int y) {

        return 0;
    }
}
