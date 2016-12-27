package org.practice.tree;

import java.util.*;
import java.util.Map.Entry;

//Amazon Interview Question
//Print bottom view of the tree
public class BottomView {
    TreeNode root;

    BottomView(TreeNode root) {
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

    public void bottomView() {
        if(root == null) {
            return;
        }
        int hd = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        Queue<TreeNode> q= new LinkedList<TreeNode>();
        root.hd = hd;
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode temp = q.remove();

            hd = temp.hd;
            map.put(hd, temp.data);

            if(temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        for(Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getValue()+" ");
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        BottomView ob = new BottomView(root);
        System.out.println("Following are nodes in bottom view of Binary Tree");
        ob.bottomView();

    }
}
