package org.practice.javaFundas.designPatterns.observer;

/**
 * Created by priyasingh on 11/6/15.
 */
public class NewsPaper implements Observer {
    @Override
    public void update(float interest) {
        System.out.println("NewsPaper: Interest Rate updated, new Rate is: "
                + interest);
    }
}



