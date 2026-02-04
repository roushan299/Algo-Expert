package arrays;

import java.util.ArrayList;
import java.util.List;

public class spiralTraverse {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> result = new ArrayList<>();

        int rowStart = 0, rowEnd = array.length - 1;
        int colStart = 0, colEnd = array[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            traverseTop(array, rowStart, colStart, colEnd, result);
            traverseRight(array, colEnd, rowStart + 1, rowEnd, result);

            if (rowStart < rowEnd) {
                traverseBottom(array, rowEnd, colStart, colEnd, result);
            }

            if (colStart < colEnd) {
                traverseLeft(array, colStart, rowStart + 1, rowEnd - 1, result);
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

        return result;
    }

    private static void traverseTop(int[][] array, int row, int colStart, int colEnd, List<Integer> result) {
        for (int i = colStart; i <= colEnd; i++) {
            result.add(array[row][i]);
        }
    }

    private static void traverseRight(int[][] array, int col, int rowStart, int rowEnd, List<Integer> result) {
        for (int i = rowStart; i <= rowEnd; i++) {
            result.add(array[i][col]);
        }
    }

    private static void traverseBottom(int[][] array, int row, int colStart, int colEnd, List<Integer> result) {
        for (int i = colEnd - 1; i >= colStart; i--) {
            result.add(array[row][i]);
        }
    }

    private static void traverseLeft(int[][] array, int col, int rowStart, int rowEnd, List<Integer> result) {
        for (int i = rowEnd; i >= rowStart; i--) {
            result.add(array[i][col]);
        }
    }

}
