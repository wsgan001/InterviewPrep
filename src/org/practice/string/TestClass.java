package org.practice.string;

//Input: Dhoni7 notout at183*runs in 145balls&hit15fours&ten6s!
//Output:
/*
7
183
145
15
6
*/

import java.io.*;

public class TestClass {
    public static boolean isInteger(char c)
    {
        if(c >=48 && c <=57)
            return true;
        return false;
    }
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

       /* line = line.replaceAll("[^-?0-9]+", " ");
        List<String> ls = Arrays.asList(line.trim().split(" "));
        for(String s: ls){
            System.out.println(s);
        }*/

        String Cyrillic = Integer.toHexString(131);

        final StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < line.length(); i++){
            final char c = line.charAt(i);
            if(isInteger(c)){
                if(flag == false)
                    sb.append(" ");
                sb.append(c);
                flag = true;
            }
            else {
                flag = false;
            }
        }
        String s[] = sb.toString().split(" ");
        for(String str: s){
            System.out.println(str);
        }

    }
}
