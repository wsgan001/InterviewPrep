package org.practice.linkedlist;

import java.util.Map;
import java.util.HashMap;


public class LinkedListClone {
    Node head;

    public LinkedListClone(Node node) {
        this.head = node;

    }
    public static class Node {
        private int data;
        private Node next, random;
        //Node constructor
        public Node(int data)
        {
            this.data = data;
            this.next = this.random = null;
        }
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = this.head;
        this.head = node;

    }

    public void print() {
        Node temp = head;
        while (temp != null)
        {
            Node random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = "+ randomData);
            temp = temp.next;
        }

    }

   //Using Hashmap
    public LinkedListClone cloneList() {
        Node origCurr = this.head, cloneCurr = null;

        Map<Node, Node> map = new HashMap<Node, Node>();

        while(origCurr != null) {
            cloneCurr = new Node(origCurr.data);
            map.put(origCurr, cloneCurr);
            origCurr = origCurr.next;
        }

        origCurr = this.head;


        while(origCurr != null) {
            cloneCurr = map.get(origCurr);
            cloneCurr.next = map.get(origCurr.next);
            cloneCurr.random = map.get(origCurr.random);
            origCurr = origCurr.next;
        }
        return new LinkedListClone(map.get(this.head));
    }

    //Without using hashmap
    public LinkedListClone clone() {
        Node origCurr = this.head, cloneCurr = null;

        // copy every node and insert to list
        while(origCurr != null) {
            cloneCurr = new Node(origCurr.data);
            cloneCurr.next = origCurr.next;
            origCurr.next = cloneCurr;
            origCurr = cloneCurr.next;
        }

        // copy random pointer for each new node
        origCurr = head;
        while(origCurr != null) {
            if(origCurr.random != null) {
                origCurr.next.random = origCurr.random.next;
            }
            origCurr = origCurr.next.next;
        }

        // break list to two
        origCurr = head;
        Node newHead = head.next;
        while(origCurr != null) {
            cloneCurr =  origCurr.next;
            origCurr.next = cloneCurr.next;

            if(cloneCurr.next != null)
            cloneCurr.next = cloneCurr.next.next;

            origCurr = origCurr.next;
        }
        return new LinkedListClone(newHead);
    }

    public static void main(String args[]) {
        LinkedListClone list = new LinkedListClone(new Node(5));
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        // Making a clone of the original linked list.
        //LinkedListClone clone = list.cloneList();
        LinkedListClone clone = list.clone();


        // Print the original and cloned linked list.
        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();

    }
}
