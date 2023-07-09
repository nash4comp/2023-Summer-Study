package Easy;

// https://www.java67.com/2014/04/java-8-stream-examples-and-tutorial.html
// Get count, min, max, sum, and the average for numbers

import java.util.*;

public class java67_StreamEx08 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count = intList.stream()
                .mapToLong(Integer::longValue)
                .count();

        OptionalInt min = intList.stream()
                .mapToInt(Integer::intValue)
                .min();

        OptionalInt max = intList.stream()
                .mapToInt(Integer::intValue)
                .max();

        int sum = intList.stream()
                .mapToInt(Integer::intValue)
                .sum();

        OptionalDouble average = intList.stream()
                .mapToDouble(Integer::doubleValue)
                .average();

        System.out.println("count: " + count);
        printOptionalValue(min, "min");
        printOptionalValue(max, "min");
        System.out.println("sum: " + sum);
        printOptionalValue(average, "average");

    }

    public static void printOptionalValue(OptionalInt optionalInt, String name) {
        if (optionalInt.isPresent()) {
            System.out.println(name + ": " + optionalInt.getAsInt());
        } else {
            System.out.println(name + ": None");
        }
    }

    public static void printOptionalValue(OptionalDouble optionalDouble, String name) {
        if (optionalDouble.isPresent()) {
            System.out.println(name + ": " + optionalDouble.getAsDouble());
        } else {
            System.out.println(name + ": None");
        }
    }
}
