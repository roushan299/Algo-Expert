package greedy_algorithms;

import java.util.Arrays;

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int length = redShirtSpeeds.length;
        int totalSpeed = 0;

        for(int i = 0; i < redShirtSpeeds.length; i++){
            int index = fastest ? length - (i + 1) : i;
            int redShirtSpeed = redShirtSpeeds[i];
            int blueShirtSpeed = blueShirtSpeeds[index];
            totalSpeed += Math.max(redShirtSpeed, blueShirtSpeed);
        }
        return totalSpeed;
    }
}
