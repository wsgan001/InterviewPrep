package org.practice.array;

//A majority element in an array A[] of size n is an element that appears more than n/2 times
public class MajorityElement {
    public static void printMajority(int[] a) {
        int cand = findMajority(a);
        if(isMajority(a, cand)) {
            System.out.println(cand);
        } else {
            System.out.println("No majority element");
        }
    }

    private static int findMajority(int[] a) {
        int maj_index = 0, count = 1;
        for(int i =1; i<a.length;i++){
            if(a[i] == a[maj_index])
                count++;
            else
                count--;
            if(count == 0){
                maj_index = i;
                count =1;
            }
        }
        return a[maj_index];
    }

    private static boolean isMajority(int[] a, int cand) {
        int count = 0;
        for(int i = 0; i<a.length;i++) {
            if(a[i] == cand)
                count++;
        }
        if(count > a.length/2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 3, 1, 2};
        printMajority(a);
    }
}
