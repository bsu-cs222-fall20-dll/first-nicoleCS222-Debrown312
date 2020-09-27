import java.util.Scanner;

public class Menu {
    public String getUserRequest(){
        Scanner console = new Scanner(System.in);
        System.out.println("What would you like to look up?");
        String userRequest = console.nextLine();
        return userRequest;
    }

    public String UserInput() {
        String userInput = getUserRequest();
        String wikiSearch = "http://en.wikipedia.org/wiki/" + userInput;
        return wikiSearch;
    }
}
