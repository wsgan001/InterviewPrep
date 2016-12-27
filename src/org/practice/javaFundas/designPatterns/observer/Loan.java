package org.practice.javaFundas.designPatterns.observer;

import java.util.*;

public class Loan implements Subject{
    private List<Observer> observers = new ArrayList<Observer>();

    private String type;
    private float interest;
    private String bank;

    public Loan(String type, float interest, String bank) {
        this.type = type;
        this.interest = interest;
        this.bank = bank;
    }

    public String getType() {
        return type;
    }

    public float getInterest() {
       return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
        notifyObservers();

    }

    public String getBank() {
        return bank;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer ob: observers) {
            System.out.println("Notifying Observers on change in Loan interest rate");
            ob.update(this.interest);
        }
    }




}
