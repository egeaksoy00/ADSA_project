/*
 Binary Search Tree implementation.
 Author: Ege Aksoy
 */
public class BST {

   
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root = null;

    /*
     Insert a value and update the  root
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /*
      Recursively insert a value 
      Reject duplicate values
     */
    private Node insert(Node node, int value) {
        if (node == null) {
            System.out.println(value + " inserted successfully.");
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            System.out.println("Duplicate value. Insertion rejected.");
        }

        return node;
    }

    /*
      Display the tree 
     */
    public void displayInorder() {
        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }

    /*
      Visit left subtree, current node, then right subtree
     */
    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }
}