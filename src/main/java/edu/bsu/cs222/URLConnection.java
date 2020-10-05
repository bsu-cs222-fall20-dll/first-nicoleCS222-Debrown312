package edu.bsu.cs222;

import java.net.*;
import java.io.*;

public class URLConnection {
    public InputStream getConnectionToWebsite(URL url) {
        try {
            java.net.URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
            return connection.getInputStream();
        }catch(Exception e){
            System.out.println("Cannot Connect to Wikipedia");
        }
        return null;
    }

    public URL inputToURLConverter(String webSearch) throws Exception {
        String conversion = webSearch.replaceAll(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + conversion + "&rvprop=timestamp|user&rvlimit=25&redirects");
        return url;
    }
}