package org.practice.tree;

import java.util.Stack;

/**
 * @author kumari.singh
 */
public class SerializeDeserializeBinaryTree {

    public static String serialize(BinaryTreeNode root) {
        if(root==null)
            return null;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            BinaryTreeNode h = stack.pop();
            if(h!=null){
                sb.append(h.data+",");
                stack.push(h.right);
                stack.push(h.left);
            }else{
                sb.append("#,");
            }
        }

        return sb.toString().substring(0, sb.length()-1);
    }

    public static BinaryTreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }

        int[] t = {0};
        String[] arr = data.split(",");

        return helper(arr, t);
    }

    public static BinaryTreeNode helper(String[] arr, int[] t){
        if(arr[t[0]].equals("#")){
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(arr[t[0]]));

        t[0]=t[0]+1;
        root.left = helper(arr, t);
        t[0]=t[0]+1;
        root.right = helper(arr, t);

        return root;
    }




    public static void main(String ars[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        String s = serialize(root);
        System.out.println("Serialized binary tree is: "+s);
        System.out.println("DeSerialized binary tree is: ");
        LevelOrderTraversal.levelOrder(deserialize(s));
    }
}
