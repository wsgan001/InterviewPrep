package org.practice.tree;

//Amazon Interview Question
//Convert DLL to BST in place
public class DLLToBST {
    static Node head;

    private static class Node {
        int data;
        Node prev;
        Node next;
        Node(int key) {
            data = key;
            prev = next = null;
        }
    }

    public static void push(int x) {
        Node node = new Node(x);
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    public static int countNodes(Node head) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void printlist(Node head) {
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static Node sortedListToBST() {
        int n = countNodes(head);
        return sortedListToBSTRecur(n);
    }

    public static Node sortedListToBSTRecur(int n) {
        //Base Case
        if(n <= 0)
            return null;

        /* Recursively construct the left subtree */
        Node left = sortedListToBSTRecur(n/2);

        //head now points to middle of the linked list. Make head as root
        Node root = head;
        root.prev = left;

        head = head.next;

         /* Recursively construct the right subtree and link it with root
        The number of nodes in right subtree  is total nodes - nodes in
        left subtree - 1 (for root) */
        root.next = sortedListToBSTRecur(n-n/2-1);
        return root;
    }

    public static void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data+" ");
            preOrder(root.prev);
            preOrder(root.next);
        }
    }

    public static void main(String args[]) {
        head = new Node(7);
        push(6);
        push(5);
        push(4);
        push(3);
        push(2);
        push(1);
        printlist(head);
        System.out.println();
        Node root = sortedListToBST();
        preOrder(root);
    }
}
