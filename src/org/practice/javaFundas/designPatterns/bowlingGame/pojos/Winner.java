package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

public class Winner {
    private int laneId;
    private int winnerId;
    
    public Winner(int laneId, int winnerId) {
        this.laneId = laneId;
        this.winnerId = winnerId;
    }

    public int getlaneId() {
        return laneId;
    }

    public int getwinnerId() {
        return winnerId;
    }
    


}
