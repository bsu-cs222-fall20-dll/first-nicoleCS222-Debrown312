import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.InputStream;

public class URLResults {
    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        JsonArray revisionArray = revisionParser.ListOfAllRevisions(inputStream);
        for(JsonElement entry : revisionArray) {
            System.out.println(entry + "\n");
        }
    }
}
