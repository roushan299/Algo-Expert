package arrays;

import java.util.Arrays;

public class NonConstructibleChange {
    public int nonConstructibleChange(int[] coins) {
        if(coins==null || coins.length==0){
            return 1;
        }
        sortCoins(coins);
        return findSmallNonConstructibleChange(coins);
    }

    private int findSmallNonConstructibleChange(int[] coins) {
        int currentChange = 0;

        for(int  coin: coins){
            if(hasGap(currentChange, coin)){
                return currentChange+1;
            }
            currentChange = extendChange(currentChange, coin);
        }
        return currentChange+1;
    }

    private int extendChange(int currentChange, int coin) {
        return  currentChange + coin;
    }

    private boolean hasGap(int currentChange, int coin) {
        return coin > currentChange + 1;
    }



    private void sortCoins(int[] coins){
        Arrays.sort(coins);
    }
}
