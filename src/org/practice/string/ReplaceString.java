package org.practice.string;

//String: Replace space with %20
public class ReplaceString {
    public static char[] replace(char []str){
        int len = str.length, spaceCount =0;
        for(int i=0;i<len;i++){
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        int newLen = len+spaceCount*2;
        char[] dest = new char[newLen+1];
        dest[newLen--]='\0';
        for(int i=len-1; i>=0;i--){
            if(str[i] == ' '){
                dest[newLen--] = '0';
                dest[newLen--] = '2';
                dest[newLen--] = '%';
            } else {
                dest[newLen--] = str[i];
            }
        }
        return dest;
    }
    public static void main(String args[]){
        System.out.println(replace(("the dog").toCharArray()));
    }
}
