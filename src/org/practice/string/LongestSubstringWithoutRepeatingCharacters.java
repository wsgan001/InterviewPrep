package org.practice.string;

//Given a string, find the length of the longest substring without repeating characters.
//        Examples:
//        Given "abcabcbb", the answer is "abc", which the length is 3.//
//        Given "bbbbb", the answer is "b", with the length of 1.//
//        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

//NRCS- Non Repeating character substring
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        System.out.println(longestSubstring("abcabcbb"));
    }

    private static int longestSubstring(String s) {
        int[] visited = new int[256];
        int curr_len=1, max_len=1, prev_index;

        for(int i = 0; i < 256; i++) {
            visited[i] = -1;
        }

        /* Mark first character as visited by storing the index
       of first   character in visited array. */
        visited[s.charAt(0)] = 0;

        /* Start from the second character. First character is
       already processed (cur_len and max_len are initialized
       as 1, and visited[str[0]] is set */
        for(int i =1; i < s.length(); i++) {

            prev_index = visited[s.charAt(i)];

//            If the current character is not present in the
//            already processed substring or it is not part of
//            the current NRCS, then do cur_len++ */
            if (prev_index == -1 || i - curr_len > prev_index) {
                curr_len++;
            } else {
//                If the current character is present in currently
//                considered NRCS, then update NRCS to start from
//                the next character of previous instance.
                if(curr_len > max_len) {
                    max_len = curr_len;
                }
                curr_len = i - prev_index;
            }
            // update the index of current character
            visited[s.charAt(i)] = i;
        }

        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if (curr_len > max_len) {
            max_len = curr_len;
        }
        return  max_len;
    }
}
