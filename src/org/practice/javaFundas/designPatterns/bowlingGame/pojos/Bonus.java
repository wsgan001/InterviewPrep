package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

public enum Bonus {
    STRIKE(10), SPARE(5);
    
    private int bonus;
    
    Bonus(int bonus) {
        this.bonus = bonus;
    }
    
    public int getBonus() {
        return this.bonus;
    }

}
