package Leetcode.Two_pointers;

import java.util.*;
import java.util.stream.Collectors;

public class TwoSum2 {
    public static void main(String[] args) {

        int[] strNum = { 1, 2, 3, 4, 5 };
        int target = 7;
        int[] result = twoSum(strNum, target);
        for (int element : result) {
            System.out.println(element);
        }

        // converting from int[] to List<Integer>
        List<Integer> result2 = Arrays.stream(twoSum(strNum, target))
                .boxed()
                .collect(Collectors.toList());

        result2.forEach(System.out::println);

        Integer[] result3 = Arrays.stream(twoSum(strNum, target))
                .boxed()
                .toArray(Integer[]::new);

        System.out.println(result3);
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff) + 1, i + 1 };
            }
            prevMap.put(num, i);
        }
        return new int[] {};
    }
}
