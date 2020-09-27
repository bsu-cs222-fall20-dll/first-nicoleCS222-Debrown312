import java.net.*;
import java.io.*;

public class URLConnection {
    public InputStream getConnectionToWebsite(String webSearch) throws Exception {
        URL wiki = new URL(webSearch);
        java.net.URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }
}