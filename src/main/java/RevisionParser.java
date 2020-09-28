import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class RevisionParser {
    @SuppressWarnings("deprecation")
    public JsonArray ListOfAllRevisions(InputStream inputStream){
        JsonParser parser = new JsonParser();
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray revisionList = null;
        for(Map.Entry<String,JsonElement> entry : pages.entrySet()){
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            revisionList = entryObject.getAsJsonArray("revisions");
        }
        return revisionList;
    }
}
