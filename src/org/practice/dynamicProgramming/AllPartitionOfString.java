package org.practice.dynamicProgramming;

// A recursive program to print all possible partitions of a given string
// into dictionary words

/* A utility function to check whether a word is present in dictionary or not.
  An array of strings is used for dictionary.  Using array of strings for
  dictionary is definitely not a good idea. We have used for simplicity of
  the program*/
public class AllPartitionOfString {
    public static boolean dictionaryContains (String word)
    {
        String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","love","ice","cream", "like"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++)
            if (dictionary[i].equals(word))
                return true;
        return false;
    }

    public static void wordBreak(String str) {
        wordBreakUtil(str, str.length(), "");

    }

    public static void wordBreakUtil(String str, int size, String result) {
        for(int i =1; i <= size; i++) {
            String prefix = str.substring(0,i);

            if(dictionaryContains(prefix)) {
                if(i == size) {
                    result += prefix;
                    System.out.println(result);
                    return;
                }

                wordBreakUtil(str.substring(i, size), size-i, result+prefix+" ");

            }
        }

    }

    public static void main(String args[]) {

       wordBreak("ilikesamsung");
    }
}
