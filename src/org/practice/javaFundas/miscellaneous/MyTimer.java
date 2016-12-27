package org.practice.javaFundas.miscellaneous;

import java.util.TimerTask;

import java.util.*;
public class MyTimer {
    private static Timer timer;

    MyTimer(int sec) {
        timer = new Timer();
        timer.schedule(new MyTimerTask(), sec*1000);
    }
    public static class MyTimerTask extends TimerTask {
        public void run() {
            System.out.println("My Timer fired....");
            timer.cancel();
        }
    }

    public static void main(String args[]) {
        MyTimer tm = new MyTimer(5);
        System.out.println("Task scheduled.. Now wait for 5 sec to see next message..");
    }
}
