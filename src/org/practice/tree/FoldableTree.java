package org.practice.tree;

/* Amazon Interview Question
Write a function that accepts root of a binary tree and return true if it is foldable otherwise return false. A binary tree is foldable if left subtree of root is mirror image if right subtree.
        For example:
        Given tree,
        1
        2	3
        4 5 5	4
        6 6
        output: true
 */
public class FoldableTree {
    public static void mirror(BinaryTreeNode root) {
        if(root == null)
            return;
        else {
            BinaryTreeNode temp;
            mirror(root.left);
            mirror(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

    }
    private static boolean isFoldableUtil(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 ==  null) {
            return true;
        }

        if(root1 == null || root2 == null)
         return false;

        return isFoldableUtil(root1.left, root2.right) && isFoldableUtil(root1.right, root2.left);
    }


    public static boolean isFoldable(BinaryTreeNode root) {
        if(root == null) {
            return true;
        }
        return isFoldableUtil(root.left, root.right);

    }
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(4);
        root.left.left.left = new BinaryTreeNode(6);
        root.right.right.right = new BinaryTreeNode(6);
        System.out.println(isFoldable(root));
    }
}
