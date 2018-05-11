import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementing Double dimension array
 */
public class DoubleArr {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis

        /**
         * Check if there is a need to drink another line
         */
        if (in.hasNextLine()) {
            in.nextLine();
        }

        // Reading nodes :
        char[][] nodes = new char[height][width];

        // fill in our array with lines as chars
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            nodes[i] = line.toCharArray();
            System.err.println( line);
        }

        // prepare the string to print out .
        List<String> result = new ArrayList<>();

        StringBuilder tmp = new StringBuilder();

        // Now time to browse.
        for (int i = 0; i < height; i++) {

            for (int j = 0;j < width; j++) {
//System.err.println( nodes[i][j]);
                // we ve got a node :
                if ('0' == nodes[i][j]) {
                    // node coordinates .
                    tmp.append(j);
                    tmp.append(' ');
                    tmp.append(i);
                    tmp.append(' ');

                    try {
                        // get neigbourh
                        if((j+1) < width && nodes[i][j+1] == '0') {
                            tmp.append((j+1));
                            tmp.append(' ');
                            tmp.append(i);
                            tmp.append(' ');
                        } else {

                            tmp.append("-1 -1 ");
                        }
                        // get neigbourh
                        if((i+1) < height && nodes[i+1][j] == '0') {
                            tmp.append((j));
                            tmp.append(' ');
                            tmp.append((i+1));
                            tmp.append(' ');

                        } else {

                            tmp.append("-1 -1 ");
                        }


                    } catch (Exception e) { // @TODO
                        // outofbounds
                        // tmp.append("-1 -1");
                        System.err.println( "out of bounds");
                    }


                    result.add(new String(tmp.toString()));
                    // empty it
                    tmp.setLength(0);
                }else {
                    // System.err.println("what do we do .//.");
                }
            }

        }

        for(String res : result)
            System.out.println(res);
    }
}
