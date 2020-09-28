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
    public InputStream getConnectionToWebsite(URL url) throws Exception {
        java.net.URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }

    public URL inputToURLConverter(String webSearch) throws Exception{
        String conversion = webSearch.replaceAll(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + conversion + "&rvprop=timestamp|user&rvlimit=20&redirects");
        return url;
    }
}