package org.practice.javaFundas.designPatterns.factory;

/**
 * Created by priyasingh on 11/10/15.
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "NY Style Cheese and Sauce Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Cheese");
    }
}
