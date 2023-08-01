package CITC.chap01;

import java.util.*;

class NodeGeneric<E> {
    E data;
    NodeGeneric<E> previous;
    NodeGeneric<E> next;

    public NodeGeneric(E data) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}

class MyLinkedListGeneric<E> { // Circular doubly linked list
    private NodeGeneric<E> headNode; // The first located node
    private NodeGeneric<E> tailNode; // The last located node
    private int totalNodeSize;

    public MyLinkedListGeneric() {
        headNode = null;
        tailNode = null;
        totalNodeSize = 0;
    }

    public int getTotalNodeSize() {
        return totalNodeSize;
    }

    public E insertLastNode(E data) {
        NodeGeneric<E> newNode = new NodeGeneric<>(data);
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

    public E insertFirstNode(E data) {
        NodeGeneric<E> newNode = new NodeGeneric<>(data);
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

    public E deleteFirstNode() {
        E deletedData;
        if (headNode == null) {
            throw new NoSuchElementException();
        } else {
            deletedData = headNode.data;
            NodeGeneric<E> secondNode = headNode.next;
            tailNode.next = secondNode;
            secondNode.previous = tailNode;
            headNode = secondNode;
            totalNodeSize--;
        }

        return deletedData;
    }

    public E deleteLastNode() {
        E deletedData;
        if (headNode == null) {
            throw new NoSuchElementException();
        } else {
            deletedData = tailNode.data;
            NodeGeneric<E> lastSecondNode = tailNode.previous;
            lastSecondNode.next = headNode;
            headNode.previous = lastSecondNode;
            tailNode = lastSecondNode;
            totalNodeSize--;
        }
        return deletedData;
    }

    public void deleteDuplicates() {
        HashSet<E> set = new HashSet<>();
        NodeGeneric<E> currentNode = headNode;
        NodeGeneric<E> previousNode = null;
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

    // public int findKthToFirstElement(int k) {
    //     if (k > getTotalNodeSize() - 1) {
    //         throw new IndexOutOfBoundsException();
    //     }

    //     NodeGeneric currentNode = headNode;
    //     for (int i = 0; i < k; i++) {
    //         currentNode = currentNode.next;
    //     }
    //     return currentNode.data;
    // }

    // public int findKthToLastElement(int k) {
    //     if (k > getTotalNodeSize() - 1) {
    //         throw new IndexOutOfBoundsException();
    //     }
    //     NodeGeneric currentNode = tailNode;
    //     for (int i = 0; i < k; i++) {
    //         currentNode = currentNode.previous;
    //     }
    //     return currentNode.data;
    // }

    // public int extractNumber() {
    //     int number = 0;
    //     while (totalNodeSize > 0) {
    //         if (findKthToLastElement(0) < 0) {
    //             System.out.println("There are minus element. The conversion cannot be done.");
    //             return -1;
    //         } else {
    //             number += (int) Math.pow(10, totalNodeSize - 1) * deleteLastNode();
    //         }
    //     }
    //     return number;
    // }

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
            NodeGeneric<E> currentNode = headNode;
            do {
                System.out.print(currentNode.data);
                System.out.print(" ");
                currentNode = currentNode.next;
            } while (currentNode != headNode); // Check the current node pointer whether it returns back to the first
            // node.
        }
        System.out.println();
    }
}

public class LinkedListTestGeneric {
    // public static MyLinkedListGeneric addTwoNodesReverse(MyLinkedListGeneric firstList, MyLinkedListGeneric secondList) {
    //     int sum = firstList.extractNumber() + secondList.extractNumber();
    //     MyLinkedListGeneric resultNode = new MyLinkedListGeneric();
    //     int length = (int) Math.log10(sum) + 1;
    //     int digit = 0;
    //     int place = length;
    //     for (int i = 0; i < length; i++) {
    //         digit = sum / (int) Math.pow(10, place - 1);
    //         sum -= digit * (int) Math.pow(10, place - 1);
    //         resultNode.insertFirstNode(digit);
    //         place--;
    //     }
    //     return resultNode;
    // }

    public static void main(String[] args) {
        MyLinkedListGeneric<Integer> myLinkedList1 = new MyLinkedListGeneric<>();
        myLinkedList1.insertFirstNode(0);
        myLinkedList1.insertFirstNode(1);
        myLinkedList1.printNode();
        
        MyLinkedListGeneric<String> myLinkedList2 = new MyLinkedListGeneric<>();
        myLinkedList2.insertFirstNode("ABC");
        myLinkedList2.insertFirstNode("DEF");
        myLinkedList2.printNode();
    }

}