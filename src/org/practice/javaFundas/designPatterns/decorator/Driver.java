package org.practice.javaFundas.designPatterns.decorator;

//Here is our coffee
public class Driver {
    public static void main(String args[]) {
        Beverage beverage = new Espresso();

        System.out.println(beverage.getDescription() +" $"+beverage.cost());

        Beverage beverage2 = new Mocha(new Espresso());
        System.out.println(beverage2.getDescription() +" $"+beverage2.cost());
    }
}
