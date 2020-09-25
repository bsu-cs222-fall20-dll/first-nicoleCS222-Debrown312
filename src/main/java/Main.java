import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {

    }
    public void FirstAuthor() {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
        JsonElement firstAuthor = revisionParser.firstAuthorFinder(inputStream);
        System.out.println(firstAuthor);
    }
    public void RevisionList() {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
        for(JsonObject entry : revisionParser.ListOfAllRevisions(inputStream)) {
            System.out.println(entry);
        }
    }
}

