package edu.bsu.cs222;

import java.io.InputStream;
import java.util.ArrayList;

public class URLResults {
    public void RevisionList(InputStream inputStream) {
        RevisionParser revisionParser = new RevisionParser();
        ArrayList<Revisions> revisionList = revisionParser.listOfAllRevisions(inputStream);
        if(revisionList != null) {
            for (Revisions entry : revisionList) {
                System.out.println("User: " + entry.getUser() + "    TimeStamp: " + entry.getTimeStamp());
            }
        }
    }


}
