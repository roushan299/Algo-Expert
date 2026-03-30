package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumPassesOfMatrix {

    public int minimumPassesOfMatrix(int[][] matrix) {
        Queue<Integer[]> currentCoordinateQueue = new LinkedList<Integer[]>();
        Queue<Integer[]> nextCoordinateQueue = new  LinkedList<Integer[]>();
        fillPositiveValueCoordinate(matrix, currentCoordinateQueue);

        int currentPass = 0;

        while(!currentCoordinateQueue.isEmpty()){

            Integer[] currentCoordinate = currentCoordinateQueue.poll();
            int currentRow = currentCoordinate[0];
            int currentCol = currentCoordinate[1];
            ArrayList<Integer[]> neighbours = getNeighbours(matrix, currentRow, currentCol);

            for(Integer[] neighbour : neighbours){
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                int neighbourValue = matrix[neighbourRow][neighbourCol];

                if(neighbourValue >= 0) continue;
                nextCoordinateQueue.add(new Integer[]{neighbourRow,neighbourCol});
                matrix[neighbourRow][neighbourCol] = -1 * neighbourValue;
            }

            if(!nextCoordinateQueue.isEmpty() && currentCoordinateQueue.isEmpty()){
                currentPass++;
                currentCoordinateQueue = nextCoordinateQueue;
                nextCoordinateQueue = new LinkedList<Integer[]>();
            }
        }
        boolean isNegativeExits = checkNegativeExits(matrix);

        return isNegativeExits ? -1 : currentPass-1;

    }






    private void fillPositiveValueCoordinate(int[][] matrix, Queue<Integer[]> currentCoordinateQueue) {

        for(int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int currentValue = matrix[row][col];
                if (currentValue <= 0) continue;
                currentCoordinateQueue.add(new Integer[]{row, col});
            }
        }
    }

    private ArrayList<Integer[]> getNeighbours (int[][] matrix, int row, int col) {
        ArrayList<Integer[]> neighbours = new ArrayList<>();

        if(row > 0) neighbours.add(new Integer[]{row-1, col});
        if(row < matrix.length -1) neighbours.add(new Integer[]{row+1, col});
        if(col > 0) neighbours.add(new Integer[]{row, col-1});
        if(col < matrix[0].length -1) neighbours.add(new Integer[]{row, col+1});

        return neighbours;
    }

    private boolean checkNegativeExits(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                int currentValue = matrix[row][col];
                if(currentValue < 0) return true;
            }
        }
        return false;
    }

}
