package org.practice.tree;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Map.Entry;

/* Amazon Interview question
Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

        1
        /    \
        2      3
        / \    / \
        4   5  6   7
        \   \
        8   9


        The output of print this tree vertically will be:
        4
        2
        1 5 6
        3 8
        7
        9
*/

public class VerticleView {
    TreeNode root;

    VerticleView(TreeNode root) {
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

    public static void getVerticleOrder(TreeNode root, int hd, TreeMap<Integer, ArrayList<Integer>> m) {
        if(root == null)
            return;


        if(m.get(hd) == null) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.data);
            // Store current node in map 'm'
            m.put(hd, list);
        } else {
            m.get(hd).add(root.data);
        }

        // Store nodes in left subtree
        getVerticleOrder(root.left, hd - 1, m);

        // Store nodes in right subtree
        getVerticleOrder(root.right, hd + 1, m);
    }

    public void verticleView(TreeNode root) {
        // Create a map and store vertical oder in map using
        // function getVerticalOrder()
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();

        int hd = 0;
        getVerticleOrder(root, hd, map);

        for(Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for(Integer x: entry.getValue()) {
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        VerticleView ob = new VerticleView(root);
        System.out.println("Following are nodes in verticle view of Binary Tree");
        ob.verticleView(root);
    }
}
