package Practice.Stream;

import java.util.*;

// Write a Java program to find the maximum and minimum values in a list of integers using streams.

public class W3_StreamEx07 {
    public static void main(String[] args) {
        List<Integer> arrList = Arrays.asList(6, 4, 6, 7, 3, 2, 1, -98, 3, 4, 23);
        int maxNumber = arrList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
        System.out.println(maxNumber);

        int minNumber = arrList.stream()
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
        System.out.println(minNumber);

    }

}
