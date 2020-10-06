package edu.bsu.cs222;

public class Revisions {
    private String user;
    private String timeStamp;
    private int counter = 1;

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

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter = this.counter +1;
    }
}
