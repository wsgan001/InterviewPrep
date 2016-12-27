package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

import java.util.*;
public class Player {
    private int playerId;
    private List<ScoreSet> score;
    
    public int getId() {
        return playerId;
    }
    
    public Player(int playerId, int noOfturns) {
        score = new ArrayList<ScoreSet>(noOfturns);        
        this.playerId = playerId;
    }

    public List<ScoreSet> getScore() {
        return score;
    }

    public void setScore(List<ScoreSet> score) {
        this.score = score;
    }


}
