package org.practice.javaFundas.designPatterns.bowlingGame.impl;

import org.practice.javaFundas.designPatterns.bowlingGame.ifaces.Play;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Player;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.LaneElement;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.ScoreSet;
import org.practice.javaFundas.designPatterns.bowlingGame.pojos.Tries;

public class BowlingAlley implements Play {
    private Player[] players;
    private int turn;       
    private final int MAX_TURNS = 10;      
    private final int DEFAULT_PINS = 10;
    private LaneElement laneElem;


    public BowlingAlley(LaneElement laneElem) {
        this.laneElem = laneElem;
        players = new Player[laneElem.getnoofPlayers()];
        for(int i = 0; i < laneElem.getnoofPlayers(); i++) {
            players[i] = new Player(i, MAX_TURNS);
        }
        turn = 0;
    }

    
    @Override
    public int play() {
        while(turn < MAX_TURNS) {
            for(Player player : players) {               
                ScoreSet score = new ScoreSet();
                try {
                    score.settotal(player.getScore().get(turn - 1).getTotal());
                } catch (Exception e) {
                }
                int tri = score.gettryNum();
                int pins = DEFAULT_PINS;
                int pinsDown = -1;
                
                while(tri < 2) {
                    pinsDown = PinDown.pinDown(pins);
                    int scored = PinDown.getScore(pinsDown, pins, tri);
                    if(tri == Tries.TRY1.getValue()) {
                        int total = score.getTotal() + scored;
                        score.settotal(total);
                       
                       if(pinsDown == pins) {
                            break;
                        }
                    }

                    if(tri == Tries.TRY2.getValue()) {
                        int total = score.getTotal() + scored;
                        score.settotal(total);      
                        
                    }
                    score.settryNum(++tri);
                    tri = score.gettryNum();
                    pins = pins - pinsDown; //Set the remaining pins for next try
                }

                // if in last turn , player has hit all the pins, then give one extra chance
                if(turn == MAX_TURNS-1 && pins == 0) {
                    pinsDown = PinDown.pinDown(DEFAULT_PINS);
                    int scored = PinDown.getScore(pinsDown, DEFAULT_PINS, Tries.TRY3.getValue());
                    int total = score.getTotal() + scored;

                    score.settotal(total);
                    score.settryNum(tri);
                }
                System.out.println("Player " +player.getId() +" got " +score.getTotal() +" in lane " + (null != laneElem ? laneElem.getLaneId() : 1));
                
                player.getScore().add(score);
            }
            turn++;     
        }
        
        return turn;
    }

    @Override
    public int decideWinner() {
        int playerId = -1;
        if(turn < 10)
            return playerId;
        else {
            int maxScore = 0;
          
            for(Player player : players) {
                int playerMax = player.getScore().get(9).getTotal();
                if (playerMax > maxScore) {
                    maxScore = playerMax;
                    playerId = player.getId();
                }
              //  System.out.println("PlayerId: "+playerId+" playerMax: "+playerMax);
            }
        }
        return playerId;
    }

}