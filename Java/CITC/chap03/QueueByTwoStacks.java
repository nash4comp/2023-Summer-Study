package CITC.chap03;

public class QueueByTwoStacks<T> {
    public static void main(String[] args) {
        QueueByTwoStacks<Integer> qbt = new QueueByTwoStacks<>();
        qbt.enqueue(1);
        qbt.enqueue(2);
        qbt.enqueue(3);
        qbt.dequeue();
        qbt.print();

    }

    MyStack<T> myStack1 = new MyStack<>();
    MyStack<T> myStack2 = new MyStack<>();

    public T enqueue(T data) {
        myStack1.push(data);
        return data;
    }

    public T dequeue() {
        T data = null;
        int counter = myStack1.getNodeCounter();
        for (int i = 0; i < counter; i++) {
            myStack2.push(myStack1.pop());
        }
        data = myStack2.pop();

        counter = myStack2.getNodeCounter();
        for (int i = 0; i < counter; i++) {
            myStack1.push(myStack2.pop());
        }
        return data;
    }

    public void print() {
        myStack1.printStack();
    }

}
