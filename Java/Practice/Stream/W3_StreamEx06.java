package Practice.Stream;

import java.util.*;
import java.util.stream.Collectors;

// Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
public class W3_StreamEx06 {
    public static void main(String[] args) {
        List<String> strLst = Arrays.asList("harry", "jane", "tom", "Brian", "jean", "jack", "nash", "jacky");
        List<String> ascendingOrdered = strLst.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(ascendingOrdered);

        List<String> descendingOrdered = strLst.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(descendingOrdered);

    }
}
