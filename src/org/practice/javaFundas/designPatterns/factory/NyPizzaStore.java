package org.practice.javaFundas.designPatterns.factory;

/**
 * Created by priyasingh on 11/10/15.
 */
public class NyPizzaStore extends PizzaStore {
    public Pizza createPizza(String type) {
        if(type.equals("Cheese")) {
            return new NYStyleCheesePizza();
        } else
            return null;
    }
}
