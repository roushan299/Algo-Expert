package search;

public class SearchInSortedMatrix {
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int[] result = {-1, -1};
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                result[0] = row;
                result[1] = col;
                break;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return result;
    }
}
