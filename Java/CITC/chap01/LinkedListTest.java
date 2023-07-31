package CITC.chap01;

import java.util.*;

class Node {
    int data;
    Node previous;
    Node next;

    public Node(int data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTest {
    public static MyLinkedList addTwoNodesReverse(MyLinkedList firstList, MyLinkedList secondList) {
        int sum = firstList.extractNumber() + secondList.extractNumber();
        MyLinkedList resultNode = new MyLinkedList();
        int length = (int) Math.log10(sum) + 1;
        int digit = 0;
        int place = length;
        for (int i = 0; i < length; i++) {
            digit = sum / (int) Math.pow(10, place - 1);
            sum -= digit * (int) Math.pow(10, place - 1);
            resultNode.insertFirstNode(digit);
            place--;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertLastNode(1);
        myLinkedList.insertLastNode(2);
        myLinkedList.insertLastNode(3);
        myLinkedList.insertFirstNode(0);
        myLinkedList.insertFirstNode(-1);
        myLinkedList.insertFirstNode(-2);
        myLinkedList.insertFirstNode(-3);
        myLinkedList.insertFirstNode(-4);
        myLinkedList.deleteFirstNode();
        myLinkedList.deleteFirstNode();
        myLinkedList.deleteFirstNode();
        myLinkedList.deleteFirstNode();

        myLinkedList.printNode();
        // System.out.println("\nTotal node size: " + myLinkedList.getTotalNodeSize());
        // System.out.println("\nAfter deleting the first node");
        // myLinkedList.deleteFirstNode();
        // myLinkedList.deleteFirstNode();
        // myLinkedList.deleteFirstNode();
        // myLinkedList.printNode();
        // System.out.println("\nTotal node size: " + myLinkedList.getTotalNodeSize());
        // System.out.println("\nAfter deleting the last node");
        // myLinkedList.deleteLastNode();
        // myLinkedList.deleteLastNode();
        // myLinkedList.deleteLastNode();
        // System.out.println("\nBefore deleting duplicate node");
        // myLinkedList.insertLastNode(1);
        // myLinkedList.insertLastNode(2);
        // myLinkedList.insertLastNode(3);
        // myLinkedList.insertLastNode(4);
        // myLinkedList.insertLastNode(5);
        // myLinkedList.insertLastNode(1);
        // myLinkedList.insertLastNode(2);
        // myLinkedList.insertLastNode(3);
        // myLinkedList.printNode();
        // System.out.println("\nTotal node size: " + myLinkedList.getTotalNodeSize());
        // myLinkedList.deleteDuplicates();
        // System.out.println("\nAfter deleting duplicate node");
        // myLinkedList.printNode();
        System.out.println("\nTotal node size: " + myLinkedList.getTotalNodeSize());
        // System.out.println(myLinkedList.extractNumber());
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        list1.insertLastNode(6);
        list1.insertLastNode(1);
        list1.insertLastNode(7);
        list2.insertLastNode(2);
        list2.insertLastNode(3);
        list2.insertLastNode(4);
        addTwoNodesReverse(list1, list2).printNode();

        // LinkedList linkedList = new LinkedList<>();
        // linkedList.add(1);
        // linkedList.add(2);
        // linkedList.add(3);
        // linkedList.removeFirst();
        // System.out.println(linkedList);

    }

}

class MyLinkedList { // Circular doubly linked list
    private Node headNode; // The first located node
    private Node tailNode; // The last located node
    private int totalNodeSize;

    public MyLinkedList() {
        headNode = null;
        tailNode = null;
        totalNodeSize = 0;
    }

    public int getTotalNodeSize() {
        return totalNodeSize;
    }

    public int insertLastNode(int data) {
        Node newNode = new Node(data);
        if (headNode == null) { // if the node is empty
            headNode = newNode;
            tailNode = newNode;
            headNode.previous = tailNode;
            headNode.next = tailNode;
            tailNode.previous = headNode;
            tailNode.next = headNode;
            totalNodeSize++;
        } else { // if the node is not empty
            tailNode.next = newNode;
            newNode.next = headNode;
            newNode.previous = tailNode;
            headNode.previous = newNode;
            tailNode = newNode;
            totalNodeSize++;
        }
        return data;
    }

    public int insertFirstNode(int data) {
        Node newNode = new Node(data);
        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            totalNodeSize++;
        } else {
            headNode.previous = newNode;
            tailNode.next = newNode;
            newNode.next = headNode;
            newNode.previous = tailNode;
            headNode = newNode;
            totalNodeSize++;
        }

        return data;
    }

    public int deleteFirstNode() { // TODO: Convert E return type after completion of code
        int deletedData;
        if (headNode == null) {
            throw new NoSuchElementException();
        } else {
            deletedData = headNode.data;
            Node secondNode = headNode.next;
            tailNode.next = secondNode;
            secondNode.previous = tailNode;
            headNode = secondNode;
            totalNodeSize--;
        }

        return deletedData;
    }

    public int deleteLastNode() {
        int deletedData;
        if (headNode == null) {
            throw new NoSuchElementException();
        } else {
            deletedData = tailNode.data;
            Node lastSecondNode = tailNode.previous;
            lastSecondNode.next = headNode;
            headNode.previous = lastSecondNode;
            tailNode = lastSecondNode;
            totalNodeSize--;
        }
        return deletedData;
    }

    public void deleteDuplicates() {
        HashSet<Integer> set = new HashSet<Integer>();
        Node currentNode = headNode;
        Node previousNode = null;
        do {
            if (set.contains(currentNode.data)) {
                previousNode.next = currentNode.next;
                if (currentNode == tailNode) {
                    tailNode = previousNode;
                }
                totalNodeSize--;
            } else {
                set.add(currentNode.data);
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        } while (currentNode != headNode);
    }

    public int findKthToFirstElement(int k) {
        if (k > getTotalNodeSize() - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node currentNode = headNode;
        for (int i = 0; i < k; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public int findKthToLastElement(int k) {
        if (k > getTotalNodeSize() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = tailNode;
        for (int i = 0; i < k; i++) {
            currentNode = currentNode.previous;
        }
        return currentNode.data;
    }

    public int extractNumber() {
        int number = 0;
        while (totalNodeSize > 0) {
            if (findKthToLastElement(0) < 0) {
                System.out.println("There are minus element. The conversion cannot be done.");
                return -1;
            } else {
                number += (int) Math.pow(10, totalNodeSize - 1) * deleteLastNode();
            }
        }
        return number;
    }

    public void printNode() {
        if (headNode == null) {
            System.out.println("This is empty node.");
        } else {
            Node currentNode = headNode;
            do {
                System.out.printf("%d ", currentNode.data);
                currentNode = currentNode.next;
            } while (currentNode != headNode); // Check the current node pointer whether it returns back to the first
            // node.
        }
    }
}
