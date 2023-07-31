// https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] heights2 = { 4, 2, 0, 3, 2, 5 };

        System.out.println(trap(heights1));
        System.out.println(trap(heights2));
    }

    public static int trap(int[] heights) {
        if (heights.length == 0)
            return 0;

        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftPointerMax = heights[leftPointer];
        int rightPointerMax = heights[rightPointer];
        int area = 0;

        while (leftPointer < rightPointer) {
            if (leftPointerMax < rightPointerMax) {
                leftPointer++;
                leftPointerMax = Math.max(leftPointerMax, heights[leftPointer]);
                area += leftPointerMax - heights[leftPointer];
            } else {
                rightPointer--;
                rightPointerMax = Math.max(rightPointerMax, heights[rightPointer]);
                area += rightPointerMax - heights[rightPointer];
            }
        }
        return area;
    }
}
