package org.practice.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by priyasingh on 10/24/15.
 */
public class MergeSortedArray {
    public static void main(String args[] ) throws Exception {
            /*
             * Read input from stdin and provide input before running   */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());
        int[] a = new int[N1];

        N1=0;
        for(String str : br.readLine().split(" ")){
            a[N1++] = Integer.parseInt(str);
        }

        int N2 = Integer.parseInt(br.readLine());
        int[] b = new int[N2];

        N2=0;
        for(String str : br.readLine().split(" ")){
            b[N2++] = Integer.parseInt(str);
        }

        int[] answer = new int[a.length + b.length];
        int i = a.length - 1, j = b.length - 1, k = answer.length;
        while (k > 0)
            answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
        for(int num: answer){
            System.out.print(num+" ");
        }



    }
}