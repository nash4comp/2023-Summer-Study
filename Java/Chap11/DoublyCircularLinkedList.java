package Chap11;

class Node {
    Node prev;
    Node next;
    int data;

    public Node(int data) {
        this.prev = null;
        this.next = null;
        this.data = data;
    }
}

public class DoublyCircularLinkedList {
    private Node headNode;
    private Node tailNode;
    
    public void insertFirstNode(int data) {
        Node newNode = new Node(data);

        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            headNode.prev = tailNode;
            tailNode.next = headNode;
        } else {
            newNode.next = headNode;
            newNode.prev = tailNode;
            tailNode.next = newNode;
            headNode = newNode;
        }
    }

    public void insertLastNode(int data) {
        Node newNode = new Node(data);

        if(headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            headNode.prev = tailNode;
            tailNode.next = headNode;
        } else {
            newNode.prev = tailNode;
            newNode.next = headNode;
            tailNode.next = newNode;
            tailNode = newNode;
        }
    }

    public void deleteFirstNode() {
        if(headNode == null) {
            System.out.println("This is empty list.");
            return;
        }

        headNode = headNode.next;
        headNode.prev = tailNode;
        tailNode.next = headNode;
    }

    public void deleteLastNode() {
        if(headNode == null) {
            System.out.println("This is empty list.");
            return;
        }

        tailNode = tailNode.prev;
        tailNode.next = headNode;
        headNode.prev = tailNode;
    }

    public void printList() {
        Node tempNode = headNode;
        do {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        } while (tempNode != tailNode);
        System.out.println();
    }

}
