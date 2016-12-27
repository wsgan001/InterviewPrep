package org.practice.tree;

/**
 * Created by priyasingh on 10/21/15.
 */
public class BinaryTree2DoublyLinkedList {
   public static BinaryTreeNode convert2DLLUtils(BinaryTreeNode root){
       if(root == null) {
           return null;
       }

       //If left subtree exists, process the left subtree
       //Recursively convert the left subtree to DLL.
       //Then find inorder predecessor of root in left subtree (inorder predecessor is rightmost node in left subtree).
       // Make inorder predecessor as previous of root and root as next of inorder predecessor.
       if(root.left != null) {
           BinaryTreeNode leftTreeNode = convert2DLLUtils(root.left);
           while(leftTreeNode.right != null) {
               leftTreeNode = leftTreeNode.right;
           }
           leftTreeNode.right = root;
           root.left = leftTreeNode;
       }

       //If right subtree exists, process the right subtree
       //Recursively convert the right subtree to DLL.
       //Then find inorder successor of root in right subtree (inorder successor is leftmost node in right subtree).
       // Make inorder successor as next of root and root as prev of inorder successor.
       if(root.right != null) {
           BinaryTreeNode rightTreeNode = convert2DLLUtils(root.right);
           while(rightTreeNode.left != null) {
               rightTreeNode = rightTreeNode.left;
           }
           rightTreeNode.left = root;
           root.right= rightTreeNode;
       }
       return root;
   }

    public static BinaryTreeNode convert2DLL(BinaryTreeNode root){
        BinaryTreeNode head = convert2DLLUtils(root);
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }


    public static boolean isPresentInDLL(BinaryTreeNode head, BinaryTreeNode tail, int sum){
        while(head != tail){
            int curr = head.data + tail.data;
            if(curr == sum)
                return true;
            if(curr < sum)
                head = head.right;
            else
                tail = tail.left;
        }
        return false;
    }

    //Given a BST, write a function isTripletPresent() that returns true if there is a triplet in given BST
    // with sum equals to 0, otherwise returns false. Time Complexity: O(n*n)
    public static boolean isTripletPresent(BinaryTreeNode head){
        BinaryTreeNode tail = head;
        while(tail.right != null)
            tail = tail.right;
        while(head.right != tail && head.data <0){
            if(isPresentInDLL(head, tail, -1*head.data)) {
                return true;
            } else {
                head = head.right;
            }
        }
        return false;
    }

    public static void printList(BinaryTreeNode head){
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.right;
        }
    }
    public static void main(String args[]){
        BinaryTreeNode node = new BinaryTreeNode(6);
        node.left = new BinaryTreeNode(-13);
        node.right = new BinaryTreeNode(14);
        node.left.right = new BinaryTreeNode(-8);
        node.right.left = new BinaryTreeNode(13);
        node.right.left.left = new BinaryTreeNode(7);
        node.right.right = new BinaryTreeNode(15);

        BinaryTreeNode head = convert2DLL(node);
        printList(head);

        System.out.println(isTripletPresent(head));

    }

}
