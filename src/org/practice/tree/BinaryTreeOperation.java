package org.practice.tree;

import java.util.*;

public class BinaryTreeOperation {
    private static int maxLevel;
    public static int height(BinaryTreeNode node) {
        if(node == null)
            return 0;
        return 1+ Math.max(height(node.left), height(node.right));
    }

    public static class HeightWrapper {
        private int height;
        HeightWrapper() {
            height =0;
        }
    }
    public static int findDiameter(BinaryTreeNode node) {
        //Below code time complexity : O(n*n) -- start
        /*if(node == null)
            return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        int lDiameter = findDiameter(node.left);
        int rDiameter = findDiameter(node.right);

        return Math.max(lh+rh+1, Math.max(lDiameter, rDiameter));*/
        //Above code time complexity : O(n) -- end

        //Below code time complexity : O(n) -- start
        HeightWrapper wrapper  = new HeightWrapper();
        return findDiameterUtil(node, wrapper);
        //Above code time complexity : O(n) -- end
    }

    public static int findDiameterUtil(BinaryTreeNode node, HeightWrapper wrapper) {
        if(node == null) {
            return 0;
        }

       /* wrappers for heights of the left and right subtrees */
        HeightWrapper lhWrapper = new HeightWrapper();
        HeightWrapper rhWrapper = new HeightWrapper();

        int lDiameter = findDiameterUtil(node.left, lhWrapper);
        int rDiameter = findDiameterUtil(node.right, rhWrapper);

        wrapper.height = Math.max(lhWrapper.height, rhWrapper.height) +1;
        return Math.max(lhWrapper.height + rhWrapper.height +1, Math.max(lDiameter, rDiameter));
    }
    public static void leftView(BinaryTreeNode node) {
        maxLevel = 0;
        leftViewUtil(node, 1);
        maxLevel = 0;
    }

    public static void leftViewUtil(BinaryTreeNode node, int level) {
       if(node == null){
           return;
       }
       if(maxLevel < level) {
           System.out.print(node.data + " ");
           maxLevel = level;
       }
       leftViewUtil(node.left, level+1);
       leftViewUtil(node.right, level+1);
    }

    public static void preOrder(BinaryTreeNode node) {
        if(node == null) {
            return;
        }

        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        while(true) {
            if(node == null) {
                if(st.empty()) return;
                node = st.pop();
            }
            System.out.print(node.data+ " ");

            if(node.right != null) {
                st.push(node.right);
            }
            node = node.left;
        }
    }

    public static void InOrder(BinaryTreeNode node) {
        if(node == null) {
            return;
        }

        boolean done = false;

        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        while(!done) {
            if(node != null) {
                st.push(node);
                node = node.left;
            } else {
                if(!st.isEmpty()) {
                    node = st.pop();
                    System.out.print(node.data+" ");
                    node = node.right;
                } else {
                    done = true;
                }
            }
        }
    }

    public static int kthSmallest(BinaryTreeNode node, int k) {
        if(node == null) {
            return -1;
        }

        Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
        while(true) {
            if(node != null) {
                st.push(node);
                node = node.left;
            } else {
                if(!st.isEmpty()) {
                    node = st.pop();
                    if(--k == 0)  {
                        return node.data;
                    }
                    node = node.right;
                } else {
                    return -1;
                }
            }
        }
    }

    public static boolean printAncestors(BinaryTreeNode root, int k) {
        if(root == null) {
            return false;
        }

        if(root.data == k) {
            return true;
        }

        if(printAncestors(root.left, k) ||
           printAncestors(root.right, k)) {
            System.out.print(root.data+" ");
            return true;
        }
        System.out.println();
        return false;
    }

    //Time Complexity: O(n)
    public static void printSpiral(BinaryTreeNode root) {
        if(root == null) {
            return ;
        }

        Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
        s1.push(root);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                BinaryTreeNode temp = s1.pop();
                System.out.print(temp.data+" ");

                if(temp.right != null) {
                    s2.push(temp.right);
                }

                if(temp.left != null) {
                    s2.push(temp.left);
                }

            }

            while(!s2.isEmpty()) {
                BinaryTreeNode temp = s2.pop();
                System.out.print(temp.data+" ");

                if(temp.left != null) {
                    s1.push(temp.left);
                }

                if(temp.right != null) {
                    s1.push(temp.right);
                }
            }
        }
    }


    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        System.out.println("Diameter is "+findDiameter(root));
        //leftView(root);
       // postOrder(root);
       // printAncestors(root, 4);
        //preOrder(root);
       // printSpiral(root);

        BinaryTreeNode BSTNode = new BinaryTreeNode(10);
        BSTNode.left = new BinaryTreeNode(2);
        BSTNode.right = new BinaryTreeNode(12);
        BSTNode.left.left = new BinaryTreeNode(1);
        BSTNode.left.right = new BinaryTreeNode(3);
        //System.out.println(kthSmallest(BSTNode , 3));
    }
}
