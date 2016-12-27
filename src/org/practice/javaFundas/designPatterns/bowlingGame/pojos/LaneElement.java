package org.practice.javaFundas.designPatterns.bowlingGame.pojos;

public class LaneElement {
    private int laneId;
    private int noofPlayers;
    
    public LaneElement(int laneId, int numOfPlayers) {
        this.laneId = laneId;
        this.noofPlayers = numOfPlayers;
    }
    
    public int getLaneId() {
        return laneId;
    }
    
    public int getnoofPlayers() {
        return noofPlayers;
    }
    


}
