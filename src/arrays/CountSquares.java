package arrays;

import java.util.HashSet;
import java.util.Set;

public class CountSquares {

    public int countSquares(int[][] points) {
        int squareCount = 0;
        Set<String> set = getPointSet(points);

        for(int[] p1 : points) {
            for(int[] p2: points){
                if(getString(p1).equals(getString(p2))) continue;

                int dx = p2[0] - p1[0];
                int dy = p2[1] - p1[1];

                // Rotate 90 degrees
                int[] p3 = new int[]{p1[0] - dy, p1[1] + dx};
                int[] p4 = new int[]{p2[0] - dy, p2[1] + dx};

                if (pointExists(p3, set) && pointExists(p4, set)) {
                    squareCount++;
                }
            }
        }
        return squareCount/4;
    }


    private boolean pointExists(int[] p, Set<String> set) {
        return set.contains(getString(p));
    }


    private Set<String> getPointSet(int[][] points) {
        Set<String> set = new HashSet<>();

        for(int[] point : points) {
            set.add(getString(point));
        }
        return set;
    }

    private String getString(int[] point) {
        return point[0]+"|"+point[1];
    }
}
