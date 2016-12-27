package org.practice.javaFundas.designPatterns.decorator;

//Concrete component Espresso
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

