package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    VBox parent = new VBox();
    TextField textField = new TextField();
    ComboBox<String> revisionSelector = new ComboBox<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        parent.getChildren().add(new Label("Enter Search for Revision"));

        createSearchBox();

        Button searchButton = new Button("Search");
        searchWikipedia(searchButton);
        parent.getChildren().add(searchButton);

        primaryStage.setScene(new Scene(parent, 350, 550));
        primaryStage.show();
    }

    private void createSearchBox() {
        HBox urlArea = new HBox(new Label("Search Term:"));
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);
    }

    public void searchWikipedia(Button searchButton) {
        searchButton.setOnAction(event -> {
            try {
                URL url = urlConnection.inputToURLConverter(textField.getText());
                ArrayList<Revisions> revisionList = revisionParser.listOfAllRevisions(urlConnection.getConnectionToWebsite(url, parent), parent);
                displayAllRevisions(revisionList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void displayAllRevisions(ArrayList<Revisions> revisionList) {
        if (revisionList != null) {
            for (Revisions entry : revisionList) {
                HBox revision = new HBox(new Label("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp()));
                parent.getChildren().add(revision);
            }
        }
    }


}
