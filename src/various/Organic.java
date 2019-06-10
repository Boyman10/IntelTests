package various;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class Organic {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < N; i++)
            inputs.add(in.nextLine());

        System.out.println((new Formula()).driveAction(Formula.prepare(inputs)));
    }
}


class Formula {

    /**
     * Preparing the formula given inputs
     * @param inputs list of strings
     * @return an arraylist representing the compound
     */
    static Stream<String> prepare(List<String> inputs) {

        List<String> comp = new ArrayList<>();
        boolean next = false;
        String templine = "";
        StringBuilder concat = new StringBuilder();

        for(String line: inputs) {
            concat.setLength(0);
            System.out.println("TMP :" + line);

            if (line.indexOf(' ') >= 0) // case columns
            {
                if (next) { // alternating

                    next = false;

                    for (int jj = 0; jj < line.length(); jj += 3) {

                        int index = (line.substring(jj, jj + 3)).indexOf(' ');
                        int index2 = (templine.substring(jj, jj + 3)).indexOf(' ');

                        if (index < 0) {
                            concat.append(templine.substring(jj, jj + 3));
                            if (index2 < 0)
                                concat.append(line.substring(jj, jj + 3));
                        }


                    }

                } else { // first line :
                    next = true;
                    templine = line;
                    continue;
                }
                System.out.println(concat);
                comp.add(concat.toString());

            } else {
                System.out.println(concat);
                comp.add(line);
            }
        }

        return comp.stream();
    }

    boolean isLineNotValid(String line) {

        //System.out.println("==== Line : " + line);

        Pattern pat = Pattern.compile("CH");
        String[] items = pat.split(line);

        Pattern newPat = Pattern.compile("([0-4]{1})\\(([0-4]{1})\\)");
        Matcher mat;

        int link = 0,i,y, count=0;

        for (String item : items) {
            System.out.println("analysing.. " + item);

            if (!item.equals("")) {
                count++;
                mat = newPat.matcher(item);

                if (mat.matches()) {


                    i = Integer.parseInt(mat.group(1));
                    y = Integer.parseInt(mat.group(2));

                    if (i + y + link > 4) {
                        System.out.println("N : " + (i + y + link));
                        System.out.println("Count : " + count);
                        return true;
                    } else {
                        if (count == 1)
                            link = y -1;
                        else link = y;
                    }

                }

            }

        }

        System.out.println("compound left " + link);
        return false;
    }

    String driveAction(Stream<String> lines) {

        ArrayList<String> array = new ArrayList<>();

        lines.filter(this::isLineNotValid).forEach(array::add);
        System.out.println((array.isEmpty()) ? "VALID" : "INVALID");
        return (array.isEmpty()) ? "VALID" : "INVALID";

    }
}