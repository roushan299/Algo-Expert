package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int currentIntervalStart = intervals[0][0];
        int currentIntervalEnd = intervals[0][1];
        List<int[]> mergedIntervals = new ArrayList<>();
        for(int i=1;i<intervals.length;i++){

            int nextIntervalStart = intervals[i][0];
            int nextIntervalEnd = intervals[i][1];

            if(currentIntervalEnd < nextIntervalStart){
                mergedIntervals.add(new int[]{currentIntervalStart, currentIntervalEnd});
                currentIntervalStart = nextIntervalStart;
                currentIntervalEnd = nextIntervalEnd;

            }else{
                currentIntervalEnd = Math.max(currentIntervalEnd, nextIntervalEnd);
            }
        }
        mergedIntervals.add(new int[]{currentIntervalStart, currentIntervalEnd});
        return  mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
