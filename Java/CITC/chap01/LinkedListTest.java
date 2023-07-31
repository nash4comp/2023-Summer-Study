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

    public int deleteFirstNode() {
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

    public boolean isPalindrome() {
        while (totalNodeSize > 1) {
            if (deleteFirstNode() != deleteLastNode()) {
                return false;
            }
        }
        return true;
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
        System.out.println();
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
        myLinkedList.insertFirstNode(0);
        myLinkedList.insertFirstNode(1);
        myLinkedList.printNode();
    }

}