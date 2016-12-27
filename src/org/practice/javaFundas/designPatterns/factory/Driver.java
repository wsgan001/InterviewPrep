package org.practice.javaFundas.designPatterns.factory;

/**
 * Created by priyasingh on 11/10/15.
 */
public class Driver {
    public static void main(String args[]) {
        PizzaStore pizzaStore = new NyPizzaStore();
        Pizza pizza = pizzaStore.orderPizza("Cheese");
        System.out.println("Ethan ordered a "+pizza.getName());
    }
}
