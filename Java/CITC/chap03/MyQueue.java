package Java.CITC.chap03;

import java.util.*;

public class MyQueue<T> {
    private static class MyQueueNode<T> {
        private T data;
        private MyQueueNode<T> next;
        private MyQueueNode<T> previous;

        public MyQueueNode() {
            this.next = null;
            this.previous = null;
        }

        public MyQueueNode(T data) {
            this.data = data;
        }
    }

    private MyQueueNode<T> top;
    private MyQueueNode<T> bottom;
    private int queueCounter = 0;

    public T queue(T data) {
        MyQueueNode<T> newQueue = new MyQueueNode<>(data);
        newQueue.next = top;
        top = newQueue;
        increaseQueueCounter();
        return data;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException();


    }

    public T peek() {]

    public boolean isEmpty() {
        return getQueueCounter() == 0 ? true : false;
    }

    public void printQueue() {
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

}
