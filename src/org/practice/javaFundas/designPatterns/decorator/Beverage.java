package org.practice.javaFundas.designPatterns.decorator;

//Abstract component Beverage
public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost() ;

}
