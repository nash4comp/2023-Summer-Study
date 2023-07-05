package Practice.Stream;

import java.util.*;
import java.util.stream.Collectors;

// Write a Java program to remove all duplicate elements from a list using streams.
public class W3_StreamEx04 {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("A", "B", "C", "A", "A", "B", "D");
        List<String> result = arr.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
