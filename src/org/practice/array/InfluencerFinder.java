package org.practice.array;


/** Linkedin Interview
 * Given a matrix of following between N LinkedIn users (with ids from 0 to N-1):
 * followingMatrix[i][j] == true iff user i is following user j
 * thus followingMatrix[i][j] doesn't imply followingMatrix[j][i].
 * Let's also agree that followingMatrix[i][i] == false
 *
 * Influencer is a user who is:
 * - followed by everyone else and
 * - not following anyone himself
 *
 * This method should find an Influencer by a given matrix of following,
 * or return -1 if there is no Influencer in this group.
 */
public class InfluencerFinder {
    public static int getInfluencer(int[][] mat) {
        if(mat == null) {
            throw new NullPointerException();
        }
        if(mat.length == 0) {
            return -1;
        }
        boolean isInfluencer = true;
        for(int i =0; i <mat.length; i++) {
            if(mat[i][i] == 1)
                continue;
            for(int j = 0; j < mat.length;j++) {
                if(i == j)
                    continue;
                if(mat[i][j] == 1 || mat[j][i] == 0) {
                    isInfluencer = false;
                    break;
                }
            }
            if(isInfluencer)
                return i;
            isInfluencer = true;
        }
        return -1;
    }

    public static void main(String args[]) {
        int mat[][] = {{0,1,0,1},
                       {0,0,0,0},
                       {1,1,0,1},
                       {0,1,0,0}};
        System.out.println("Influencer is: "+getInfluencer(mat));
    }
}
