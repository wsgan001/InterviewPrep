package org.practice.stack;

/*You are given an array whose each element represents the height of the tower. The width of every tower is 1. It starts raining.
How much water is collected between the towers?
        Eg. [1,5,3,7,2] – then answer is 2 units between towers 5 and 7.
        */

/* Algorithm:
   maxAmountOfRainWaterOnCurrentTower = 0(There is no tower on left of current tower with more height || There is no tower on right of
   current tower with more height)
   =Min(MaxHeightOfTowerOnLeft, MaxHeightOfTowerOnRight) - currentTowerHeight)
*/

public class WaterTower {
    //you tube explanation link: https://www.youtube.com/watch?v=KV-Eq3wYjxI
    public static int waterCollected(int[] towerheight) {
        int maxSeenSoFar = 0, maxSeenLeft = 0, rainWater = 0;
        int [] maxSeenRight =  new int[towerheight.length];

        for(int i = towerheight.length-1; i >=0; i--) {
            if(towerheight[i] > maxSeenSoFar) {
                maxSeenSoFar = towerheight[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }

        for(int i = 0; i<towerheight.length;i++) {
            rainWater= rainWater+ Math.max(Math.min(maxSeenLeft, maxSeenRight[i]) - towerheight[i], 0); //this line is most imp
            if(towerheight[i] > maxSeenLeft) {
                maxSeenLeft = towerheight[i];
            }
        }
        return rainWater;
    }

    public static void main(String args[]) {
        int a[] = {3,4,2,5};
        System.out.println("Water Collected is "+waterCollected(a)+" units");
    }


}
