package org.practice.tree;

/* Amazon Interview Question
Given a binary tree print it in inward spiral order i.e first print level 1, then level n, then level 2, then n-1 and so on.
        For Ex -
        1
        2	3
        4 5 6 7
        8 9 10 11 12 13 14 15

        Print- 1 15 14 13 12 11 10 9 8 2 3 7 6 5 4
 */

public class inwardSpiral {
    public static int height(BinaryTreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }

    public static void printLevel(BinaryTreeNode root, int level, int ltr) {
        if(root == null)
            return;

        if(level == 1) {
            System.out.print(root.data+" ");
        } else if(ltr == 1) {
            printLevel(root.left, level -1 , ltr);
            printLevel(root.right, level -1 , ltr);
        } else {
            printLevel(root.right, level -1 , ltr);
            printLevel(root.left, level -1 , ltr);
        }
    }

    public static void inwardSpiral(BinaryTreeNode root) {
        int h = height(root);
        int firstLevel = 1;
        int lastLevel = h;
        while(firstLevel < lastLevel) {
            printLevel(root, firstLevel, 1);
            printLevel(root, lastLevel, 0);
            firstLevel++;
            lastLevel--;
        }

    }
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.left.left.left = new BinaryTreeNode(8);
        root.left.left.right = new BinaryTreeNode(9);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(11);
        root.right.left.left = new BinaryTreeNode(12);
        root.right.left.right = new BinaryTreeNode(13);
        root.right.right.left = new BinaryTreeNode(14);
        root.right.right.right = new BinaryTreeNode(15);
        inwardSpiral(root);
    }
}
