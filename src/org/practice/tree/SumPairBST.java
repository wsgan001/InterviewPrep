package org.practice.tree;

import java.util.Stack;

//Find a pair with given sum in a Balanced BST
public class SumPairBST {
    public static boolean isPairPresent(BinaryTreeNode root, int target) {
        // Create two stacks. s1 is used for normal inorder traversal
        // and s2 is used for reverse inorder traversal
        Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();

        // done1, val1 and curr1 are used for normal inorder traversal using s1
        // done2, val2 and curr2 are used for reverse inorder traversal using s2
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        BinaryTreeNode curr1 = root, curr2 = root;

        // The loop will break when we either find a pair or one of the two
        // traversals is complete
        while(true)
        {
            while(done1 == false) {
                if(curr1 != null) {
                    s1.push(curr1);
                    curr1 = curr1.left;
                } else {
                    if(s1.isEmpty()) {
                        done1 = true;
                    } else {
                        curr1 = s1.pop();
                        val1 = curr1.data;
                        curr1 = curr1.right;
                        done1= true;
                    }
                }
            }

            while(done2 == false) {
                if(curr2 != null) {
                    s2.push(curr2);
                    curr2 = curr2.right;
                } else {
                    if(s2.isEmpty()) {
                        done2 = true;
                    } else {
                        curr2 = s2.pop();
                        val2 = curr2.data;
                        curr2 = curr2.left;
                        done2= true;
                    }
                }

            }

            if((val1 != val2) && (val1 + val2 == target)) {
                System.out.println("Pair found: "+val1+" + "+val2+ " = "+target);
                return true;
            }
            else if(val1+val2 < target) {
                done1 = false;
            }

            else if(val1+val2 > target) {
                done2 = false;
            }

            if(val1 >= val2) {
                return false;
            }
        }


    }
    public static void main(String args[]) {
        /*
                   15
                /     \
              10      20
             / \     /  \
            8  12   16  25    */
        BinaryTreeNode root = new BinaryTreeNode(15);
        root.left = new BinaryTreeNode(10);
        root.right = new BinaryTreeNode(20);
        root.left.left = new BinaryTreeNode(8);
        root.left.right = new BinaryTreeNode(12);
        root.right.left = new BinaryTreeNode(16);
        root.right.right = new BinaryTreeNode(25);
        if(isPairPresent(root, 33) == false) {
            System.out.println("No such pair found");
        }

    }
}
