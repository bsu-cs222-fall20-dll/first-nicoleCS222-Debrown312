import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Map;

public class JsonLearningTest {
    @SuppressWarnings("deprecation")
    @Test
    public void testCountRevisions(){
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray array = null;
        //array.get(1).getAsJsonObject().get("user").getAsString();
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            array = entryObject.getAsJsonArray("revisions");
        }
        System.out.println(array);
        Assertions.assertEquals(4, array.size());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testCountRedirects(){
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonArray redirects = rootObject.getAsJsonObject("query").getAsJsonArray("redirects");
        JsonObject holder = redirects.get(redirects.size() - 1).getAsJsonObject();
        String user = holder.get("to").toString();
        Assertions.assertEquals("Frank Zappa", user);
    }
}
