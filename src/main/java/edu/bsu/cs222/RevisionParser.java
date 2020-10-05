package edu.bsu.cs222;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Map;

public class RevisionParser {
    ArrayList<Revisions> revisionList = new ArrayList<>();
    public ArrayList<Revisions> listOfAllRevisions(InputStream inputStream) {
        try {
            JsonObject pages = createJsonParser(inputStream);
            JsonArray revisionArray = createJsonArray(pages);
            revisionList = createRevisionList(revisionArray);
            return revisionList;
        }catch(Exception e){
            System.out.println("Page Not Found");
            return null;
        }
    }

    @SuppressWarnings("deprecation")
    private JsonObject createJsonParser(InputStream inputStream) {
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        return pages;
    }

    private JsonArray createJsonArray(JsonObject pages) {
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
    private void checkForRedirects(JsonObject pages){

    }
}
