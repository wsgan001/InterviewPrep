package org.practice.backtracking;//Given the position(x, y) of a knight on an 8X8 chess board,
// what is the  probability that it stays within the chess board  after n moves?

public class KnightProblem {
    private static int boardSize = 8;
    private static Double[][][] alive;
    public static double pAlive(int r, int c, int k) {
        alive = new Double[boardSize][boardSize][k];
        return calcPAlive(r, c, k);
    }
    private static double calcPAlive(int r, int c, int k) {
        if (r < 0 || r >= boardSize || c < 0 || c >= boardSize)
            return 0.0;
        if (k == 0)
            return 1.0;
        // K is one based
        if (alive[r][c][k-1] != null)
            return alive[r][c][k-1];
        double p = 0.0;
        p += calcPAlive(r-2, c-1, k-1)/8;
        p += calcPAlive(r-2, c+1, k-1)/8;
        p += calcPAlive(r+2, c-1, k-1)/8;
        p += calcPAlive(r+2, c+1, k-1)/8;
        p += calcPAlive(r-1, c-2, k-1)/8;
        p += calcPAlive(r+1, c-2, k-1)/8;
        p += calcPAlive(r-1, c+2, k-1)/8;
        p += calcPAlive(r+1, c+2, k-1)/8;
        return alive[r][c][k-1] = p;
    }
    public static void main(String args[]){
        System.out.println(pAlive(0,0,2));

    }
}
