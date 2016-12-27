package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

public class ScoreSet {
    private int total;
    private int tryNum;

    public ScoreSet() {
        total =0 ;
        tryNum =0;
    }
    
    public int getTotal() {
        // TODO Auto-generated method stub
        return total;
    }

    
    public int gettryNum() {
        // TODO Auto-generated method stub
        return tryNum;
    }


    public void settotal(int total) {
        // TODO Auto-generated method stub
        this.total = total;        
    }

    public void settryNum(int trynum) {
        this.tryNum = trynum;
        
    }

}
