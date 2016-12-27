package org.practice.javaFundas.designPatterns.bowlingGame.driver;

import org.practice.javaFundas.designPatterns.bowlingGame.pojos.LaneElement;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Winner;
import org.practice.javaFundas.designPatterns.bowlingGame.impl.Lane;
import org.practice.javaFundas.designPatterns.bowlingGame.ifaces.StartGameInLane;

//Ola Written test question
public class LetsBowl {
    public static void main(String[] args) {        
        LaneElement[] elem = new LaneElement[2];
        for(int i = 0; i < 2; i++) {
            elem[i] = new LaneElement(i, 2);
        }
        StartGameInLane lane = new Lane(elem);
        lane.startGame();
        
        Winner[] winnerInLanes = lane.decideWinnerInLane();
        
        for(Winner winner : winnerInLanes) {
            if(winner.getwinnerId() != -1) {
                System.out.println("winner for lane "+ winner.getlaneId() +" is " +winner.getwinnerId());
            }
        }
    }
}

