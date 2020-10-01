package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) throws Exception {
        URLConnection urlConnection = new URLConnection();
        Menu menu = new Menu();
        URLResults urlResults = new URLResults();
        String userInput = menu.getUserRequest();
        URL url = urlConnection.inputToURLConverter(userInput);
        urlResults.RevisionList(urlConnection.getConnectionToWebsite(url));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}

