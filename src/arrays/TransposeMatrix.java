package arrays;

public class TransposeMatrix {
    public int[][] transposeMatrix(int[][] matrix) {
       if(isEmpty(matrix)){
           return matrix;
       }

       int rows = matrix.length;
       int cols = matrix[0].length;

       int[][] transpose = createMatrix(cols, rows);
       fillTranspose(matrix, transpose, rows, cols);
       return transpose;
    }

    private void fillTranspose(int[][] matrix, int[][] transpose, int rows, int cols) {
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
    }

    private int[][] createMatrix(int rows, int cols) {
        return  new int[rows][cols];
    }

    public boolean isEmpty(int[][] matrix){
        return matrix==null || matrix.length==0 || matrix[0].length==0;
    }
}
