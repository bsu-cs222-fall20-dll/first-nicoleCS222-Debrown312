import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        //FirstAuthor();
        RevisionList();

    }
    public static void FirstAuthor() {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
        JsonElement firstAuthor = revisionParser.firstAuthorFinder(inputStream);
        System.out.println(firstAuthor);
    }
    public static void RevisionList() {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
        for(JsonArray entry : revisionParser.ListOfAllRevisions(inputStream)) {
            System.out.println(entry);
        }
    }
}

