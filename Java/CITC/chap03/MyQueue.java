package CITC.chap03;

import java.util.*;

public class MyQueue<T> {
    private static class MyQueueNode<T> {
        private T data;
        private MyQueueNode<T> next;

        public MyQueueNode(T data) {
            this.data = data;
        }
    }

    private MyQueueNode<T> top;
    private MyQueueNode<T> bottom;
    private int queueCounter = 0;

    public T queue(T data) {
        MyQueueNode<T> newQueue = new MyQueueNode<>(data);
        if (top != null) {
            top.next = newQueue; // if bottom == top, the next pointer of bottom is also points newQueue
        }
        top = newQueue;
        if (bottom == null) {
            bottom = top;
        }
        increaseQueueCounter();
        return data;
    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T data = bottom.data;
        bottom = bottom.next;
        if (bottom == null) {
            top = null;
        }
        decreaseQueueCounter();
        return data;
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return bottom.data;
    }

    public boolean isEmpty() {
        return getQueueCounter() == 0 ? true : false;
    }

    public void printQueue() {
        ArrayList<T> list = new ArrayList<>();
        MyQueueNode<T> currentNode = bottom;
        if (isEmpty())
            throw new NoSuchElementException();
        for (int i = 0; i < getQueueCounter(); i++) {
            list.add(peek());
            bottom = bottom.next;
        }
        bottom = currentNode;
        Collections.reverse(list);
        System.out.println(list);
    }

    public int getQueueCounter() {
        return queueCounter;
    }

    public void increaseQueueCounter() {
        queueCounter++;
    }

    public void decreaseQueueCounter() {
        queueCounter--;
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.queue(1);
        myQueue.queue(2);
        myQueue.queue(3);
        myQueue.queue(4);
        // myQueue.dequeue();
        // myQueue.dequeue();
        // myQueue.dequeue();
        myQueue.printQueue();

        // myQueue.printQueue();
    }

}
