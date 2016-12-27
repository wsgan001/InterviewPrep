package org.practice.string;

/**
 * Created by kumari.singh on 28/09/16.
 */
//Uber Interview question
/* You need to write a ransom note by cutting letters out of the available
     * magazines and pasting them together to form a letter. Given an arbitrary
     * ransom note string and another string containing all the contents of all
     * the magazines, write a function that will return true if the ransom
     * note can be made from the magazines; otherwise, it will return false.
     * Every letter found in the magazine string can only be used once in your
     * ransom note.
     */

public class RansomNote {

    public static void main(String[] args) {
//        if(args.length < 2) {
//            System.out.println("You need to enter a ransom note and the " +
//                    "contents of the magazines both in quotes.");
//            System.exit(1);
//        }

        String note = "Need 100 rs";//args[0];
        String mag = "aeedawN 1r00 s";

        System.out.println("Ransom note: " + note);
        System.out.println("Magazine contents: " + mag);
        System.out.println("Can construct ransom note from mag contents?");
        System.out.println(canMakeRansomNote(note, mag));
    }

    public static boolean canMakeRansomNote(String note, String mag) {
        int[] count = new int[256];
        int n=0;
        int m =0;

        while(n < note.length()) {
            int nchar = note.charAt(n);

            if(count[nchar] > 0) {
                count[nchar]--;
                n++;
            } else {

                while(m < mag.length() && mag.charAt(m) != nchar) {
                    count[mag.charAt(m)]++;
                    m++;
                }

                if(m >= mag.length()) {
                    return false;
                }

                m++;
                n++;
            }
        }
        return true;
    }
}



