package org.practice.javaFundas.designPatterns.factory;

import java.util.*;
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("  " + topping);
        }
    }

    void bake() {
        System.out.println("Bake for 25 mins");
    }

    void cut() {
        System.out.println("Cutting the pizza");
    }

    void box() {
        System.out.println("Pack the pizza");
    }

    public String getName() {
        return name;
    }

}
