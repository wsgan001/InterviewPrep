package org.practice.numbers;

//Validate a string to check if it is a number or not
public class ValidateNumber {
    public static boolean validateString(String s) {
        int len = s.length();
        if(len == 0) {
            return false;
        }
        int dotCount = 0;
        for(int i =0; i<len;i++) {
            char c = s.charAt(i);
            if(c < '0' || c > '9') {
                if(i == len-1)
                    return false;
                else if(c == '.') {
                    if(++dotCount > 1)
                        return false;
                } else if (i > 0 || c != '+' && c != '-')
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        System.out.println(validateString("-104.6"));
    }
}
