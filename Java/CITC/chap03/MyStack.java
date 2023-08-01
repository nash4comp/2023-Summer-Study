package Java.CITC.chap03;

import java.util.*;

public class MyStack<T> {
    private static class MyStackNode<T> { // This is basic structure of stack node.
        private T data;
        private MyStackNode<T> next;

        public MyStackNode(T data) { // constructor of MyStackNode class
            this.data = data;
        }
    }

    private MyStackNode<T> top;
    private int nodeCounter = 0;

    public int getNodeCounter() {
        return nodeCounter;
    }

    public void increaseNodeCounter() {
        nodeCounter++;
    }

    public void decreaseNodeCounter() {
        nodeCounter--;
    }

    public T push(T data) {
        MyStackNode<T> newStack = new MyStackNode<>(data);
        newStack.next = top;
        top = newStack;
        increaseNodeCounter();
        return data;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T data = top.data;
        top = top.next;
        decreaseNodeCounter();
        return data;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return getNodeCounter() == 0 ? true : false;
        // return top == null;
    }

    public void printStack() {
        MyStackNode<T> temp = top;
        for (int i = 0; i < getNodeCounter(); i++) {
            System.out.println(top.data);
            top = top.next;
        }
        top = temp;
        System.out.println("---\n");
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack1 = new MyStack<>();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);
        myStack1.pop();
        myStack1.peek();
        myStack1.printStack();

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("A");
        myStack2.push("B");
        myStack2.push("C");
        myStack2.pop();
        myStack2.peek();
        myStack2.printStack();
    }
}
