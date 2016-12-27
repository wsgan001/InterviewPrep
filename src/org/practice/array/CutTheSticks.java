package org.practice.array;//https://www.hackerrank.com/challenges/cut-the-sticks
//Given a set of length of N sticks, a cut operation is performed such that
// each rod is cut by the minimum in that set in every step.
// Repeat the same till no rods are left and output the number of rods cut in each step.
import java.util.*;
import java.io.*;
public class CutTheSticks {
    public static void main(String args[])throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        N=0;
        for(String str : br.readLine().split(" ")){
            a[N++] = Integer.parseInt(str);
        }

        Arrays.sort(a);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;) {
            sb.append((N-i)+"\n");
            while(++i < N && a[i-1] == a[i]) {}
        }
        System.out.println(sb);
    }
}
