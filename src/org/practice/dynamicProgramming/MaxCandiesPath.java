package org.practice.dynamicProgramming;

/** Amazon Interview Question
 * Given a matrix with each cell containing each number of candies, and a constraint that you can move only right or down,
 * from the top left corner to the bottom right corner, find the path that gets you maximum candies.
 */

public class MaxCandiesPath {
    public static void printMaximizedPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] newMatrix = new int[m][n];

        for(int i =0; i<m; i++) {
            for(int j= 0; j<n;j++) {
                if(i == 0 && j== 0)
                    newMatrix[i][j] = matrix[i][j];
                else if(i == 0)
                    newMatrix[i][j] = newMatrix[i][j-1]+matrix[i][j];
                else if(j == 0)
                    newMatrix[i][j] = newMatrix[i-1][j]+matrix[i][j];
                else {
                    newMatrix[i][j] = Math.max(newMatrix[i-1][j], newMatrix[i][j-1]) +matrix[i][j];
                }
            }
        }

        int paths[] = new int[m+n-1];
        int k = paths.length -1, i = m-1, j = n-1;
        while(true) {
            paths[k--] = matrix[i][j];

            if(i > 0 && j > 0) {
                if(newMatrix[i-1][j] > newMatrix[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            } else if(i > 0) {
                i--;
            } else if(j > 0) {
                j--;
            } else
                break;
        }

        System.out.println("Path is:");
        for(int x: paths) {
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("Total candies collected are "+newMatrix[m-1][n-1]);
    }

    public static void main(String args[]) {
        int[][] matrix = { { 9, 10, 8, 13 },
                         { 7, 3, 15, 12 },
                         { 1, 6, 2, 5 },
                         { 16, 14, 4, 11 }
                        };
        printMaximizedPath(matrix);
    }
}
