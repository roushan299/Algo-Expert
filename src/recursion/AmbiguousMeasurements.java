package recursion;

import java.util.HashMap;

public class AmbiguousMeasurements {

    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        HashMap<String, Boolean> memoization = new HashMap<>();
        return canMeasureInRange(measuringCups,low, high, memoization);
    }

    private boolean canMeasureInRange(int[][] measuringCups, int low, int high, HashMap<String, Boolean> memoization) {
        String memoizeKey = createHashAbleKey(low, high);

        if(memoization.containsKey(memoizeKey)) return memoization.get(memoizeKey);

        if(low < 0 && high < 0) return false;
        boolean canMeasure = false;

        for(int[] cup: measuringCups){
            int cupLow = cup[0];
            int cupHigh = cup[1];

            if(low <= cupLow && cupHigh <= high){
                canMeasure = true;
                break;
            }
            canMeasure = canMeasureInRange(measuringCups, low-cupLow, high-cupHigh, memoization);

            if(canMeasure) break;
        }
        memoization.put(memoizeKey,canMeasure);
        return canMeasure;
    }


    public String createHashAbleKey(int low, int high) {
        return String.valueOf(low) + ":"+String.valueOf(high);
    }
}
