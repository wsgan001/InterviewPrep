package org.practice.array;

//Given a square boolean matrix mat[n][n], find k such that all elements in k’th row are 0
// and all elements in k’th column are 1. The value of mat[k][k] can be anything (either 0 or 1).
// If no such k exists, return -1.
public class BooleanMatrix {
    static int find(int mat[][]) {
        int n=mat.length;
        int i =0, j =n-1, res =-1;
        while(i<n && j>=0) {
            if(mat[i][j] == 0) {
                while(j>=0 && (mat[i][j]==0 || i==j)){
                    j--;
                }
                if(j==-1){
                    res =i;
                    break;
                } else
                    i++;
            } else {
                while(i<n &&(mat[i][j]==1 || i==j)){
                    i++;
                }
                if(i==n) {
                    res=j;
                    break;
                } else
                    j--;

            }
        }
        if(res == -1)
            return res;
        for(i=0;i<n;i++) {
            if(res !=i && mat[i][res] !=1)
                return -1;

        }
        for(j=0;i<n;i++) {
            if(res !=j && mat[res][j] !=0)
                return -1;

        }

        return res;
    }
    public static void main(String args[]) {
        int mat[][] = {{0, 0, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}};
        System.out.println(find(mat));
    }
}
