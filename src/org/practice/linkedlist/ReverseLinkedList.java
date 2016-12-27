package org.practice.linkedlist;

//reverse a linked list
public class ReverseLinkedList {
    Node head;

    ReverseLinkedList(int x) {
        Node node = new Node(x);
        this.head = node;
    }
    public void push(int x){
        Node node = new Node(x);
        node.next = this.head;
        this.head = node;
    }

    //iterative approach
    public void reverse() {
        Node prev = null, curr = this.head;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    public void recursiveReverse(Node head) {
        Node first = null, rest = null;
        if(head == null) {
            return;
        }

        first = head;
        rest = head.next;

        if(rest == null) {
            return;
        }

        this.head = rest;
        recursiveReverse(rest);
        first.next.next = first;
        first.next = null;
    }

    public void print() {
        Node curr = this.head;
        while (curr.next != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.print(curr.data);
        System.out.println();
    }


    public static void main(String args[]) {
        ReverseLinkedList ob = new ReverseLinkedList(6);
        ob.push(5);
        ob.push(4);
        ob.push(3);
        ob.push(2);
        ob.push(1);
        ob.print();
        //ob.reverse();
        ob.recursiveReverse(ob.head);
        ob.print();
    }
}
