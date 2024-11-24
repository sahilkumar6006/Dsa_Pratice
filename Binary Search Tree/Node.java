class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Main {
    
    public static Node construct(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }
        
        int mid = (low + high) / 2;
        Node node = new Node(arr[mid]);
        
        node.left = construct(arr, low, mid - 1);
        node.right = construct(arr, mid + 1, high);
        
        return node;
    }

    public static void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        
        Node root = construct(arr, 0, arr.length - 1);
        
        // Print the inorder traversal of the constructed BST
        System.out.println("Inorder Traversal of the constructed BST:");
        inorderTraversal(root);
    }
}