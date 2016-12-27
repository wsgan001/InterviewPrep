package org.practice.Graph;

import java.util.*;

public class SnakeLadder {
    private static class QueueEntry{
        int v;      // Vertex number
        int dist;   // Distance of this vertex from source

        QueueEntry(int v , int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
    // This function returns minimum number of dice throws required to
    // Reach last cell from 0'th cell in a snake and ladder game.
    // move[] is an array of size N where N is no. of cells on board
    // If there is no snake or ladder from cell i, then move[i] is -1
    // Otherwise move[i] contains cell to which snake or ladder at i
    // takes to.
    public static int getMinDicethrows(int[] move) {
        int N = move.length;
        boolean visited[] = new boolean[N];
        for(int i = 0; i <N; i++) {
            visited[i] = false;
        }

        // Create a queue for BFS
        Queue<QueueEntry> q = new LinkedList<QueueEntry>();

        //Mark the node 0 as visited and add it to the queue
        visited[0] = true;
        QueueEntry s = new QueueEntry(0,0);
        q.add(s);

        // Do a BFS starting from vertex at index 0
        QueueEntry qe = new QueueEntry(0,0);
        while(!q.isEmpty()) {
            qe = q.peek();
            int v = qe.v;

            if(v == N-1)
                break;

            q.poll();
            // Otherwise dequeue the front vertex and enqueue
            // its adjacent vertices (or cell numbers reachable
            // through a dice throw
            for(int j = v+1; j<=v+6 && j < N; j++) {
                //if this cell is already visited, then ignore
                if(!visited[j]) {
                    //otherwise calculate its distance and mark it as visited
                    QueueEntry a = new QueueEntry(0,0);
                    a.dist = qe.dist+1;
                    visited[j] =  true;

                    // Check if there a snake or ladder at 'j'
                    // then tail of snake or top of ladder
                    // become the adjacent of 'i'
                    if(move[j] != -1) {
                        a.v = move[j];
                    } else
                        a.v = j;
                    q.add(a);
                }

            }
        }
        return qe.dist;
    }

    public static void main(String args[]) {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i<N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
        System.out.println(getMinDicethrows(moves));
    }
}
