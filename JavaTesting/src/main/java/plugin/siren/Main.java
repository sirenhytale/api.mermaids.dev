package plugin.siren;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IO.println(String.format("Hello and welcome!"));

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            IO.println("i = " + i);
        }

        test();
    }

    public static void test() throws IOException {

        // Make a URL to the web page
        URL url = new URL("https://api.mermaids.dev/api/mermaids/release/");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.

        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;

            // read each line and write to System.out
            while ((line = br.readLine()) != null) {
                //line = line.substring(line.indexOf("<h1>") + 1);
                //line = line.substring(0, line.indexOf("<p>"));
                //System.out.println(line);

                if(line.contains("<h1>") && line.contains("</h1>")){
                    line = line.substring(line.indexOf("<h1>") + 4);
                    line = line.substring(0, line.indexOf("</"));
                    System.out.println(line);
                }
            }
        }
    }
}
