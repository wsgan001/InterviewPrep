package org.practice.array;

//Rotate a nxn matric by 90 degree
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; ++i) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n;j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }

    public static void main(String args[]) {
        int[][] mat = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        rotate(mat);
    }
}
