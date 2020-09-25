import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public void getConnectionToWebsite() throws Exception {
        URL wiki = new URL("http://en.wikipedia.com/wiki/Zappa");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
        InputStream in = connection.getInputStream();
    }
}