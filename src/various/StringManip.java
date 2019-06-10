package various;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManip {

    public static void main(String[] args) {

        final String letter  = "e";
        Stream.of("Hello","BOUU","Jim","Koala").filter(havingLetter(letter)).map(StringManip::removeE).forEach(System.out::println);
    }

    private static String removeE(String str) {

        return str.replaceAll("e","");
    }

    private static Predicate<String> havingLetter(String letter) {
       return p -> isHavingLetter(p,letter);
    }

    private static boolean isHavingLetter(String str, String letter) {
        return str.contains(letter);
    }

    private static String removeL(String str, String letter) {

        return str.replaceAll(letter,"");
    }

    public static String generateAlphabet() {

        StringBuilder alpha = new StringBuilder(); // code 32 for space but should remove it !

        for(int i=0;i<26;i++)
            alpha.append((char)(97+i));

        return alpha.toString();
    }

    /**
     * @see https://www.baeldung.com/java-remove-repeated-char
     * @see https://www.concretepage.com/java/jdk-8/java-8-stream-sorted-example#sorted
     * @param str
     * @return
     */
    public static String removeDuplicatesAndSort(String str) {
        StringBuilder sb = new StringBuilder();
        str.chars().distinct().sorted().forEach(c -> sb.append((char) c));

        return sb.toString();
    }


    public static String charListToString() {
        // Convert the character list into String
        // using Collectors.joining() method
        String chString = Arrays.asList("Geeks", "for", "Geeks").stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return chString;
    }
}
