package edu.bsu.cs222;

public class Revisions {
    private final String user;
    private final String timeStamp;

    public Revisions(String user, String timeStamp) {
        this.user = user;
        this.timeStamp = timeStamp;
    }

    public String getUser() {
        return user;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

}
