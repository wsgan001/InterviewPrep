package org.practice.javaFundas.designPatterns.bowlingGame.impl;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Winner;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.LaneElement;
import org.practice.javaFundas.designPatterns.bowlingGame.ifaces.StartGameInLane;

public class Lane implements StartGameInLane {
    private int numOfLanes;
    private BowlingAlley[] alley;
    private Winner[] winnersInLaneWise;
    private LaneElement[] lane;  
    
    public Lane(LaneElement[] lane) {
        this.lane = lane;
        int[] numOfPlayerInLane = new int[lane.length];
        for(int i = 0; i < lane.length; i++) {
            numOfPlayerInLane[i] = lane[i].getnoofPlayers();
        }

        this.numOfLanes = lane.length;
        alley = new BowlingAlley[numOfLanes];
        winnersInLaneWise = new Winner[numOfLanes];
    }
    
    @Override
    public void startGame() {
        for(int i = 0; i < numOfLanes; i++) {
            alley[i] = new BowlingAlley(lane[i]);
            alley[i].play();
        }
    }   

    @Override
    public Winner[] decideWinnerInLane() {
        for(int i = 0; i < numOfLanes; i++) {
            int winnerId = alley[i].decideWinner();
            winnersInLaneWise[i] = new Winner(i, winnerId);
        }
        return winnersInLaneWise;
    }

}
