package org.practice.string;

public class MissingNumber {

    public static void main(String[] args) {
        String str = "9899100101102103105";
        int startDigit = 0;
        boolean result;
        for (int i = 1; i<str.length()/2; i++) {
            result = identifyFUnction(str,0,i);
            if (result) {
                startDigit = i;
            }
        }
        findMissingNumber(str,startDigit);
    }

    public static void findMissingNumber(String str, int startDigit){

        int start = Integer.parseInt(str.substring(0, startDigit));
        int nextnumber1 = start + 1;
        int nextnumber2 = start + 2;

        if (str.substring(startDigit, str.length()).startsWith(String.valueOf(nextnumber1)) ) {
            findMissingNumber(str.substring(startDigit, str.length()), String.valueOf(nextnumber1).length());
        }

        else if (str.substring(startDigit, str.length()).startsWith(String.valueOf(nextnumber2)) ) {
            System.out.println("Missing number in the above sequence is " +nextnumber1);
        }


    }

    public static boolean identifyFUnction(String str, int beginIndex, int offSet) {

        int start = Integer.parseInt(str.substring(beginIndex, offSet));
        int nextnumber1 = start + 1;
        int nextnumber2 = start + 2;

        String str2 = str.substring(offSet, str.length());

        if (str2.startsWith(nextnumber1+"") || str2.startsWith(nextnumber2+"")) {
            return true;

        }
        else {
            return false;
        }

    }

}