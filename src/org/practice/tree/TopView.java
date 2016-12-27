package org.practice.tree;

import java.util.*;

/*Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)
  A node x is there in output if x is the topmost node at its horizontal distance.

   1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7
*/

public class TopView {
    TreeNode root;

    TopView(TreeNode root) {
        this.root = root;
    }

    private static class TreeNode {
        int data;
        int hd;
        TreeNode left, right;

        TreeNode(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public void printTopView() {
        if(root == null) {
            return;
        }

        //Create an empty hashset
        HashSet<Integer> set = new HashSet<Integer>();

        //Create a queue and add root to it
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        root.hd = 0;
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode temp = q.remove();
            int hd = temp.hd;

            // If this is the first node at its horizontal distance,
            // then this node is in top view
            if(!set.contains(hd)) {
                set.add(hd);
                System.out.print(temp.data+" ");
            }

            if(temp.left != null) {
                temp.left.hd = hd-1;
                q.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = hd+1;
                q.add(temp.right);
            }
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        TopView t = new TopView(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();
    }
}
