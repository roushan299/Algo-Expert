package dynamicPrograming;

public class MaximumSumSubmatrix {

    public int maximumSumSubmatrix(int[][] matrix, int size) {
        if(!isValid(matrix, size)) return 0;
        int[][] prefix = buildPrefixSum(matrix);
        return findMaxSubMatrixSum(prefix, size);
    }

    private int findMaxSubMatrixSum(int[][] prefix, int size) {
        int maxSum = Integer.MIN_VALUE;
        int rows = prefix.length;
        int cols = prefix[0].length;

        for(int row = size-1; row < rows; row++){
            for(int col = size-1; col < cols; col++){
                int total = getSubMatrixSum(prefix, row, col, size);
                maxSum = Math.max(maxSum, total);
            }
        }
        return maxSum;
    }

    private int getSubMatrixSum(int[][] prefix, int row, int col, int size) {
        int total = prefix[row][col];
        boolean isNotTopBorder = isNotBorder(row, size);
        boolean isNotLeftBorder = isNotBorder(col, size);

        total = isNotTopBorder ? total - prefix[row-size][col] : total;
        total = isNotLeftBorder ? total - prefix[row][col-size] : total;
        total = (isNotLeftBorder && isNotTopBorder) ?  total + prefix[row-size][col-size] : total;
        return total;
    }


    private  boolean isValid(int[][] matrix, int size) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        return rows >= size && cols >= size;
    }

    private int[][] buildPrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefix = new int[rows][cols];
        prefix[0][0] = matrix[0][0];

        //first column
        for(int row = 1; row < rows; row++) {
            prefix[row][0] = matrix[row][0] + prefix[row - 1][0];
        }

        // first row
        for(int col = 1; col < cols; col++) {
            prefix[0][col] = matrix[0][col] + prefix[0][col - 1];
        }

        // rest matrix
        for(int row = 1; row < rows; row++) {
            for(int col = 1; col < cols; col++) {
                prefix[row][col] = getSum(matrix, prefix, row, col);
            }
        }
        return prefix;
    }


    private int getSum(int[][] matrix, int[][] prefix, int row, int col) {
        return matrix[row][col] + prefix[row-1][col] + prefix[row][col-1] - prefix[row-1][col-1];
    }

    private boolean isNotBorder(int index , int size){
        return index - size >= 0 ;
    }

//    public int maximumSumSubmatrix(int[][] matrix, int size) {
//        if(matrix.length == 0 || matrix[0].length == 0) return 0;
//        int rowLength = matrix.length;
//        int colLength = matrix[0].length;
//        if(rowLength < size || colLength < size) return 0;
//        int[][] maxSumDp = new int[rowLength][colLength];
//        maxSumDp[0][0] = matrix[0][0];
//
//        for(int row = 1; row < rowLength; row++){
//            maxSumDp[row][0] = matrix[row][0] + maxSumDp[row -1][0];
//        }
//
//        for(int col = 1; col < colLength; col++){
//            maxSumDp[0][col] = matrix[0][col]+maxSumDp[0][col -1];
//        }
//
//
//        for(int row = 1; row < rowLength; row++){
//            for(int col = 1; col < colLength; col++){
//                maxSumDp[row][col] = getSum(matrix, maxSumDp, row, col);
//            }
//        }
//
//        int maxSum = Integer.MIN_VALUE;
//        for(int row = size - 1; row< rowLength; row++){
//            for(int col = size - 1; col < colLength; col++){
//                int total = maxSumDp[row][col];
//
//                if(isNotBorder(row, size)){
//                    total = total - maxSumDp[row - size][col];
//                }
//
//                if(isNotBorder(col, size)){
//                    total = total - maxSumDp[row][col - size];
//                }
//
//                if(isNotBorder(row, size) && isNotBorder(col, size)){
//                    total = total + maxSumDp[row - size][col - size];
//                }
//
//                maxSum = Math.max(maxSum, total);
//            }
//        }
//
//        return maxSum;
//    }


}
