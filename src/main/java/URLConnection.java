import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class URLConnection {
    public static String EncodeValue(String value){
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getCause());
        }
    }
    public InputStream getConnectionToWebsite(String webSearch) throws Exception {
        URL wiki = new URL(webSearch);
        java.net.URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }
}