package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        visitBorderAndFindIsland(matrix, visited);

        for(int row = 1; row <matrix.length-1; row++){
            for(int col = 1; col <matrix[0].length-1; col++){
                if(!isVisited(visited, row, col) && matrix[row][col] == 1){
                    matrix[row][col] = 0;
                }
            }

        }
        return matrix;
    }

    private void visitBorderAndFindIsland(int[][] matrix, boolean[][] visited) {

        //visit up to down with first and last column
        for(int row = 0; row < matrix.length; row++){
            // first column
            Integer[] firstColumnCoordinate = new  Integer[]{row,0};
            fillIsland(visited, matrix, firstColumnCoordinate);

            // last column
            Integer[] lastColumnCoordinate = new  Integer[]{row,matrix[0].length-1};
            fillIsland(visited, matrix, lastColumnCoordinate);
        }

        // visit left to right with first and last row
        for(int col = 0; col < matrix[0].length; col++){
            // first row
            Integer[] firstColumnCoordinate = new  Integer[]{0, col};
            fillIsland(visited, matrix, firstColumnCoordinate);

            //last row
            Integer[] lastColumnCoordinate = new  Integer[]{matrix.length-1, col};
            fillIsland(visited, matrix, lastColumnCoordinate);
        }
    }

    private void fillIsland(boolean[][] visited, int[][] matrix, Integer[] startCoordinate) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(startCoordinate);

        while(!queue.isEmpty()){
            Integer[] coordinate = queue.poll();
            int x  = coordinate[0];
            int y  = coordinate[1];
            if(isVisited(visited,x,y) || !isIsland(matrix, x, y)){
                continue;
            }
            setVisited(visited,x,y);
            ArrayList<Integer[]> neighbours = getDirections(matrix, x, y, visited);
            for(Integer[] neighbour : neighbours){
                queue.add(neighbour);
            }
        }
    }

    private boolean isIsland(int[][] matrix, int x, int y) {
            return matrix[x][y] == 1;
    }

    private boolean isVisited(boolean[][] visited, int row, int col){
        return visited[row][col];
    }

    private void setVisited(boolean[][] visited, int row, int col){
        visited[row][col] = true;
    }

    private ArrayList<Integer[]> getDirections(int[][] matrix, int row, int col, boolean[][] visited) {
        ArrayList<Integer[]> directions = new ArrayList<>();

        if( row > 0 && !isVisited(visited, row-1, col)){
            directions.add(new Integer[]{row -1, col});
        }

        if(row < matrix.length-1 &&  !isVisited(visited, row+1, col)){
            directions.add(new Integer[]{row+1, col});
        }

        if(col > 0 && !isVisited(visited, row, col-1)){
            directions.add(new Integer[]{row, col-1});
        }

        if(col < matrix[0].length-1 && !isVisited(visited, row, col+1)){
            directions.add(new Integer[]{row, col+1});
        }
        return directions;
    }

}
