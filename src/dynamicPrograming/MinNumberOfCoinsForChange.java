package dynamicPrograming;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, Integer.MAX_VALUE);
        ways[0] = 0;

        for(int denom : denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if(amount < denom) continue;
                int amountLeft = amount - denom;

                ways[amount] = ways[amountLeft] == Integer.MAX_VALUE ? ways[amount]: Math.min(ways[amount], ways[amountLeft]+1);

            }
        }

        return ways[n] == Integer.MAX_VALUE ? -1 : ways[n];
    }
}
