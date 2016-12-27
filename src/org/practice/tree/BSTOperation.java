package org.practice.tree;

// BST operattion
public class BSTOperation {
    Node root;
    private static Node prev = null;
    public static class Node {
        int data;
        Node left = null, right = null;
        public Node(int x) {
            data = x;
            left = right = null;

        }
    }

    public BSTOperation() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public Node insertRec(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }

        if(key < root.data) {
            root.left = insertRec(root.left, key);
        }
        else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public void deleteKey(int key) {
        root = deleteKeyRec(root, key);

    }

    public Node deleteKeyRec(Node root, int key) {
        /* Base Case: If the tree is empty */
        if(root == null) {
            return null;
        }

        /* Otherwise, recur down the tree */
        if(key < root.data) {
            root.left = deleteKeyRec(root.left, key);
        }
        else if(key > root.data) {
            root.right = deleteKeyRec(root.right, key);
        }
        // if key is same as root's key, then This is the node
        // to be deleted
        else {
            // node with only one child or no child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data  = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteKeyRec(root.right,root.data);
        }
        return root;

    }

    public int minValue(Node root){
       while(root.left != null) {
           root = root.left;
       }
       return root.data;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if(root != null) {
            inorderRec(root.left);
            System.out.println(root.data+" ");
            inorderRec(root.right);
        }
    }

    public boolean search(int key) {
       return searchRec(root, key);
    }

    public boolean searchRec(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(key < root.data) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public boolean isBST() {
        return isBSTUtil(root);
    }

    public boolean isBSTUtil(Node root) {
        if(root != null) {
            if(!isBSTUtil(root.left)) {
                return false;
            }

            if(prev != null && root.data <= prev.data) {
                return false;
            }
            prev = root;
            return isBSTUtil(root.right);
        }
        return true;
    }


    public static void main(String args[]) {
        BSTOperation tree = new BSTOperation();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("This tree is BST: "+tree.isBST());
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        /*System.out.println("\nSearch 70");
        System.out.println("Node with key 70 exists: "+tree.search(70));*/

    }
}
