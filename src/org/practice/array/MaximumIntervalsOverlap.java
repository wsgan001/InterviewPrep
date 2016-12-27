package org.practice.array;

import java.util.*;

/* Flipkart interview question
Consider a big party where a log register for guest’s entry and exit times is maintained.
Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.
*/

public class MaximumIntervalsOverlap {
    public static void maximumGuests(int[] arr, int[] exit) {
        //Sort arrivals and exit arrays
        Arrays.sort(arr);
        Arrays.sort(exit);

        // guests_in indicates number of guests at a time
        int guests_in = 1, max_guests = 1 , time = arr[0], i = 1, j =0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while(i < arr.length && j < exit.length) {
            //if next event in sorted order is arrival, increment count of guests
            if(arr[i] <= exit[j]) {
                guests_in++;

                if(guests_in > max_guests) {
                    max_guests = guests_in;
                    time = arr[i];
                }
                i++; //increment index of arrival array
            } else {
                guests_in--; //if event is exit, decrement count of guests
                j++;
            }
        }
        System.out.println("Maximum no of guests "+max_guests+" at time "+time);
    }

    public static void main(String args[]) {
        int arrl[] = {1, 2, 10, 5, 5};
        int exit[] = {4, 5, 12, 9, 12};
        maximumGuests(arrl, exit);
    }
}
