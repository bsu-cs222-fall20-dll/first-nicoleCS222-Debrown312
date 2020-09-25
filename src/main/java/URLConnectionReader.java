import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL wiki = new URL("http://en.wikipedia.com/wiki/Zappa");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}