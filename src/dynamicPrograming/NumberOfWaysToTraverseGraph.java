package dynamicPrograming;

public class NumberOfWaysToTraverseGraph {

//    public int numberOfWaysToTraverseGraph(int width, int height) {
//        if(width == 1 || height == 1){
//            return 1;
//        }
//
//        return numberOfWaysToTraverseGraph(width - 1, height) +  numberOfWaysToTraverseGraph(width, height - 1);
//    }


    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] graph = new int[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(i == 0 || j == 0){
                    graph[i][j] = 1;
                }else {
                    graph[i][j] = graph[i-1][j] + graph[i][j-1];
                }
            }
        }
        return graph[height-1][width-1];
    }


}
