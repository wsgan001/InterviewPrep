package org.practice.javaFundas.miscellaneous;

import java.util.*;
//Print all combination of product attributes
public class ProductCombinations {
    public static List<ArrayList<String>> getCombinations(List<ArrayList<String>> in, List<ArrayList<String>> out, int high) {
            if(in == null) {
                throw new NullPointerException();
            }

            //Base Case
            if(high >= in.size()) {
                return out;
            }

        ArrayList<String> list2 = in.get(high);

        //for first call when out list contains no element
        if(out.size() == 0) {
            ArrayList<String> list1 = in.get(0);
            for(int i=0; i<list1.size(); i++) {
                for(int j =0; j<list2.size();j++) {
                    ArrayList<String>  res = new ArrayList<String>();
                    res.add(list1.get(i));
                    res.add(list2.get(j));
                    out.add(res);
                }
            }
        } else {
            int k = list2.size();
            for(int i =0; i <out.size(); i=i+k) {
                ArrayList<String> res = out.get(i);
                out.remove(i);
                for(int j =0; j<list2.size();j++) {
                    ArrayList<String> res1 = new ArrayList<String>(res);
                    res1.add(list2.get(j));
                    out.add(i+j, res1);
                }
            }
        }
        out = getCombinations(in, out, high+1);
        return out;
    }

    public static void main(String args[]) {
        List<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("R");
        colors.add("G");
        colors.add("B");

        ArrayList<String> size = new ArrayList<String>();
        size.add("S");
        size.add("M");
        size.add("L");
        size.add("XL");

        ArrayList<String> Pattern = new ArrayList<String>();
        Pattern.add("Plain");
        Pattern.add("Checked");
        input.add(colors);
        input.add(size);
        input.add(Pattern);

        List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        res = getCombinations(input, res, 1);
        System.out.println("All combination of products are: ");
        for(ArrayList<String> lis: res) {
            for(String s: lis) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
