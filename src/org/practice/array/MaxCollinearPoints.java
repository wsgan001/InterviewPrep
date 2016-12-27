package org.practice.array;

import java.util.*;

/* Linkedin Interview Question
Given N Points in a Plane find the sets of Collinear Points.
Collinear points are 3 or more points on the same line.(2 points are trivially collinear).
 */
public class MaxCollinearPoints {
    private static class Point{
        double x;
        double y;
        char name;
        Point(double x, double y,char n)
        {
            this.x =x;
            this.y =y;
            this.name=n;
        }
    }

    private static class Angle implements Comparable<Object>{
        Point p;
        double angle;
        public int compareTo(Object o) {
            Angle in = (Angle)o;
            if(this.angle < in.angle)
                return -1;
            else if(this.angle == in.angle)
                return 0;
            else
                return 1;
        }


    }

    public static void main(String args[]) {
        Point[] p = new Point[6];
        Angle[] angle;
        List<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();
        p[0]=new Point(19000, 10000,'A');
        p[1]=new Point(18000, 10000,'B');
        p[2]=new Point(32000, 10000,'C');
        p[3]=new Point(21000, 10000,'D');
        p[4]=new Point(1234, 5678,'E');
        p[5]=new Point(14000, 10000,'F');

        for(int i = 0; i < p.length-1; i++) {
            int k = p.length -i -1;
            angle = new Angle[k];

            for(int j = i+1; j < p.length; j++) {
                angle[j-i-1] = new Angle();
                double temp = (p[j].y - p[i].y)/(p[j].x - p[i].x);
                angle[j-i-1].angle = Math.atan(temp);
                angle[j-i-1].p = p[j];
            }

            Arrays.sort(angle);
            Angle previous = angle[0];
            ArrayList<Character> collinearList = new ArrayList<Character>();
            collinearList.add(p[i].name);
            collinearList.add(previous.p.name);
            for(int n =1;n<k;n++) {
                if(previous.angle == angle[n].angle) {
                    collinearList.add(angle[n].p.name);
                }
                previous = angle[n];
            }
            list.add(collinearList);
        }

        System.out.println("Collinear Points are: ");
        int max = Integer.MIN_VALUE;
        for(ArrayList<Character> collinearlist: list) {
            if(collinearlist.size() > 2) {
                max = Math.max(max, collinearlist.size());
                for(Character ch: collinearlist){
                    System.out.print(ch+" ");
                }
            }
            System.out.println();
        }
        System.out.println("Max no of points which are collinear are: "+max);
    }
}
