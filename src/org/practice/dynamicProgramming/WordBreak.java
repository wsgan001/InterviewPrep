package org.practice.dynamicProgramming;

/* Amazon interview experience , Microsoft Interview
****VVIP question **?
Given an input string and a dictionary of words,
find out if the input string can be segmented into a space-separated sequence of dictionary words.
 */

/*The key to solve this problem by using dynamic programming approach:

        Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
        Initial state t[0] == true
*/

public class WordBreak {
//    public static boolean wordBreak1(String s, String[] dict) {
//        boolean[] t = new boolean[s.length()+1];
//        t[0] = true; //set first to be true, why?
//        //Because we need initial state
//
//       // String result="";
//
//        for(int i=0; i<s.length(); i++){
//            //should continue from match position
//            if(!t[i])
//                continue;
//
//            for(String a: dict){
//                int len = a.length();
//                int end = i + len;
//                if(end > s.length())
//                    continue;
//
//                if(t[end]) continue;
//
//                if(s.substring(i, end).equals(a)){
//                    //result = result+s.substring(i, end)+" ";
//                    t[end] = true;
//                }
//            }
//        }
//        //System.out.println(result);
//        return t[s.length()];
//    }

    public static boolean wordBreak(String s) {
        if(s.length() == 0) {
            return true;
        }

        boolean wb[] = new boolean[s.length()+1];

        for(int i = 1; i <= s.length(); i++) {

            String prefix = s.substring(0,i);
            if(wb[i] == false && dictionaryContains(prefix)) {
                wb[i] = true;
            }

            if(wb[i] == true) {

                if(i == s.length()) {

                    return true;
                }

                for(int j = i+1; j <=s.length(); j++) {
                    prefix = s.substring(i, j);
                    if(wb[j] == false && dictionaryContains(prefix)) {
                        wb[j] = true;
                    }

                    if(j == s.length() && wb[j] == true) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static boolean dictionaryContains(String word)
    {
        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};

        for (int i = 0; i < dictionary.length; i++)
            if (dictionary[i].equals(word))
                return true;
        return false;
    }

    public static void main(String args[]) {
        System.out.println(wordBreak("ilikesamsung"));

//        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
//                "icecream","and","go","i","like","ice","cream"};
//
//        System.out.println(wordBreak1("ilikesamsung", dictionary));
    }
}
