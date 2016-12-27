package org.practice.javaFundas.designPatterns.bowlingGame.ifaces;

import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Winner;

public interface StartGameInLane {
    void startGame();
    Winner[] decideWinnerInLane();

}
