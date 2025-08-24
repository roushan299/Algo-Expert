package arrays;

public class TransposeMatrix {
    public int[][] transposeMatrix(int[][] matrix) {
        // Write your code here.
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];

       for (int i = 0; i < n; i++) {
           for (int j = 0; j < m; j++) {
               transposedMatrix[j][i] = matrix[i][j];
           }
       }
       return transposedMatrix;
    }
}
