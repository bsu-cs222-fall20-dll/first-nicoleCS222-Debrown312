package edu.bsu.cs222;

import java.net.URL;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws Exception {
        URLConnection urlConnection = new URLConnection();
        Menu menu = new Menu();
        URLResults urlResults = new URLResults();
        String userInput = menu.getUserRequest();
        URL url = urlConnection.inputToURLConverter(userInput);
        urlResults.RevisionList(urlConnection.getConnectionToWebsite(url));
    }

}

