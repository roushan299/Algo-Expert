package graphs;

import java.util.*;

public class LargestIsland {

    private static int[][] DIRECTIONS;



    public int largestIsland(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int maxSize = 0;

        // step 1: label islands and compute sizes
        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col <colLength; col++){

                if(matrix[row][col] == 0) continue;

                maxSize = Math.max(maxSize, getSizeFromNode(row, col, matrix));

            }
        }
        return maxSize == 0 ? rowLength * colLength : maxSize;
    }

    private int getSizeFromNode(int row, int col, int[][] matrix) {
        int size = 1;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        Stack<Integer[]> nodesToExplore = new  Stack<>();
        getLandNeighbours(row, col, matrix, nodesToExplore);

        while(!nodesToExplore.isEmpty()){
            Integer[] currentNode = nodesToExplore.pop();

            if(visited[currentNode[0]][currentNode[1]]) continue;
            visited[currentNode[0]][currentNode[1]] = true;

            size++;
            getLandNeighbours(currentNode[0], currentNode[1], matrix, nodesToExplore);
        }
        return size;

    }

    private void getLandNeighbours(int row, int col, int[][] matrix, Stack<Integer[]> landNeighbours) {

        if(row > 0 && matrix[row-1][col] != 1){
            landNeighbours.add(new Integer[]{row-1, col});
        }

        if(row < matrix.length-1 && matrix[row+1][col] != 1){
            landNeighbours.add(new Integer[]{row+1, col});
        }

        if(col > 0 && matrix[row][col-1] != 1){
            landNeighbours.add(new Integer[]{row, col-1});
        }

        if(col < matrix[0].length-1 && matrix[row][col+1] != 1){
            landNeighbours.add(new Integer[]{row, col+1});
        }
    }


    private int dfs(int[][] matrix, int row, int col, int id) {
        if(!isInBoundary(row, col, matrix) || matrix[row][col] != 1) return 0;

        matrix[row][col] = id;
        int size = 1;

        for(int[] dir: DIRECTIONS){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            size += dfs(matrix, newRow, newCol, id);
        }
        return size;
    }

    private void initializeDirections() {
        int[][] directions = new int[][]{
                {-1, 0},{1, 0},
                {0, -1},{0, 1}};
        DIRECTIONS = directions;
    }

    private boolean isInBoundary(int row, int col, int[][] matrix) {
        boolean isInRow = 0 <= row && row < matrix.length;
        boolean isInCol = 0 <= col && col < matrix[0].length;
        return isInRow && isInCol;
    }

}
