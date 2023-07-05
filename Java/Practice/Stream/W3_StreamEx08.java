package Practice.Stream;

import java.util.*;

// Write a Java program to find the second smallest and largest elements in a list of integers using streams.

public class W3_StreamEx08 {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(6, 4, 6, 7, 3, 9, 2, 1, -98, 3, 4, 23);

        // Solution 1
        // int minNumber = arrList.stream()
        //         .mapToInt(Integer::intValue)
        //         .min()
        //         .getAsInt();

        // int secondSmallestNumber = arrList.stream()
        //         .filter(s -> s > minNumber)
        //         .mapToInt(Integer::intValue)
        //         .min()
        //         .getAsInt();

        // System.out.println(secondSmallestNumber);

        // int maxNumber = arrList.stream()
        //         .mapToInt(Integer::intValue) // unboxing wrapper
        //         .max()
        //         .getAsInt(); // OptionalInt to int

        // int secondLargestNumber = arrList.stream()
        //         .filter(s -> s < maxNumber)
        //         .mapToInt(Integer::intValue)
        //         .max()
        //         .getAsInt();

        // System.out.println(secondLargestNumber);

        // Solution 2
        Integer secondSmallest = arrList.stream()
            .distinct() // remove duplicated numbers
            .sorted() // sorting by ascending order
            .skip(1) // skipping the first stream element
            .findFirst()
            .orElse(null);

        System.out.println(secondSmallest);
        
        Integer secondLargest = arrList.stream()
        .distinct()
        .sorted(Comparator.reverseOrder()) // sorting by descending order
        .skip(1)
        .findFirst()
        .orElse(null);
        System.out.println(secondLargest);

    }
}
