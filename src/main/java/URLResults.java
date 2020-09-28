import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.InputStream;

public class URLResults {
    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        for(JsonArray entry : revisionParser.ListOfAllRevisions(inputStream)) {
            System.out.println(entry + "\n");
        }
    }
}
