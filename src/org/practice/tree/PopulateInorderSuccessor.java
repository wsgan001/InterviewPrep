package org.practice.tree;

/*Given a Binary Search Tree where each node has following structure, write a function to populate next pointer for all nodes.
The next pointer for every node should be set to point to inorder successor.
 */

//Time Complexity: O(n)
public class PopulateInorderSuccessor {
    // The first visited node will be the rightmost node
    // next of the rightmost node will be NULL
    private static Node next = null;
    private static class Node {
        int data;
        Node left;
        Node right;
        Node next;
        Node(int key) {
            data = key;
            left = right = next = null;
        }
    }
    public static void populateNext(Node p) {

        if(p != null) {
            // First set the next pointer in right subtree
            populateNext(p.right);

            // Set the next as previously visited node in reverse Inorder
            p.next = next;

            // Change the prev for subsequent node
            next = p;

            // Finally, set the next pointer in left subtree
            populateNext(p.left);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);
        populateNext(root);
        //System.out.println("next of 10 is "+root.next.data);
        //System.out.println("next of 8 is "+root.left.next.data);
        //System.out.println("next of 12 is "+root.right.next.data);
        System.out.println("next of 3 is "+root.left.left.next.data);
    }
}
