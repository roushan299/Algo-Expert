package graphs;


import java.util.*;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = createIsVisited(rowLength, colLength);

        for(int row = 0; row < rowLength; row++){
            for(int col = 0; col < colLength; col++){

                if(isVisited(row, col, visited)){
                    continue;
                }else {
                    traverseNode(row, col, matrix, visited, sizes);
                }
            }
        }
        return sizes;
    }

    private static void traverseNode(int row, int col, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Queue<Integer[]> nodeRToExplore = new LinkedList<>();
        nodeRToExplore.add(new Integer[]{row, col});

        while(!nodeRToExplore.isEmpty()){
            Integer[] currentNode = nodeRToExplore.poll();
            int i=currentNode[0];
            int j=currentNode[1];

            if(isVisited(i,j,visited)){
                continue;
            }
            setVisited(i,j,visited);
            if(matrix[i][j] == 0){
                continue;
            }
            currentRiverSize += 1;
            ArrayList<Integer[]> unvisitedNeighbours = getUnvisitedNeighbours(i, j, matrix, visited);
            for(Integer[] unvisitedNeighbour : unvisitedNeighbours){
                nodeRToExplore.add(unvisitedNeighbour);
            }
        }

        if(currentRiverSize > 0){
            sizes.add(currentRiverSize);
        }
    }

    private static ArrayList<Integer[]> getUnvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited) {
        ArrayList<Integer[]> unvisitedNeighbours = new ArrayList<>();
        if(i > 0 && !isVisited(i-1, j, visited)){
            unvisitedNeighbours.add(new Integer[]{i-1, j});
        }

        if( i < matrix.length-1 && !isVisited(i+1, j, visited) ){
            unvisitedNeighbours.add(new Integer[]{i+1, j});
        }

        if(j > 0 && !isVisited(i, j-1, visited)){
            unvisitedNeighbours.add(new Integer[]{i, j-1});
        }

        if( j < matrix[0].length-1 && !isVisited(i, j+1, visited) ){
            unvisitedNeighbours.add(new Integer[]{i, j+1});
        }
        return unvisitedNeighbours;
    }


    private static boolean[][] createIsVisited(int row, int col) {
        boolean[][] visited = new boolean[row][col];
        return visited;
    }

    private static boolean isVisited(int row, int col, boolean[][] visited) {
        return visited[row][col];
    }
    private static void setVisited(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
    }

}
