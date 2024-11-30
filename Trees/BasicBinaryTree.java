import java.util.*;
public class BasicBinaryTree {
    
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    static class BinaryTree {
    static int idx =-1;

    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
        
    }


    public static void preorder(Node root){
        if(root == null) {
            return;
        }
        System.out.println(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void inorder(Node root){
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data + " ");
        inorder(root.right);

    }


    public static void postOrder(Node root){
        if(root == null) {
        return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + " ");
    }

 public static void levelorder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size(); // Number of nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currNode = q.poll();
                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            System.out.println(); // New line after each level
        }
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes +1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
        return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) +1 ;

        return myHeight;
    }


    public static int diameter(Node root){
        if (root == null) {
            return 0;
        }

        int idiam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left) + height(root.right) +1;

        return Math.max(diam3, Math.max((idiam1), diam2));
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // preorder(root);
        // inorder(root);
        // postOrder(root);
        // levelorder(root);
        System.out.println(sumOfNodes(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
    }
}
 