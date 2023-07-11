
// https://leetcode.com/problems/container-with-most-water/

import java.util.*;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] height2 = { 1, 1 };
        System.out.println(maxAreaTwoPointer(height1));
        System.out.println(maxAreaTwoPointer(height2));
    }

    public static int maxAreaMine(int[] height) {
        // Convert the array into map to make it easy to calculate the area
        // Key should be index number, and the value should be the height
        HashMap<Integer, Integer> verticalLines = new HashMap<>();
        for (int i = 0; i < height.length; i++) {
            verticalLines.put(i, height[i]);
        }

        // Calculate the area by minimum y * distance between x
        // Store the result of the calculation into set
        // time complexity O(N^2)
        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > 0; j--) {
                areas.add((j - i) * Math.min(verticalLines.get(i), verticalLines.get(j)));
            }
        }

        // Find the max value from the set
        areas.sort(Comparator.reverseOrder());
        return areas.get(0);
    }


    public static int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;

        while (leftPointer < rightPointer) {
            int heightValue = Math.min(height[leftPointer], height[rightPointer]);
            int widthValue = rightPointer - leftPointer;
            maxArea = Math.max(maxArea, heightValue * widthValue);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
