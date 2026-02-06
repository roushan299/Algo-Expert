package searching;



public class SearchInSortedMatrix {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        if(!isValidMatrix(matrix)){
            return new int[]{-1, -1};
        }

        return search(matrix, target);
    }

    private static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(isInBounds(matrix, row, col)){
            int current = matrix[row][col];
            if(current == target){
                return new int[]{row, col};
            }else if(current < target){
                row = moveDown(row);
            }else{
                col = moveLeft(col);
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isValidMatrix(int[][] matrix) {
        return matrix != null && matrix.length > 0 && matrix[0].length > 0;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static int moveDown(int row){
        return row + 1;
    }

    private static int moveLeft(int col){
        return col - 1;
    }
}
