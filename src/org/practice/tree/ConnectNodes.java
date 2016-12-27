package org.practice.tree;

//Connect nodes at the same level
public class ConnectNodes {
   private static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int key) {
            this.data = key;
            left = right = nextRight = null;
        }

    }

    private static Node getNextRight(Node p) {
        Node temp = p.nextRight;

        while(temp != null) {
            if(temp.left != null)
                return temp.left;
            if(temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }
        return  null;
    }

    public static void connect(Node p) {
        if(p == null) {
            return;
        }

        //set nextRight for root
        p.nextRight = null;

        // set nextRight of all levels one by one
        while(p != null) {
            Node q = p;
            while(q != null) {
                /* Connect all children nodes of p and children nodes of all other nodes at same level as p */
                if(q.left != null) {
                    if(q.right != null) {
                        q.left.nextRight = q.right;
                    } else {
                        q.left.nextRight = getNextRight(q);
                    }
                }

                if(q.right != null) {
                    q.right.nextRight = getNextRight(q);
                }

                // Set nextRight for other nodes in pre order fashion
                q = q.nextRight;
            }

            if(p.left != null) {
                p = p.left;
            } else if (p.right != null) {
                p = p.right;
            } else {
                p = getNextRight(p);
            }
        }

    }
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);
        connect(root);
        System.out.println("Following are populated nextRight pointers in the tree");

        int data = (root.nextRight != null)?root.nextRight.data:-1;
        System.out.println(root.data+"-->"+data);

        data = (root.left.nextRight != null)?root.left.nextRight.data:-1;
        System.out.println(root.left.data+"-->"+data);

        data = (root.right.nextRight != null)?root.right.nextRight.data:-1;
        System.out.println(root.right.data+"-->"+data);

        data = (root.left.left.nextRight != null)?root.left.left.nextRight.data:-1;
        System.out.println(root.left.left.data+"-->"+data);

        data = (root.left.right.nextRight != null)?root.left.right.nextRight.data:-1;
        System.out.println(root.left.right.data+"-->"+data);
    }
}
