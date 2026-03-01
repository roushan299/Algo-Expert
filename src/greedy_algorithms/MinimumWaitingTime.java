package greedy_algorithms;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int minimumWaitingTime = 0;
        int runningTime = 0;
        for(int i = 0; i < queries.length; i++){
            minimumWaitingTime = minimumWaitingTime + runningTime;
            runningTime = runningTime + queries[i];
        }
        return minimumWaitingTime;
    }

    public int minimumWaitingTime2(int[] queries) {
        Arrays.sort(queries);
        int minimumWaitingTime = 0;

        for(int i = 0; i < queries.length; i++){
            int queriesLeft = queries.length - (i+1);
            minimumWaitingTime += queries[i] * queriesLeft;
        }
        return minimumWaitingTime;
    }
}
