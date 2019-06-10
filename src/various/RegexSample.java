package various;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSample {

    private static boolean isGood(String str, String ttype) {
        String pattern = "";
        char ch = '0' , invCh = '0';
        if (ttype.equals("par")) {
            pattern = "\\([^)(]*\\)(.*?)";
            ch = '(';
            invCh = ')';
        } else if (ttype.equals("bra")) {
            pattern = "\\{[^}{]*\\}(.*?)";
            ch = '{';
            invCh = '}';
        } else if (ttype.equals("acc")) {
            pattern = "\\[[^\\[\\]]*\\](.*?)";
            ch = '[';
            invCh = ']';
        }

        System.out.println("Pattern " + pattern);
        String tmp = str;

        while(true) {

            str = str.replaceAll(pattern, "");

            System.out.println("New one : " + str);

            if(str.equals(""))
                return true;
            else if (str.equals(tmp) && str.indexOf(ch) < 0 && str.indexOf(invCh) < 0)
                return true;
            else if(str.equals(tmp) )
                return false;


            tmp = str;

        }

    }

    private static boolean factorIsGood(String str) {

        return (isGood(str,"par") || isGood(str,"bra") || isGood(str,"acc"));

    }


    public static boolean validStack(String str) {

        Stack<Character> STACK = new Stack<Character>();

        int i = 0;
        while(i < str.length()) {

            if(str.charAt(i) == '(' || str.charAt(i) == '{' ||str.charAt(i) == '[') {
                STACK.push(str.charAt(i));
                System.err.println("Adding char to stack " + str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == '}' ||str.charAt(i) == ']') {
                if (STACK.isEmpty())
                    return false;
                else if(!STACK.isEmpty() && STACK.peek() == invertOf(str.charAt(i))) {
                    STACK.pop();
                    System.err.println("Poping out " + str.charAt(i));
                }
            }

            i++;
        }

        return STACK.isEmpty();
    }

    private static char invertOf(char elt) {
        switch(elt) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
        }
        return ' ';
    }

    public static void main(String[] args) {
      //  Scanner in = new Scanner(System.in);
       // String expression = in.next();
       /* String expression = "((Hime)boy))";


//".*[\\{\\(\\[].*(.*)[\\]\\}\\)].*"
        //System.out.println(expression.matches("\\S*")); // any non space chars
        System.out.println(expression.matches("(\\(\\S*\\))*\\z")); // any non space chars

        // String to be scanned to find the pattern.
        String pattern = "\\([^)(]*\\)(.*?)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern,
                Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

        // Now create matcher object.
        Matcher m = r.matcher(expression);
        if (m.find( )) {
            for(int i = 0; i< m.groupCount(); i++)
                System.out.println("Found value: " + m.group(i) );

        }else {
            System.out.println("NO MATCH");
        }

        System.out.println(isGood(expression, "par"));*/


      String expression = "]";
        System.out.println(validStack(expression));

    }


}