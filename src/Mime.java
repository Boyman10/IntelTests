import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Map.entry;

public class Mime {

    public static void main(String[] args) {

        int N = 3; // Number of elements which make up the association table.
        int Q = 3; // Number Q of file names to be analyzed.

      //  Pattern p = Pattern.compile(" (\\S+or\\S+) ");   // the pattern to search for
       // Matcher m ;

        String[] EXT = new String[N];
        String[] MT = new String[N];

        HashMap<String,String> hashMt = new HashMap<>();
        hashMt.put("html","text/html");
        hashMt.put("png","image/png");
        hashMt.put("css","html/css");

        /* Display content using Iterator*/
        Set set = hashMt.entrySet();
        Iterator iterator = set.iterator();
        int i = 0;
        while(iterator.hasNext()) {

            Map.Entry mentry = (Map.Entry)iterator.next();

            EXT[i] = (String)mentry.getKey(); // file extension
            MT[i] = (String)mentry.getValue(); // MIME type.
            i++;
        }

        System.out.println("-----");
        String[] FNAME = new String[N];

        FNAME[0] = "goog.txt";
        FNAME[1] = "file.html";
        FNAME[2] = "file.";

        String ext;

        for (i = 0; i < Q; i++) {

            ext = FNAME[i].toLowerCase();
            String fileArray[] = ext.split("\\.");

            ext = fileArray[1];
          //  System.out.println(fileArray[fileArray.length-1]); // Will print the file extension
            /**
             * int lastDot = fileString.lastIndexOf('.');
             * String extension = fileString.subString(lastDot+1);
             */
           // m= p.matcher(ext); // Other Alternative
            System.err.println("Ext : " + ext + " - " + hashMt.get("html") + " - " + hashMt.containsKey(ext));

            if (hashMt.containsKey(ext))
                System.out.println(hashMt.get(ext));
            else
                System.out.println("UNKNOWN");
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}
