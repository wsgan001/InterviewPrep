package org.practice.linkedlist;

/**
 * Created by priyasingh on 9/10/15.
 */
public class LinkedListDemo {
    Node head;
    public LinkedListDemo(int val){
        head = new Node(val);
    }

    private void append(int val) {
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);

    }

    private void insert(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
    }

    private void print() {
        Node temp = head;
        while (temp.next != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }

    private void delete(int val){
        Node prev = null, curr = head;
        if(head.data == val){
            head = head.next;
            return;
        }

        while(curr != null && curr.data != val) {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null){
            System.out.println("No such node exists");
        }
        else {
            prev.next = curr.next;
        }

    }


    public static void main(String args[]){
        LinkedListDemo myList = new LinkedListDemo(1);
        myList.append(2);
        myList.append(3);
        myList.insert(4);
        myList.print();
        myList.delete(4);
        myList.print();
        myList.delete(5);
        myList.print();
    }
}
