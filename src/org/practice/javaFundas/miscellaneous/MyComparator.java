package org.practice.javaFundas.miscellaneous;


import java.util.*;

public class MyComparator {
    String name;
    String color;

    public MyComparator(String name, String color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static class ColorComparator implements Comparator<MyComparator> {
        public int compare(MyComparator a, MyComparator b) {
            return a.getColor().compareTo(b.getColor());
        }
    }

    public static void main(String args[]) {
        List<MyComparator> list = new ArrayList<MyComparator>();
        list.add(new MyComparator("Ford Figo" , "Silver"));
        list.add(new MyComparator("Honda Brio" , "Red"));
        list.add(new MyComparator("Santro" , "Blue"));
        Collections.sort(list, new ColorComparator());
        for(MyComparator ob: list) {
            System.out.println(ob.getName() + ", "+ob.getColor());
        }
    }

}
