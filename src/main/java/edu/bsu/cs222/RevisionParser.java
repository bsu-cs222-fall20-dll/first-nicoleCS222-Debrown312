package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

public class RevisionParser {
    ArrayList<Revisions> revisionList = new ArrayList<>();
    public ArrayList<Revisions> listOfAllRevisions(InputStream inputStream, VBox parent) {
        try {
            JsonElement rootElement = getRootElement(inputStream);
            tryRedirect(rootElement, parent);
            JsonObject pages = createJsonParserForWebsite(rootElement);
            JsonArray revisionArray = createJsonArrayForRevisions(pages);
            revisionList = createRevisionList(revisionArray);
            return revisionList;
        }catch(Exception e){
            HBox pageNotFound = new HBox(new Label("Page Not Found"));
            parent.getChildren().add(pageNotFound);
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    private JsonElement getRootElement(InputStream inputStream){
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        return rootElement;
    }
    private JsonObject createJsonParserForWebsite(JsonElement rootElement) {
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        return pages;
    }

    private JsonArray createJsonArrayForRevisions(JsonObject pages) {
        JsonArray revisionArray = null;
        for (Map.Entry<String, JsonElement> entry : pages.entrySet()) {
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionArray = entryObject.getAsJsonArray("revisions");
        }
        return revisionArray;
    }

    private ArrayList<Revisions> createRevisionList(JsonArray revisionArray) {
        for (JsonElement entry : revisionArray) {
            String user = entry.getAsJsonObject().get("user").getAsString();
            String timeStamp = entry.getAsJsonObject().get("timestamp").getAsString();
            Revisions revision = new Revisions(user, timeStamp);
            revisionList.add(revision);
        }
        return revisionList;
    }
    @SuppressWarnings("deprecation")
    private void checkForRedirects(JsonElement rootElement, VBox parent){
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects").get(0).getAsJsonObject();
        String from = redirects.get("from").getAsString();
        String to = redirects.get("to").getAsString();
        HBox redirect = new HBox(new Label("From: " + from + "\nTo: " + to + "\n"));
        parent.getChildren().add(redirect);
        //System.out.println("From: " + from + "\nTo: " + to + "\n");
    }

    private void tryRedirect(JsonElement rootElement, VBox parent){
        try{
            checkForRedirects(rootElement, parent);
        }catch(Exception f){
        }
    }
}
