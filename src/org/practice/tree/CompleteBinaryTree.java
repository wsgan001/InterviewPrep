package org.practice.tree;

import java.util.LinkedList;
import java.util.Queue;


/* Given a binary tree, return true if the tree is complete
   else false */
public class CompleteBinaryTree {
    public static boolean isComplete(BinaryTreeNode root) {
        // Base Case: An empty tree is complete Binary Tree
        if (root == null)
            return true;

        //create a queue
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);


        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;

        //Do level order traversal using queue
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();

            if(node.left != null) {
                // If we have seen a non full node, and we see a node
                // with non-empty left child, then the given tree is not
                // a complete Binary Tree
                if(flag == true) {
                    return false;
                }
                queue.add(node.left);

            } else {
                flag = true; // If this a non-full node, set the flag as true
            }

            if(node.right != null) {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true) {
                   return false;
                }
                queue.add(node.right);

            } else {
                flag = true; // If this a non-full node, set the flag as true
            }
        }
        return true;
    }
    public static void main(String args[])  {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
        System.out.println("Tree is complete Binary Tree: "+isComplete(root));
    }
}
