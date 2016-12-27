package org.practice.string;

/**
 * Created by priyasingh on 10/22/15.
 */
public class StringPermutation {
    public static void swap(StringBuffer sb, int pos1, int pos2) {
        char t = sb.charAt(pos1);
        sb.setCharAt(pos1, sb.charAt(pos2));
        sb.setCharAt(pos2, t);
    }
    public static void permute(StringBuffer s, int l , int r){
        int i;
        if(l == r){
            System.out.println(s.toString());
        } else {
            for(i=l; i<=r; i++){
                swap(s, l, i);
                permute(s, l+1, r);
                swap(s, l, i);
            }
        }

    }
    public static void main(String args[]){
        permute(new StringBuffer("ABC"), 0, 2);
    }
}
