package org.practice.tree;

import java.util.*;
// Do a level order traversal and print each level in new line

public class LevelOrderTraversal {
    public static void levelOrder(BinaryTreeNode root) {
        if(root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);

        while(true) {
            int node_count = queue.size();
            if(node_count == 0)
                break;

            while(node_count > 0) {
                BinaryTreeNode temp = queue.remove();
                System.out.print(temp.data+" ");

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null) {
                    queue.add(temp.right);
                }
                node_count--;
            }
            System.out.println();
        }

    }
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        levelOrder(root);
    }
}
