package edu.bsu.cs222;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.*;
import java.io.*;

public class URLConnection {
    public InputStream getConnectionToWebsite(URL url, VBox parent) {
        try {
            java.net.URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown312@gmail.com)");
            return connection.getInputStream();
        }catch(Exception e){
            HBox noWikiConnection = new HBox(new Label("Cannot connect to Wikipedia"));
            parent.getChildren().add(noWikiConnection);
        }
        return null;
    }

    public URL inputToURLConverter(String webSearch) throws Exception {
        String conversion = webSearch.replaceAll(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + conversion + "&rvprop=timestamp|user&rvlimit=20&redirects");
        return url;
    }
}