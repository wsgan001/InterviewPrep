package org.practice.linkedlist;

//Given a linked list, write a function to reverse every k nodes
public class ReverseGroup {
    Node head;

    ReverseGroup(int x) {
        Node node = new Node(x);
        this.head = node;
    }
    public void push(int x){
        Node node = new Node(x);
        node.next = this.head;
        this.head = node;
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

    public static Node reverse(Node head, int k) {
        Node current = head, prev = null, next = null;
        int count = 0;

        /*reverse first k nodes of the linked list */
        while(current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        //next is now a pointer to (n+1)th node.
        if(next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

    public static void main(String args[]) {
        ReverseGroup ob = new ReverseGroup(6);
        ob.push(5);
        ob.push(4);
        ob.push(3);
        ob.push(2);
        ob.push(1);
        ob.print();
        ob.head = ob.reverse(ob.head, 3);
        ob.print();
    }
}
