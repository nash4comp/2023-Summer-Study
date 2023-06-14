package Chap11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorPractice02 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 24);
        map.put("Bob", 30);
        map.put("Charlie", 28);

        // Using Iterator to iterate through the keys
        Iterator<String> keyIterator = map.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            System.out.println("Key: " + key);
        }

        // Using Iterator to iterate through the values
        Iterator<Integer> valueIterator = map.values().iterator();
        while (valueIterator.hasNext()) {
            Integer value = valueIterator.next();
            System.out.println("Value: " + value);
        }

        // Using Iterator to iterate through the key-value pairs (entries)
        Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}
