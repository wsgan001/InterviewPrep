package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

public enum Tries {
    TRY1(0), TRY2(1), TRY3(3);
    
    int tryNum;
    
    Tries(int tryNum) {
        this.tryNum = tryNum;        
    }
    
    public int getValue() {
        return tryNum;
    }

}
