package org.practice.javaFundas.designPatterns.bowlingGame.impl;

import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Tries;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Bonus;

public class PinDown {

    //returns no of pins which were hit down
    public static int pinDown(int pins) {
        int pinsDown = (int) (Math.random() * pins);
        return pinsDown;
    }

    // returns the score
    public static int getScore(int pinDowns, int totalPins, int tryNum) {
        int score = pinDowns;
        if(pinDowns == totalPins) {
            if(tryNum == Tries.TRY1.getValue()) {               
                score += Bonus.STRIKE.getBonus();
            }
            if(tryNum == Tries.TRY2.getValue()) {                
                score += Bonus.SPARE.getBonus();
            }
        }
        return score;
    }
}
    