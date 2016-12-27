package org.practice.tree;

//Given a binary tree, check whether it is a mirror of itself.
public class SymmetricTree {
    public static boolean isSymmteric(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 ==  null) {
            return true;
        }

        if(root1 != null && root2 !=null && root1.data == root2.data) {
            return isMirror(root1.left, root2.right) &&
                    isMirror(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String args[]){
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(3);
        System.out.println(isSymmteric(root));
    }
}
