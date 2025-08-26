package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> quadruplets = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer[]>> allPairSums = new HashMap<>();

        for(int i = 1; i < array.length-1; i++){
            for(int j = i+1; j < array.length; j++){
                int currentSum = array[i] + array[j];
                int difference = targetSum - currentSum;
                if(allPairSums.containsKey(difference)){
                    ArrayList<Integer[]> pairSums = allPairSums.get(difference);

                    for(Integer[] pairSum : pairSums){
                        Integer[] quadruplet = new Integer[]{pairSum[0], pairSum[1], array[i], array[j]};
                        quadruplets.add(quadruplet);
                    }
                }
            }

            for(int k=0; k<i; k++){
                int currentSum = array[i] + array[k];
                ArrayList<Integer[]> pairSums = allPairSums.containsKey(currentSum) ? allPairSums.get(currentSum) : new ArrayList<>();
                pairSums.add(new Integer[]{array[i], array[k]});
                allPairSums.put(currentSum, pairSums);
            }
        }
        return quadruplets;
    }


}



