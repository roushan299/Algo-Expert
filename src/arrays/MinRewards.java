package arrays;

import java.util.Arrays;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int[] rewards = initializeRewards(scores.length);
        leftToRightPass(scores, rewards);
        rightToLeftPass(scores, rewards);
        return  getTotalRewards(rewards);
    }

    private static void rightToLeftPass(int[] scores, int[] rewards) {
        for(int i=scores.length-2;i>=0;i--){
            if(scores[i] > scores[i+1]){
                rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
            }
        }
    }

    private static void leftToRightPass(int[] scores, int[] rewards) {
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > scores[i-1]){
                rewards[i] = rewards[i-1]+1;
            }
        }
    }

    private static int[] initializeRewards(int length) {
        int[] rewards = new int[length];
        Arrays.fill(rewards,1);
        return rewards;
    }

    private static int getTotalRewards(int[] rewards) {
        int totalRewards = 0;
        for(int reward : rewards) {
            totalRewards += reward;
        }
        return totalRewards;
    }
}
