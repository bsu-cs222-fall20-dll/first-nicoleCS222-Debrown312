import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Set;

public class URLConnectionTest {
    @SuppressWarnings("deprecation")
    @Test
    public void URLConnectionTest1() throws IOException {
        URL wiki = new URL("https://en.wikipedia.org/w/api.php?action=query&prop=revisions&format=xml&rvprop=timestamp%7Cuser&rvlimit=4&titles=frank%20zappa&redirects");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        JsonParser parser = new JsonParser();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader reader2 = new BufferedReader(reader);
        JsonElement rootElement = parser.parse(reader2);
        //JsonObject rootObject = parser.parse(reader).getAsJsonObject();
        //JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        //JsonArray array = null;
        /*
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }

         */

        //System.out.println();
        //JsonElement holder = array.get(array.size()-1);
        //System.out.println(holder);


    }
    /*
    @SuppressWarnings("deprecation")
    @Test
    public void URLConnectionTest2() throws IOException {
        URL wiki = new URL("http://en.wikipedia.org/wiki/Zappa");
        HttpURLConnection connection = (HttpURLConnection) wiki.openConnection();
        JsonElement jsonElement = new JsonParser().parse(new InputStreamReader((InputStream) connection.getContent()));
        JsonElement pages = jsonElement.getAsJsonObject().get("query").getAsJsonObject().get("pages");
        Set<Map.Entry<String, JsonElement>> entrySet = pages.getAsJsonObject().entrySet();
        JsonArray yourDesiredElement = null;
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            yourDesiredElement = entry.getValue();
            System.out.println(yourDesiredElement);
        }

    }

     */
}