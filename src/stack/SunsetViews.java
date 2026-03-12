package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> buildingsWithSunSetViews = new ArrayList<>();

        int startIdx = direction.equals("WEST") ? 0 : buildings.length - 1;
        int step = direction.equals("WEST") ? 1 : -1;

        int idx = startIdx;
        int runningMaxHeight = 0;

        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];
            if(buildingHeight > runningMaxHeight) {
                buildingsWithSunSetViews.add(idx);
            }

            runningMaxHeight = Math.max(runningMaxHeight, buildingHeight);
            idx += step;
        }
        if(direction.equals("EAST")) {
            Collections.reverse(buildingsWithSunSetViews);
            return buildingsWithSunSetViews;
        }
        return buildingsWithSunSetViews;
    }

}
