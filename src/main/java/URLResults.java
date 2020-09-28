import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.InputStream;

public class URLResults {
    public void FirstAuthor(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        JsonElement firstAuthor = revisionParser.firstAuthorFinder(inputStream);
        System.out.println(firstAuthor);
    }

    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        for(JsonArray entry : revisionParser.ListOfAllRevisions(inputStream)) {
            System.out.println(entry);
        }
    }
}
