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
    @SuppressWarnings("deprecation")
    public ArrayList<Revisions> ListOfAllRevisions(InputStream inputStream){
        JsonObject pages = createJsonParser(inputStream);
        JsonArray revisionArray = null;
        for(Map.Entry<String, JsonElement> entry : pages.entrySet()){
//            if(entry.getValue().getAsJsonObject().getAsString().equals("-1")){
//                System.out.println("Page Not Found");
//            }
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionArray = entryObject.getAsJsonArray("revisions");
        }
        ArrayList<Revisions> revisionList = new ArrayList<>();
        //System.out.println("Before the For loop");
        for(JsonElement entry : revisionArray){
            //System.out.println("after the for loop");
            String user = entry.getAsJsonObject().get("user").getAsString();
            String timeStamp = entry.getAsJsonObject().get("timestamp").getAsString();
            Revisions revision = new Revisions(user, timeStamp);
            revisionList.add(revision);
        }
        return revisionList;
    }

    public JsonObject createJsonParser(InputStream inputStream){
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        return pages;
    }

}