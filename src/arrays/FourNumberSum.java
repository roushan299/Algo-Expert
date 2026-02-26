package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Map<Integer, List<Integer[]>> allPairsSum = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for(int i=1;i<array.length-1;i++){

            //check pairs after i
            for(int j=i+1;j<array.length;j++){
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;

                if(allPairsSum.containsKey(difference)){

                    for (Integer[] pair: allPairsSum.get(difference)){
                        quadruplets.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }
            // store pairs before i

            for(int k=0;k<i;k++){
                int currentSum = array[i] + array[k];
                Integer[] pair = new Integer[]{array[i], array[k]};
                allPairsSum.computeIfAbsent(currentSum, x -> new ArrayList<>()).add(pair);
            }
        }
        return quadruplets;
    }
}
