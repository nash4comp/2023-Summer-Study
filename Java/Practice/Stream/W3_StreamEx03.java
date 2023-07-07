
import java.util.*;

// Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
public class W3_StreamEx03 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenSum = nums.stream()
                .filter(s -> s % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        int oddSum = nums.stream()
                .filter(s -> s % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(evenSum);
        System.out.println(oddSum);
    }
}
