package dynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class DiskStacking {

    private static final int WIDTH_IDX = 0;
    private static final int DEPTH_IDX = 1;
    private static final int HEIGHT_IDX = 2;


    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        disks.sort((a, b) -> a[HEIGHT_IDX] - b[HEIGHT_IDX]);

        int n = disks.size();
        int[] heights = new int[n];
        int[] sequences = new int[n];

        for(int i = 0; i < n; i++){
            heights[i] = disks.get(i)[HEIGHT_IDX];
            sequences[i] = -1;
        }

        int maxHeightIdx = 0;

        for(int i = 1; i < n; i++){
            Integer[] curr = disks.get(i);

            for(int j = 0; j < i; j++){
                Integer[] other = disks.get(j);

                if(canStack(other, curr)){

                    if(heights[i] < heights[j]+ curr[HEIGHT_IDX]){
                        heights[i] = heights[j] + curr[HEIGHT_IDX];
                        sequences[i] = j;
                    }
                }
            }
            if(heights[i] > heights[maxHeightIdx]){
                maxHeightIdx = i;
            }

        }


        return buildSequence(disks, sequences, maxHeightIdx);
    }

    private static boolean canStack(Integer[] below, Integer[] above){
        boolean isWidthOk = below[WIDTH_IDX] < above[WIDTH_IDX];
        boolean isDepthOk = below[DEPTH_IDX] < above[DEPTH_IDX];
        boolean isHeightOk = below[HEIGHT_IDX] < above[HEIGHT_IDX];
        return isWidthOk && isDepthOk && isHeightOk;
    }


    private static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequences, int idx){
        List<Integer[]> result = new ArrayList<>();

        while(idx != -1){
            result.add(0, disks.get(idx));
            idx = sequences[idx];
        }
        return result;
    }

}
