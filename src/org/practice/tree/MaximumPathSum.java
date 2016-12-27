package org.practice.tree;

//Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
//The maximum sum path may or may not go through root
//Time Complexity: O(n)
public class MaximumPathSum {
    private static int res = Integer.MIN_VALUE;

    public static int maxPathSum(BinaryTreeNode root)
    {
        int current=maxPathSumUtil(root);
        return Math.max(res,current);
    }

    // A utility function to find the maximum sum between any
    // two leaves.This function calculates two values:
    // 1) Maximum path sum between two leaves which is stored
    //    in res.
    // 2) The maximum root to leaf path sum which is returned.
    // If one side of root is empty, then it returns INT_MIN

    public static int maxPathSumUtil(BinaryTreeNode root)
    {
        // Base cases
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;

        // Find maximum sum in left and right subtree. Also
        // find maximum root to leaf sums in left and right
        // subtrees and store them in ls and rs
        int ls = maxPathSumUtil(root.left);
        int rs = maxPathSumUtil(root.right);

        // If both left and right children exist
        if (root.left != null && root.right != null)
        {
            // Update result if needed
            res = Math.max(res, ls + rs + root.data);

            // Return maxium possible value for root being
            // on one side
            return Math.max(ls, rs) + root.data;
        }

        // If any of the two children is empty, return
        // root sum for root being on one side

        return (root.left == null) ? rs + root.data : ls + root.data;
    }

    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(-15);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(-8);
        root.left.right = new BinaryTreeNode(1);
        root.left.left.left = new BinaryTreeNode(2);
        root.left.left.right = new BinaryTreeNode(6);
        root.right.left = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(9);
        root.right.right.right= new BinaryTreeNode(0);
        root.right.right.right.left= new BinaryTreeNode(4);
        root.right.right.right.right= new BinaryTreeNode(-1);
        root.right.right.right.right.left= new BinaryTreeNode(10);
        System.out.println(maxPathSum(root));
    }
}
