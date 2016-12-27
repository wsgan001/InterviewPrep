package org.practice.Graph;

/**
 * Amazon Interview Question
 * Given a boolean 2D matrix, find the number of islands.
 * DFS approach
 */
public class CountIslands {
    private static final int COL = 5;
    private static final int ROW = 5;

    private static boolean isSafe(int[][] island, int row, int col, boolean visitied[][]) {
        return (row >= 0 && row < ROW) &&
                (col >= 0) && (col < COL) &&
                (island[row][col] ==1 && !visitied[row][col]);

    }
    private static void DFS(int[][] island, int row, int col, boolean visitied[][]) {
        // These arrays are used to get row and column numbers of 8 neighbours
        // of a given cell
        int rowNbr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = {-1,  0,  1, -1, 1, -1, 0, 1};

        //Mark this cell as visited
        visitied[row][col] = true;

        // Recur for all connected neighbours
        for(int k =0; k <8;k++) {
            if(isSafe(island, row+rowNbr[k], col+colNbr[k], visitied))
                DFS(island, row+rowNbr[k], col+colNbr[k], visitied);
        }

    }
    public static int countIsland(int[][] island) {
        int m = island.length;
        int n = island[0].length;
        boolean visited[][] = new boolean[m][n];

        // Initialize count as 0 and travese through the all cells of
        // given matrix
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // If a cell with value 1 is not
                // visited yet, then new island found, Visit all
                // cells in this island and increment island count
                if(island[i][j] == 1 && !visited[i][j]) {
                    DFS(island, i, j, visited);
                    //no of dfs calls gives count of island
                    count++;
                }
            }

        }
        return count;
    }
    public static void main(String arg[]) {
        int M[][] = { {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                       };
        System.out.println("Total no of islands are: "+countIsland(M));

    }
}
