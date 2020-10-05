package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;

public class MainFX extends Application {
    URLConnection urlConnection = new URLConnection();
    RevisionParser revisionParser = new RevisionParser();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Enter Search for Revision"));

        HBox urlArea = new HBox(new Label("Search Term:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            try {
                URL url = urlConnection.inputToURLConverter(textField.getText());
                ArrayList<Revisions> revisionList = revisionParser.listOfAllRevisions(urlConnection.getConnectionToWebsite(url, parent), parent);
                displayAllRevisions(revisionList, parent);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        parent.getChildren().add(searchButton);
        primaryStage.setScene(new Scene(parent, 350, 550));
        primaryStage.show();
    }
    public void displayAllRevisions(ArrayList<Revisions> revisionList, VBox parent) {
        if (revisionList != null) {
            for (Revisions entry : revisionList) {
                HBox revision = new HBox(new Label("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp()));
                parent.getChildren().add(revision);
            }
        }
    }


}
