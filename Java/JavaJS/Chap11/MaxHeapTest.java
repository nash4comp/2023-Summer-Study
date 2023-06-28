package Chap11;

import java.util.*;

public class MaxHeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(2);
        maxHeap.offer(7);
        maxHeap.offer(-5);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}
