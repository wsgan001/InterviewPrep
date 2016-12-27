package org.practice.tree;

//Convert a sorted array to balanced BST
public class SortedArrayToBalancedBST {
    public static BinaryTreeNode sortedArrayToBST(int[] a, int low, int high) {
        //Base Case
        if(low > high) {
            return null;
        }

        int mid = (low+high)/2;
        BinaryTreeNode root = new BinaryTreeNode(a[mid]);
        root.left = sortedArrayToBST(a, low, mid-1);
        root.right = sortedArrayToBST(a, mid+1, high);
        return root;
    }

    public static void preOrder(BinaryTreeNode root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        BinaryTreeNode root = sortedArrayToBST(arr, 0, arr.length - 1);
        preOrder(root);
    }
}
