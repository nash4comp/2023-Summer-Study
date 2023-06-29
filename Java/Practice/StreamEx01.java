package Practice;

// Write a Java program to calculate the average of a list of integers using streams.

import java.util.Arrays;
import java.util.List;

public class StreamEx01 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Lists: " + nums);

        double average = nums.stream()
            // .reduce(0, Integer::sum) / nums.size();
            .mapToDouble(Integer::doubleValue)
            .average()
            .orElse(0.0);
        System.out.println("Average: " + average);
    }
}
