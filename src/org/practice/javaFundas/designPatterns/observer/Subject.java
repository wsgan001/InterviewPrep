package org.practice.javaFundas.designPatterns.observer;

/**
 * Created by priyasingh on 11/6/15.
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObservers();
}
