package algo.pruning;

public class MinMaxTicTacToe extends MiniMax {

    private boolean player = false, opponent = false;
    private static final int SCORE = -10000;

    private int[][] gameBoard;

    public MinMaxTicTacToe(int[][] gameBoard) {

        this.gameBoard = gameBoard;

    }

    @Override
    public int eval() {

        if (endOfGame) {
            if (player)
                return SCORE - this.depth;
            else if (opponent)
                return  this.depth - SCORE;
            else
                return 0; // Null
        }

        return getNb2Series(0) - getNb2Series(1);
    }

    @Override
    public void play() {
        int tmp, maxI = 0, maxJ = 0, max = SCORE;
        int i,j;

        for (i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                if (gameBoard[i][j] == 0) {
                    gameBoard[i][j] = 1;
                    this.depth--;
                    tmp = this.min();

                    if (tmp > max) {
                        max = tmp;
                        maxI = i;
                        maxJ = j;
                    }
                    gameBoard[i][j] = 0;
                }
            }

        }


        gameBoard[maxI][maxJ] = 1;
    }

    /**
     * Retrieve the number of series of 2 items for a player
     * @param player index
     * @return the number
     */
    private int getNb2Series(int player) {

        return 0;
    }
}
