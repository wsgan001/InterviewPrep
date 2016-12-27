package org.practice.tree;

/**
 * Given two arrays which represent a sequence of keys. Imagine we make a Binary Search Tree (BST) from each array.
 * We need to tell whether two BSTs will be identical or not without actually constructing the tree.
 */

public class CheckForIdenticalBSTs {
    public static boolean isSameBST(int[] a, int[] b, int i1, int i2, int min, int max) {
        int j, k;
        int n = a.length;

         /* Search for a value satisfying the constraints of min and max in a[] and
          b[]. If the parent element is a leaf node then there must be some
          elements in a[] and b[] satisfying constraint.
          */
        for(j = i1; j<n;j++) {
            if(a[j]>min && a[j]<max)
                break;
        }

        for(k = i2; k<n;k++) {
            if(b[k]>min && b[k]<max)
                break;
        }

        /* If the parent element is leaf in both arrays */
        if(j == n && k == n)
            return true;

        /* Return false if any of the following is true
          a) If the parent element is leaf in one array, but non-leaf in other.
          b) The elements satisfying constraints are not same. We either search
             for left child or right child of the parent element (decinded by min
             and max values). The child found must be same in both arrays */
        if(((j == n)^(k==n)) || a[j] != b[k])
            return false;

         /* Make the current child as parent and recursively check for left and right
      subtrees of it. Note that we can also pass a[k] in place of a[j] as they
      are both are same */
        return isSameBST(a,b, j+1, k+1, a[j], max) &&  //right subtree
                isSameBST(a,b,j+1, k+1, min, a[j]); //left subtree
    }
    public static void main(String args[]) {
        int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
        int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
        System.out.println(isSameBST(a,b,0,0,Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
