import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        RevisionParser revisionParser = new RevisionParser();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("sample.json");
        String firstAuthor = revisionParser.firstAuthorFinder(inputStream);
        System.out.println(firstAuthor);
    }
}
