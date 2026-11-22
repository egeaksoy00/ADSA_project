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

    /*
 Recursively search for a value
 Return the matching node, or null if it does not exist
 */
private Node search(Node node, int value) {
    if (node == null || node.value == value) {
        return node;
    }

    if (value < node.value) {
        return search(node.left, value);
    }

    return search(node.right, value);
}

// Return true if the value exists in the tree
public boolean valueSearch(int value)
{
    if(search(root, value) != null)
    {
        return true;
    }
    else
        return false;

}
/*
  Return the total number of nodes
 */
public int displayNodeNum() {
    return countNodes(root);
}

/*
  Count the current node and both subtrees recursively
 */
private int countNodes(Node node) {
    if (node == null) {
        return 0;
    }

    return 1 + countNodes(node.left) + countNodes(node.right);
}

/*
 Find the smallest node
 */
private Node findSmallest(Node node) {
    while (node.left != null) {
        node = node.left;
    }

    return node;
}

/*
 Find the largest node 
 */
private Node findLargest(Node node) {
    while (node.right != null) {
        node = node.right;
    }

    return node;
}

/*
 Display the smallest and largest values
 */
public void displayMinMax() {
    if (root == null) {
        System.out.println("The tree is empty.");
        return;
    }

    System.out.println("Smallest value: " + findSmallest(root).value);
    System.out.println("Largest value: " + findLargest(root).value);
}

/*
  Check whether the value exists before deleting it
  Update root because deleting the root may change it
 */
public void delete(int value) {
    if (search(root, value) == null) {
        System.out.println(value + " was not found. Nothing deleted.");
        return;
    }

    root = delete(root, value);
    System.out.println(value + " deleted successfully.");
}

/*
 Recursively delete a value while maintaining BST ordering
 For two children use the largest value in the left subtree
 */
private Node delete(Node node, int value) {
    if (node == null) {
        return null;
    }

    if (value < node.value) {
        node.left = delete(node.left, value);
    } else if (value > node.value) {
        node.right = delete(node.right, value);
    } else {
        // The node to delete has been found

        //No children
        if (node.left == null && node.right == null) {
            return null;
        }

        //Only a right child
        if (node.left == null) {
            return node.right;
        }

        //Only a left child
        if (node.right == null) {
            return node.left;
        }

        //Two children
        Node replacement = findLargest(node.left);

        // Copy the largest value from the left subtree
        node.value = replacement.value;

        // Delete its original node to avoid a duplicate
        node.left = delete(node.left, replacement.value);
    }

    return node;
}
}