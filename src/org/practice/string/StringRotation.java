package org.practice.string;

import java.io.*;
public class StringRotation {
    public static void main(String args[])throws Exception{
        String str1 = "aacd", str2 ="aadc";
        StringBuilder str3 = new StringBuilder();
        str3.append(str1).append(str1);
        str3.substring(0);
        if(str3.indexOf(str2) != -1){
            System.out.println("Rotation of each other");
        }
        else{
            System.out.println("Not Rotation of each other");
        }
    }
}