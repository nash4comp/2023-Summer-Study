package Chap11;

import java.util.*;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Jane", 90);
        map.put("Tom", 100);
        map.put("Lyon", 100);
        map.put("Harry", 95);
        map.put("Kathy", 80);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> e = (Map.Entry) it.next();
            System.out.println("Name: " + e.getKey() + ", Score: " + e.getValue());
        }

        set = map.keySet();
        System.out.println("List: " + set);

        Collection values = map.values();
        it = values.iterator();
        int total = 0;

        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            total += i.intValue();
        }

        System.out.println("Total: " + total);
        System.out.println("Average: " + (float) total / set.size());
        System.out.println("Maximum Score: " + Collections.max(values));
        System.out.println("Minimum Score: " + Collections.min(values));

    }
}
