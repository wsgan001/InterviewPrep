package org.practice.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kumari.singh on 03/12/16.
 */
public class HackLandElection {

    static String winner(String[] votes) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String vote: votes) {
            list.add(vote);
            if(map.get(vote) != null) {
                map.put(vote, map.get(vote)+1);
            } else {
                map.put(vote, 1);
            }
        }


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)- map.get(o1);
            }
        });

        int count = map.get(list.get(0));
        List<String> list1 = new ArrayList<>();

        for(String s: list) {
            if(map.get(s) == count) {
                list1.add(s);
            }
        }


        Collections.sort(list1, Collections.reverseOrder());



        return list1.get(0);


    }

    public static void main(String args[]) {
      String[] votes = {"Victor","Farah", "Veronica", "Farah", "Alex", "Alex", "Veronica", "Alex"};
       System.out.println(winner(votes));

    }
}
