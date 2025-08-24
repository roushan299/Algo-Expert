package arrays;

import java.util.Arrays;

public class NonConstructibleChange {
    public int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated = 0;

        for(int i = 0; i < coins.length; i++){
            if(coins[i] > currentChangeCreated+1){
                return  currentChangeCreated+1;
            }
            currentChangeCreated += coins[i];
        }

        return currentChangeCreated +1;
    }
}
