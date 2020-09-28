import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.InputStream;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws Exception {
        URLConnection urlConnection = new URLConnection();
        Menu menu = new Menu();
        String userInput = menu.getUserRequest();
        URL url = urlConnection.inputToURLConverter(userInput);
        FirstAuthor(urlConnection.getConnectionToWebsite(url));
    }

    public static void FirstAuthor(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        //InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
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

