package Chap11;

import java.util.*;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        pq.offer(4);
        pq.offer(7);
        System.out.println(pq);
        Object obj = null;
        while ((obj = pq.poll()) != null)
        System.out.println(obj);
        System.out.println(pq);
    }
}