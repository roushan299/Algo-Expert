package recursion;

public class StaircaseTraversal {

    public int staircaseTraversal(int height, int maxSteps) {
        if(height == 0) return 1;
        if(height < 0) return 0;

        int result = 0;
        for(int step = 1; step <= maxSteps; step++){
            result += staircaseTraversal(height-step, maxSteps);
        }
        return result;
    }

    public int staircaseTraversalDP(int height, int maxSteps) {
        int[] waysToTop = new int[height+1];
        waysToTop[0] = 1;
        waysToTop[1] = 1;

        for(int currentHeight =2; currentHeight <= height; currentHeight++){
            int step =1;

            while(step <= maxSteps && step <= currentHeight){
                waysToTop[currentHeight] = waysToTop[currentHeight] + waysToTop[currentHeight-step];
                step++;
            }
        }
       return waysToTop[height];
    }

}
