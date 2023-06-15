package Chap11;

class TreeNode {
    TreeNode leftNode;
    TreeNode rightNode;
    int element;

    public TreeNode(int element) {
        this.element = element;
        this.leftNode = null;
        this.rightNode = null;
    }
}

public class TreeSetExercise {
    TreeNode rootNode;

    public TreeSetExercise() {
        rootNode = null;
    }

    public void insertNode(int element) {
        rootNode = insertRecursive(rootNode, element);
    }

    private TreeNode insertRecursive(TreeNode currentNode, int element) {
        if (currentNode == null) {
            return new TreeNode(element);
        }

        if (element < currentNode.element) {
            currentNode.leftNode = insertRecursive(currentNode.leftNode, element);
        } else if (element > currentNode.element) {
            currentNode.rightNode = insertRecursive(currentNode.rightNode, element);
        }
        return currentNode;
    }

    public static void main(String[] args) {
    }
}
