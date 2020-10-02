package edu.bsu.cs222;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        //launch(args);
        URLConnection urlConnection = new URLConnection();
        Menu menu = new Menu();
        URLResults urlResults = new URLResults();
        String userInput = menu.getUserRequest();
        URL url = urlConnection.inputToURLConverter(userInput);
        urlResults.RevisionList(urlConnection.getConnectionToWebsite(url));
    }

//    @Override
//    public void start(Stage primaryStage) {
//        VBox parent = new VBox();
//        parent.getChildren().add(new Label("Enter Search for Revision"));
//
//        HBox urlArea = new HBox(new Label("Search Term:"));
//        TextField textField = new TextField();
//        urlArea.getChildren().add(textField);
//        parent.getChildren().add(urlArea);
//
//        Button searchButton = new Button("Search");
//        searchButton.setOnAction(event -> {
//            System.out.println("I would like to access" + textField.getText() + "here");
//        });
//        parent.getChildren().add(searchButton);
//
//        primaryStage.setScene(new Scene(parent));
//        primaryStage.show();
//    }
}

