package dynamicPrograming;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = initializeWaysArray(n);
        
        for(int denom : denoms){
            updateWaysForDenomination(ways, denom, n);
        }
        return ways[n];
    }

    private static void updateWaysForDenomination(int[] ways, int denom, int n) {

        for(int amount = 1; amount <= n; amount++){
            if(denom > amount)continue;
            ways[amount] += ways[amount-denom];
        }
    }

    private static int[] initializeWaysArray(int n) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        return ways;
    }
}
