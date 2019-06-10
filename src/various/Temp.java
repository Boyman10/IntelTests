package various;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Temp {

    public static  void main (String[] arge) {

        String str = "Abcde fghij klgghmssszzno pqrs tuvw xyz".toLowerCase().replaceAll(" ","");

        System.out.println(str);


    }

    public static String generateAlphabet() {
        String alpha = ""; // code 32 for space but should remove it !

        for(int i=0;i<26;i++)
            alpha+= (char)(97+i);

        return alpha;
    }

    public static boolean isPalindrome(String word) {

        word = word.toLowerCase();
        char[] arr = word.toCharArray();
        for(int i=0;i<word.length()/2+1;i++)
            if(arr[i] != arr[arr.length-i])
                return false;
            return true;
    }

    public void strTry() {

        String str = "022154";
        int cc = 0;
        for(char ch : str.toCharArray()) {
            System.out.println(ch + " at " + str.indexOf(ch));

            System.out.printf("Computing %d + 2 = %d \n" ,cc++ , Character.getNumericValue(ch) + 2);
        }

        System.out.println( str.replaceAll("","-"));

        System.out.println("Enum type " + (Kitchen.BLUE).toString().equals("B"));
    }

    public void pyramid() {
        int nb = 3;
        int tp = (nb % 2 == 1)?0:1;

        String template = "*****************************************";
        String spaces = "                                             ";

        for(int u =0;u<nb;u++) {

            //System.out.print(StringUtils.repeat("*", (nb-u)/2 -tp);
            System.out.print(spaces.substring(0,((nb-u) +1)/2 -tp) );

            //String filled = $("=").repeat(10).toString(); // produces "=========="

            System.out.print(template.substring(0,u+1));

            System.out.print(spaces.substring(0,((nb-u) +1)/2 -tp));

            System.out.println();
        }

    }

    public void factorial() {
        String str;
        long n = 23;
        double count = n;
        for(long i = n-1;i> 0;i--) {
            count*=i;
        }
        //String str = String.valueOf(count);
        str = String.format("%f",count);
        System.out.println(str);
        if(str.indexOf(',') > -1)
            str = str.substring(0,str.indexOf(','));

        System.out.println(str);

        int i = str.length()-1;
        int cc=0;

        while(i >=0 && str.charAt(i--) == '0')
            cc++;

        System.out.println(cc);
    }

    public void makeASCII() {
        int charCount = 11;

        List<Integer> str = Arrays.asList(72,101,108,108,111,32,87,111,114,108,100);
        for (int i = 0; i < charCount; i++) {
            int num = str.get(i);
            System.out.print((char)num );
        }
    }

    public void occurences (){
        final int count = 5;
        int found =0;
        List<Integer> list = Arrays.asList(22,10,22,11,22);
        int[] cc = new int[count];

        System.out.println(Collections.frequency(list,22));

        for (int i = 0; i < count; i++)
            for (int j = 0; j < list.size(); j++)
                if (list.get(j) == list.get(i))
                    cc[i]++;

        for(int ii=0;ii<count;ii++)
            if((int)(Math.floor(count/2) +1) == cc[ii]) {
                System.out.println((int)(Math.floor(count/2) +1));
                found = list.get(ii);
                break;
            } else System.out.println((int)(Math.floor(count/2) +1) + " and i: " + ii);

        if(found > 0) System.out.println(found);
        else
            System.out.println("N");
    }


    public void lettersStr() {
        final String str = "AACT";

        List<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()) {
            list.add(c);
        }

        list.forEach(s->  System.out.println(Collections.frequency(list,s)));

    }

    public void stars() {

        String w = "welcome";
        String decor = "*";
        int outer = 1;
        StringBuilder ref = new StringBuilder();

        StringBuilder str = new StringBuilder(),
                str1 = new StringBuilder(),
                str3 = new StringBuilder(),
                str4 = new StringBuilder();

        for(int i=0;i<(2*outer + w.length() + 2);i++)
            ref.append(decor);

        ref.append("\n");

        for(int i=0;i<(outer);i++){
            str.append(ref );
            str1.append(ref);
            if(i<outer) {
                str3.append(decor);
                str4.append(decor);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(str);
        result.append(str3);
        result.append(" ");
        result.append(w);
        result.append(" ");
        result.append(str4);
        result.append("\n");
        result.append(str1);


        System.out.println(result);
    }


    public void vowels() {

        String statement = "ebc a e k lee";
        String vowels = "aeiou";

        statement=statement.replaceAll(" ","");
        String result = "";String tmp;
        for(int i =0;i<statement.length();i++) {
            tmp = "" + statement.charAt(i);
            if((i+1) < statement.length()) {
                if (vowels.indexOf(statement.charAt(i)) > -1) { //case vowel

                    if (vowels.indexOf(statement.charAt(i + 1)) == -1) {
                        tmp += " ";
                    }
                }
                else if (vowels.indexOf(statement.charAt(i + 1)) > -1) // case vowel for next one
                    tmp += " ";
            }
            result += tmp;
        }


        System.out.println(result);
    }

    /**
     * Occurrences of a char in a string :
     * @param c
     * @param s
     * @return
     */
    public static int countOcc(char c, String s) {

        return (int)s.chars().filter(ch -> ch == c).count();

    }
}
