package CITC.chap01;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top; // top stack
    private int stackCount = 0;

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        stackCount--;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item); // new stack to be added
        t.next = top;
        top = t;
        stackCount++;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        StackNode<T> topStack = top;
        for (int i = 0; i < stackCount; i++) {
            System.out.println(peek());
            top = top.next;
        }
        System.out.println("---\n");
        top = topStack;
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.printStack();
        myStack.push(3);
        myStack.printStack();
    }

}
