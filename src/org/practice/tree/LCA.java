package org.practice.tree;

//lowest common ancestor in BinaryTreeNode
public class LCA {
    private static boolean v1;
    private static boolean v2;

    private static boolean find(BinaryTreeNode node, int n) {
        if(node == null)
            return false;

        if(node.data == n || find(node.left, n) || find(node.right, n))
            return true;

        return false;
    }

    public static BinaryTreeNode findLCAUtil(BinaryTreeNode node, int n1, int n2) {
        if(node == null){
            return null;
        }

        if(node.data == n1) {
            v1 = true;
            return node;
        }

        if(node.data == n2) {
            v2 = true;
            return node;
        }

        BinaryTreeNode left_lca = findLCAUtil(node.left, n1, n2);
        BinaryTreeNode right_lca = findLCAUtil(node.right, n1, n2);

        if(left_lca != null && right_lca != null)
            return node;

        return (left_lca != null)?left_lca:right_lca;
    }

    public static int findLCA(BinaryTreeNode node, int n1, int n2) {
        v1 = false ;
        v2 = false;

        BinaryTreeNode lca = findLCAUtil(node, n1, n2);
        if(v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1)) {
            return lca.data;
        }
        return -1;
    }
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.left = new BinaryTreeNode(6);
        System.out.println("LCA = "+findLCA(root, 4, 6));
    }
}
