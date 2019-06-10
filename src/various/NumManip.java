package various;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumManip {

    public static void main(String[] args) {

        String str = "111 108 108 101 72 32 101 114 101 104 116 32 41 58";

        IntStream.iterate(65,i -> i+2).limit(4).mapToObj(Character::toChars).forEach(System.out::println);

    }

    /**
     * Distance in meters given
     * @param s in cm/s
     * @param t in minutes
     * @return
     */
    public static int distance(int s, int t) {
        int d = 0;

        double sm = s ;
        double ts = t *60.0/100.0;

        return (int)( sm*ts);
    }
}
