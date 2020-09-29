import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Map;

public class URLConnectionTest {
    @SuppressWarnings("deprecation")
    @Test
    public void URLConnectionUserRevisionsTest() throws IOException {
        URL wiki = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=20&redirects");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        connection.connect();
        JsonParser parser = new JsonParser();
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        System.out.println(array.get(0).getAsJsonObject().get("user").getAsString());
    }
    @SuppressWarnings("deprecation")
    @Test
    public void URLConnectionTimeStampRevisionTest() throws IOException {
        URL wiki = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=20&redirects");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        connection.connect();
        JsonParser parser = new JsonParser();
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        System.out.println(array.get(0).getAsJsonObject().get("timestamp").getAsString());
    }
    @Test
    @SuppressWarnings("deprecation")
    public void TestRevisionParser() throws IOException {
        URL wiki = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=20&redirects");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        connection.connect();
        JsonParser parser = new JsonParser();
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisionArray = null;
        for(Map.Entry<String, JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionArray = entryObject.getAsJsonArray("revisions");
        }
        //JsonArray revisionArray = pages.getAsJsonArray("revisions");
        ArrayList<Revisions> revisionList = new ArrayList<>();
        System.out.println("Before the For loop");
        for(JsonElement entry : revisionArray){
            //System.out.println("after the for loop");
            String user = entry.getAsJsonObject().get("user").getAsString();
            String timeStamp = entry.getAsJsonObject().get("timestamp").getAsString();
            Revisions revision = new Revisions(user, timeStamp);
            revisionList.add(revision);
        }
        for(Revisions entry : revisionList){
            System.out.println("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp());
        }
    }
}