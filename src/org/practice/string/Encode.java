package org.practice.string;//Given an input string, write a function that returns the Run Length Encoded string for the input string.
//For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.

public class Encode {
    public static void encode(String src){
        StringBuffer dest = new StringBuffer();
        for(int i=0; i<src.length(); i++){
           int rlen = 1;
           while(i+1 < src.length() && src.charAt(i) == src.charAt(i+1)) {
               rlen++;
               i++;
           }
           dest.append(src.charAt(i));
           dest.append(rlen);
        }
        System.out.println(dest.toString());
    }
    public static void main(String args[]){
        encode("geeksforgeeks");
    }
}
