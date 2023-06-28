package Chap11;

public class TestLinkedList {
    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insertLastNode(1);
        list.insertLastNode(2);
        list.insertLastNode(3);
        list.insertLastNode(4);

        list.insertFirstNode(0);
        list.insertFirstNode(-1);
        list.insertFirstNode(-2);
        list.insertFirstNode(-3);

        list.deleteFirstNode();
        list.deleteFirstNode();
        list.deleteFirstNode();
        list.deleteLastNode();
        list.deleteLastNode();

        list.printList();
    }
}
