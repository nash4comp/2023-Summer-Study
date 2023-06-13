package Chap11;

import java.util.*;

public class EntrySetExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Alice", 90);
        scores.put("Tom", 82);
        scores.put("Grace", 75);

        Set<Map.Entry<String, Integer>> entries = scores.entrySet();
        System.out.println(scores);
        System.out.println(entries);

        for (Map.Entry<String, Integer> entry : entries) {
            String name = entry.getKey();
            Integer score = entry.getValue();
            System.out.println("Name: " + name + ", Score: " + score);
        }

    }
}
