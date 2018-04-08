import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {

    public static void main(String[] args) {

        String MESSAGE = "%";

        Integer ascii;
        StringBuilder strBinary = new StringBuilder();

        for(int i = 0;i<MESSAGE.length();i++) {
            ascii = (int)MESSAGE.charAt(i);
            strBinary.append(Integer.toBinaryString(ascii));
            System.out.println(MESSAGE.charAt(i) + " en ascii : " + ascii + " in binary : " + strBinary);
        }


        char[] binary = (strBinary.toString()).toCharArray();


       // System.out.println(entry + " en ascii : " + ascii + " in binary : " + strBinary);

        Character ch = '1';
        System.out.println("Char 1 to int : " + ch.charValue());

        Character cur = binary[0];

        StringBuilder myStr = new StringBuilder();
        boolean bool = FALSE;

        // Convert our binary to unary :
        for(Character c: binary) {

            if (!bool) {
                bool = TRUE;

                if (c.equals('0'))
                    myStr.append("00 0");
                else
                    myStr.append("0 0");

                cur = c;
            }
            // Same as before
            else if (c.equals(cur)) {
                myStr.append("0");
            } else {
                // different parameter - starting over
                cur = c;
                myStr.append(" ");
                //bool = FALSE;

                if (c.equals('0')) {
                    myStr.append("00 0");
                }
                else
                    myStr.append("0 0");
            }
        }


        System.out.println("My String : " + myStr);

    }
}
