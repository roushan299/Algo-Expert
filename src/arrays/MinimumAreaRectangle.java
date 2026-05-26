package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MinimumAreaRectangle {

    private static final String KEY_SEPARATOR = ":";

        public int minimumAreaRectangle(int[][] points) {
            int minimumArea = Integer.MAX_VALUE;
            HashMap<Integer, ArrayList<Integer>> xColumnMap = getXColumnMap(points);
            ArrayList<Integer> xSortedColumnList = new ArrayList<>(xColumnMap.keySet());
            Collections.sort(xSortedColumnList);

            HashMap<String, Integer> edgesParallelToYAxis = new HashMap<>();


            for(int x: xSortedColumnList){
                ArrayList<Integer> yValuesInCurrentColumn = xColumnMap.get(x);
                Collections.sort(yValuesInCurrentColumn);

                for(int currentYIndex=0; currentYIndex<yValuesInCurrentColumn.size(); currentYIndex++){

                    for(int previousYIndex=0; previousYIndex<currentYIndex; previousYIndex++){

                        int y1 = yValuesInCurrentColumn.get(previousYIndex);
                        int y2 = yValuesInCurrentColumn.get(currentYIndex);

                        String edgeKey = getEdgeKey(y1, y2);

                        if(edgesParallelToYAxis.containsKey(edgeKey)){
                            int previousX = edgesParallelToYAxis.get(edgeKey);
                            int currentArea = (x - previousX) * (y2 - y1);
                            minimumArea = Math.min(minimumArea, currentArea);
                        }
                        edgesParallelToYAxis.put(edgeKey, x);
                    }
                }

            }

            return minimumArea == Integer.MAX_VALUE ? 0 : minimumArea;
        }

    private HashMap<Integer, ArrayList<Integer>> getXColumnMap(int[][] points) {
        HashMap<Integer, ArrayList<Integer>> xColumnMap = new HashMap<>();

        for(int[] point : points){
            int x =  point[0];
            int y = point[1];
            ArrayList<Integer> xColumn = xColumnMap.getOrDefault(x, new ArrayList<>());
            xColumn.add(y);
            xColumnMap.put(x, xColumn);
        }
        return xColumnMap;
    }

    private String getEdgeKey(int y1, int y2){
            return y1+KEY_SEPARATOR+y2;
    }
}
