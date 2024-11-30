import java.util.*;

public class BST {

    public static class Node {  // Make Node static
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert method
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (root.data > val) {
            // Left subtree
            root.left = insert(root.left, val);
        } else {
            // Right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // In-order Traversal
    public static void inOrder(Node root) {
        if (root == null) return;  // Handle null root
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Search method
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        
        // Inserting nodes into BST
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // In-order Traversal
        System.out.println("In-order Traversal:");
        inOrder(root);
        System.out.println();  // Print new line for better output formatting

        // Search for a key (e.g., 4)
        int key = 4;
        System.out.println("Search result for " + key + ": " + search(root, key));
    }
}
