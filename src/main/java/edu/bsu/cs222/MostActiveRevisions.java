package edu.bsu.cs222;

import java.util.*;

public class MostActiveRevisions {
    public HashMap<String, Integer> getMostActiveRevisions(ArrayList<Revisions> revisionList) {
        if(revisionList != null){
            HashMap<String, Integer> mostActiveUserMap = new HashMap<>();
            for(Revisions entry : revisionList){
                if(mostActiveUserMap.containsKey(entry.getUser())){
                    int counter = mostActiveUserMap.get(entry.getUser());
                    counter += 1;
                    mostActiveUserMap.replace(entry.getUser(), counter);
                }else{
                    mostActiveUserMap.put(entry.getUser(), 1);
                }
            }
            return sortMostActiveRevisions(mostActiveUserMap);
        }
        return null;
    }

    public HashMap<String, Integer> sortMostActiveRevisions(HashMap<String, Integer> mostActiveUserMap){
//        List list = new LinkedList(mostActiveUserMap.entrySet());
//        Collections.sort(list, new Comparator() {
//            public int compare(Object o1, Object o2) {
//                return ((Comparable) ((Map.Entry) (o1)).getValue())
//                        .compareTo(((Map.Entry) (o2)).getValue());
//            }
//        });
//
//        HashMap sortedHashMap = new LinkedHashMap();
//        for (Iterator it = list.iterator(); it.hasNext();) {
//            Map.Entry entry = (Map.Entry) it.next();
//            sortedHashMap.put(entry.getKey(), entry.getValue());
//        }
//        return sortedHashMap;
        return mostActiveUserMap;
    }

}
