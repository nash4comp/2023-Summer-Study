package Easy;

// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Create a List of the square of all distinct numbers

import java.util.*;
import java.util.stream.Collectors;

public class java67_StreamEx07 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 7, 8);
        List<Integer> squaredList = intList.stream()
                .distinct()
                .map(e -> e * e)
                .collect(Collectors.toList());

        squaredList.forEach(System.out::println);
    }
}
