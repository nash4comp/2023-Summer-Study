package Easy;

import java.util.*;

// Write a Java program to count the number of strings in a list that start with a specific letter using streams.

public class W3_StreamEx05 {
    public static void main(String[] args) {
        List<String> strArr = Arrays.asList("harry", "jane", "tom", "Brian", "jean", "jack", "nash", "jacky");
        long num = strArr.stream()
                .filter(s -> s.startsWith(args[0]))
                .count();
        System.out.println(num);
    }
}
