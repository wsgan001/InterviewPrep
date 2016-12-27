package org.practice.tree;

//Print all nodes at distance k from a given node
//Time Complexity: O(n)
public class KDistanceNode {

    //Time complexity: O(n)
    public static void  printkDistanceNodeDown(BinaryTreeNode root, int k) {
        // Base Case
        if (root == null || k < 0)  return;

        if (k==0) {
            System.out.println(root.data);
            return;
        }
        printkDistanceNodeDown(root.left, k - 1);
        printkDistanceNodeDown(root.right,k - 1);
    }

    public static int printkDistanceNode(BinaryTreeNode root, BinaryTreeNode target, int k) {
        // Base Case 1: If tree is empty, return -1
        if (root == null) return -1;

        // If target is same as root.  Use the downward function
        // to print all nodes at distance k in subtree rooted with
        // target or root
        if (root == target)
        {
            printkDistanceNodeDown(root, k);
            return 0;
        }

        // Recur for left subtree
        int dl = printkDistanceNode(root.left, target, k);

        // Check if target node was found in left subtree
        if (dl != -1)
        {
            // If root is at distance k from target, print root
            // Note that dl is Distance of root's left child from target
            if (dl + 1 == k)
                System.out.println(root.data);

                // Else go to right subtree and print all k-dl-2 distant nodes
                // Note that the right child is 2 edges away from left child
            else
                printkDistanceNodeDown(root.right, k - dl - 2);

            // Add 1 to the distance and return value for parent calls
            return 1 + dl;
        }

        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
        // Note that we reach here only when node was not found in left subtree
        int dr = printkDistanceNode(root.right, target, k);
        if (dr != -1)
        {
            if (dr + 1 == k)
                System.out.println(root.data);
            else
                printkDistanceNodeDown(root.left, k - dr - 2);
            return 1 + dr;
        }

        // If target was neither present in left nor in right subtree
        return -1;
    }
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(22);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(12);
        root.left.left.left = new BinaryTreeNode(10);
        root.left.left.right = new BinaryTreeNode(14);
        BinaryTreeNode target = root.left.left;
        printkDistanceNode(root, target, 3);
    }
}
