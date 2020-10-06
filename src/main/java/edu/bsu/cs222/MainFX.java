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
import java.util.HashMap;

public class MainFX extends Application {
    URLConnection urlConnection = new URLConnection();
    RevisionParser revisionParser = new RevisionParser();
    MostActiveRevisions mostActiveRevisions = new MostActiveRevisions();
    VBox parent = new VBox();
    TextField textField = new TextField();
    ComboBox<String> revisionSelector = new ComboBox<>();
    HBox revision = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        parent.getChildren().add(new Label("Enter Search for Revision"));

        createSearchBox();

        revisionSelector.getItems().addAll("Recent", "Most Active");
        parent.getChildren().add(revisionSelector);

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

    private void searchWikipedia(Button searchButton) {
        searchButton.setOnAction(event -> {
            try {
                URL url = urlConnection.inputToURLConverter(textField.getText());
                ArrayList<Revisions> revisionList = revisionParser.listOfAllRevisions(urlConnection.getConnectionToWebsite(url, parent), parent);
                //revision.getChildren().clear();
                if(revisionSelector.getValue().equals("Recent")) {
                    displayRecentRevisions(revisionList);
                }else if(revisionSelector.getValue().equals("Most Active")){
                    HashMap<String, Integer> mostActiveUserMap = mostActiveRevisions.getMostActiveRevisions(revisionList);
                    if(mostActiveUserMap != null) {
                        displayMostActiveRevisions(mostActiveUserMap);
                    }
                }else{
                    revision = new HBox(new Label("There was an error"));
                    parent.getChildren().add(revision);
                }
            } catch (Exception ignored) {
            }
        });
    }

    private void displayMostActiveRevisions(HashMap<String, Integer> mostActiveUserMap) {
        for(String user : mostActiveUserMap.keySet()){
            int counter = mostActiveUserMap.get(user);
            revision = new HBox(new Label("User: " + user + "   Revisions: " + counter));
            parent.getChildren().add(revision);
        }
    }

    private void displayRecentRevisions(ArrayList<Revisions> revisionList) {
        if (revisionList != null) {
            for (Revisions entry : revisionList) {
                revision = new HBox(new Label("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp()));
                parent.getChildren().add(revision);
            }
        }
    }


}
