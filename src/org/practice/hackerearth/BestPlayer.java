package org.practice.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kumari Priyanka Singh
 */

public class BestPlayer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFanQuotient() {
        return fanQuotient;
    }

    public void setFanQuotient(int fanQuotient) {
        this.fanQuotient = fanQuotient;
    }

    private String name;
    private int fanQuotient;

    public static class BestPlayerComparator implements Comparator<BestPlayer> {

        @Override
        public int compare(BestPlayer o1, BestPlayer o2) {
            if(o1.getFanQuotient() < o2.getFanQuotient()) {
                return 1;
            } else if(o1.getFanQuotient() > o2.getFanQuotient()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] arr = line.split(" ");
        int totalFans = Integer.parseInt(arr[0]);
        int outputFans = Integer.parseInt(arr[1]);

        List<BestPlayer> list = new ArrayList<>();

        for(int i =0; i < totalFans; i++) {
            line = br.readLine();
            arr = line.split(" ");
            BestPlayer bp = new BestPlayer();
            bp.setName(arr[0]);
            bp.setFanQuotient(Integer.parseInt(arr[1]));
            list.add(bp);
        }

        Collections.sort(list, new BestPlayerComparator());

        for(int i = 0; i < outputFans; i++ ){
            System.out.println(list.get(i).getName());
        }

    }
}
