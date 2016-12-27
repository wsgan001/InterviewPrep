package org.practice.tree;

import java.util.*;
/**
 * You are given a binary tree in which each node contains a value. Design an
 * algorithm to print all paths which sum to a given value. Note that a path can
 * start or end anywhere in the tree.
 *
 */
public class PathSum {
    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> getPaths() {
        return paths;
    }
    public static void pathSum(BinaryTreeNode root, int sum) {
        int currSum = 0;
        ArrayList<Integer> currPath = new ArrayList<Integer>();
        check(root, sum, currSum, currPath);
    }

    private static void check(BinaryTreeNode node, int sum, int currSum,
                       ArrayList<Integer> curPath) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) { //leaf node
            if(node.data + currSum == sum) {
                ArrayList<Integer> extPath = new ArrayList<Integer>(curPath);
                extPath.add(node.data);
                paths.add(extPath);
            }
        } else {
                int newSum = node.data + currSum;
                ArrayList<Integer> extPath = new ArrayList<Integer>(curPath);
                extPath.add(node.data);
                if(node.left != null) {
                    check(node.left, sum, newSum, extPath);
                }
                if(node.right != null) {
                    check(node.right, sum, newSum, extPath);
                }
            }

        }



    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(9);
        root.left.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(3);
        pathSum(root, 13);
        ArrayList<ArrayList<Integer>> pathLists = getPaths();
        for(ArrayList<Integer> path: pathLists) {
            for(Integer data: path) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
    }

}
