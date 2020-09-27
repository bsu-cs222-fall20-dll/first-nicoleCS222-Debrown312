import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class URLConnectionTest {
    @SuppressWarnings("deprecation")
    @Test
    public void URLConnectionTest() throws IOException {
        URL wiki = new URL("http://en.wikipedia.org/wiki/Zappa");
        URLConnection connection = wiki.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Tracker/0.1 (debrown4@bsu.edu)");
        InputStream in = connection.getInputStream();
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(in);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        JsonElement holder = array.get(array.size()-1);
        System.out.println(holder);
    }
}
