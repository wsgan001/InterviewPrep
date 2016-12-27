package org.practice.javaFundas.designPatterns.observer;

public class ObserverTest {
    public static void main(String args[]) {
        NewsPaper printMedia = new NewsPaper();
        Loan personal = new Loan("Personal Loan", 12.5f, "Standard Chartered");
        personal.registerObserver(printMedia);
        personal.setInterest(3.5f);
    }
}
