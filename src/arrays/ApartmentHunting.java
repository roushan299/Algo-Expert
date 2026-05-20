package arrays;

import java.util.*;

public class ApartmentHunting {


    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        HashMap<String, int[]> minDistancesFromBlocks = new HashMap<>();

        for(String req : reqs){
            int[] minDistancesForReq = getMinDistances(blocks, req);
            minDistancesFromBlocks.put(req, minDistancesForReq);
        }

        int[] maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
        return getIdxMinValue(maxDistancesAtBlocks);
    }

    private static int[] getMaxDistancesAtBlocks(List<Map<String, Boolean>> blocks, HashMap<String,int[]> minDistancesFromBlocks) {
        int[] maxDistancesAtBlocks = new int[blocks.size()];

        for(int index = 0; index < blocks.size(); index++){
            int[] minDistancesAtBlock = getMinDistancesAtBlock(index, minDistancesFromBlocks);
            maxDistancesAtBlocks[index] = getMax(minDistancesAtBlock);
        }
        return maxDistancesAtBlocks;
    }

    public static int getMax(int[] minDistancesAtBlock){
        int max = 0;
        for(int index = 0; index < minDistancesAtBlock.length; index++){
            max = Math.max(max, minDistancesAtBlock[index]);
        }
        return max;
    }

    private static int[] getMinDistancesAtBlock(int index, HashMap<String, int[]> minDistancesFromBlocks) {
        Set<String> keySet = minDistancesFromBlocks.keySet();
        int[] minDistancesAtBlock = new int[keySet.size()];

        int count = 0;
        for(String req : keySet){
            minDistancesAtBlock[count] = minDistancesFromBlocks.get(req)[index];
            count++;
        }
        return minDistancesAtBlock;
    }

    public static int[] getMinDistances(List<Map<String, Boolean>> blocks, String req) {
        int[] minDistances = new int[blocks.size()];
        int closestReqIdx = Integer.MAX_VALUE;

        for(int index = 0; index < blocks.size(); index++){

            if(blocks.get(index).get(req)){
                closestReqIdx = index;
            }
            minDistances[index] = distancesBetween(index, closestReqIdx);
        }

        for(int index = blocks.size() - 1; index >= 0; index--){
            if(blocks.get(index).get(req)){
                closestReqIdx = index;
            }
            minDistances[index] = Math.min(minDistances[index] ,distancesBetween(index, closestReqIdx));
        }
        return minDistances;
    }

    private static int distancesBetween(int point1, int point2) {
        return Math.abs(point1 - point2);
    }

        private static int getIdxMinValue(int[] maxDistancesAtBlocks) {
        int idxMinValue = 0;
        int minValue = Integer.MAX_VALUE;

        for(int index = 0; index < maxDistancesAtBlocks.length; index++){
            int currentValue = maxDistancesAtBlocks[index];
            if(currentValue < minValue){
                minValue = currentValue;
                idxMinValue = index;
            }
        }
        return idxMinValue;
    }


//    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
//       int[] maxDistancesAtBlocks = new int[blocks.size()];
//       Arrays.fill(maxDistancesAtBlocks, Integer.MIN_VALUE);
//
//        for(int index = 0; index < blocks.size(); index++){
//
//            for(String req : reqs){
//                int closestReqDistance = Integer.MAX_VALUE;
//
//                for(int j = 0; j < blocks.size(); j++){
//                    if(blocks.get(j).get(req)){
//                        closestReqDistance = Math.min(closestReqDistance, distanceBetween(index, j));
//                    }
//                }
//                maxDistancesAtBlocks[index] = Math.max(maxDistancesAtBlocks[index], closestReqDistance);
//            }
//        }
//
//        return getIdxMinValue(maxDistancesAtBlocks);
//
//    }
//
//    private static int getIdxMinValue(int[] maxDistancesAtBlocks) {
//        int idxMinValue = 0;
//        int minValue = Integer.MAX_VALUE;
//
//        for(int index = 0; index < maxDistancesAtBlocks.length; index++){
//            int currentValue = maxDistancesAtBlocks[index];
//            if(currentValue < minValue){
//                minValue = currentValue;
//                idxMinValue = index;
//            }
//        }
//        return idxMinValue;
//    }
//
//    private static int distanceBetween(int point1, int point2) {
//        return Math.abs(point1 - point2);
//    }
}
