package CITC.chap04;

public class MyBinarySearchTree {
    public static final String IN_ORDER_TRAVERSE = "inorder";
    public static final String PRE_ORDER_TRAVERSE = "preorder";
    public static final String POST_ORDER_TRAVERSE = "postorder";

    private class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node getLeftNode() {
            return leftChild;
        }

        public void setLeftNode(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightNode() {
            return rightChild;
        }

        public void setRightNode(Node rightChild) {
            this.rightChild = rightChild;
        }

        public int getData() {
            return data;
        }
    }

    private Node root;
    private int nodeCounter = 0;

    public boolean search(int data) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return true;
            } else if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        return false;
    }

    public boolean addData(int data) {
        Node newNode = new Node(data);

        if (search(data)) {
            return false;
        }

        if (root == null) {
            root = newNode;
            nodeCounter++;
            return true;
        }

        Node currentNode = root;
        Node parentNode;

        while (true) {
            parentNode = currentNode;
            if (data < currentNode.getData()) {
                currentNode = currentNode.getLeftNode();
                if (currentNode == null) {
                    parentNode.setLeftNode(newNode);
                    nodeCounter++;
                    return true;
                }
            } else if (data > currentNode.getData()) {
                currentNode = currentNode.getRightNode();
                if (currentNode == null) {
                    parentNode.setRightNode(newNode);
                    nodeCounter++;
                    return true;
                }
            }
        }

    }

    // A
    // B C
    // in-order: B A C
    // pre-order: A B C
    // post-order: B C A

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeftNode());
        System.out.printf("%d ", node.getData());
        inOrderTraversal(node.getRightNode());

    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.printf("%d ", node.getData());
        preOrderTraversal(node.getRightNode());
        preOrderTraversal(node.getLeftNode());

    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.getLeftNode());
        postOrderTraversal(node.getRightNode());
        System.out.printf("%d ", node.getData());

    }

    public int getNodeCounter() {
        return nodeCounter;
    }

    public void printNode(String mode) {
        switch (mode) {
            case PRE_ORDER_TRAVERSE:
                preOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
            case POST_ORDER_TRAVERSE:
                postOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
            case IN_ORDER_TRAVERSE:
            default:
                inOrderTraversal(root);
                System.out.println("\n" + getNodeCounter());
                break;
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree myBST = new MyBinarySearchTree();
        int[] data = { 25, 15, 10, 4, 12, 22, 18, 24, 31, 35, 44, 50, 70, 66, 90 };

        for (int value : data) {
            myBST.addData(value);
        }

        System.out.println(IN_ORDER_TRAVERSE);
        myBST.printNode(IN_ORDER_TRAVERSE);
        System.out.println();
        System.out.println(PRE_ORDER_TRAVERSE);
        myBST.printNode(PRE_ORDER_TRAVERSE);
        System.out.println();
        System.out.println(POST_ORDER_TRAVERSE);
        myBST.printNode(POST_ORDER_TRAVERSE);
    }

}
