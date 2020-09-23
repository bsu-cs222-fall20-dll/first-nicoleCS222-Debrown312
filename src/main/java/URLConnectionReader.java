import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL wiki = new URL("http://www.oracle.com/");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        InputStream in = connection.getInputStream();
        InputStreamReader inReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inReader);
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}