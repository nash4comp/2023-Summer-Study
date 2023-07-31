
import java.util.*;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = { 8, 7, 3, 5, 1, 4, 6 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfitMine(int[] prices) {
        // find min value and index in the given array
        int minValue = -1;
        int maxValue = -1;
        int minIndex = -1;

        minValue = Arrays.stream(prices).min().getAsInt();

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] == minValue) {
                minIndex = i;
                break;
            }
        }

        // find the max value and index in the given array, starting from the index
        maxValue = Arrays.stream(prices)
                .skip(minIndex)
                .max()
                .getAsInt();

        if ((maxValue == -1) || (minIndex == -1)) {
            return 0;
        } else {
            return maxValue - minValue;
        }
    }

    public static int maxProfit(int[] prices) {
        int leftPointer = 0;
        int rightPointer = 1;
        int maxProfit = 0;
        while (rightPointer < prices.length) {
            if (prices[leftPointer] < prices[rightPointer]) {
                maxProfit = Math.max(maxProfit, prices[rightPointer] - prices[leftPointer]);
                rightPointer++;
            } else {
                leftPointer = rightPointer;
                rightPointer++;
            }
        }
        return maxProfit;
    }
}
