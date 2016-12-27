package org.practice.string;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by priyasingh on 6/13/15.
 */

public class ReverseStringWordByWord {

    public static void main(String args[]){
        String input = "the house is blue";

        //first approach using StringBuilder --start
        StringBuilder sb = new StringBuilder(input.length());
        String words[]=input.split(" ");
        for(int i=words.length-1; i>=0;i--){
            sb.append(words[i]).append(' ');
        }

        System.out.println(sb.toString());
        //first approach --end

        //second approach using deque and StringBuilder --start
        /*Deque<String> words = new ArrayDeque<String>();
        for(String word: input.split(" ")){
            if(!word.isEmpty()){
                words.addFirst(word);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!words.isEmpty()){
            result.append(words.removeFirst());
            if(!words.isEmpty()){
                result.append(' ');
            }
        }
        System.out.println(result.toString());*/
        //second approach --end

    }
}
