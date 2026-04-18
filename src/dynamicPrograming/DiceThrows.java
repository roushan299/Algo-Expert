package dynamicPrograming;

import java.util.Arrays;

public class DiceThrows {

    public int diceThrows(int numDice, int numSides, int target) {
        int[][] storedResults  = new int[numDice+1][target+1];
        storedResults[0][0] = 1;

        for(int currentNumDice = 1;currentNumDice<=numDice;currentNumDice++){

            for(int currentTarget = 1;currentTarget<=target;currentTarget++){
                int numWaysToReach = 0;

                for(int currentNumSides = 1;currentNumSides<=numSides;currentNumSides++) {
                    if (currentTarget - currentNumSides >= 0) {
                        numWaysToReach += storedResults[currentNumDice - 1][currentTarget - currentNumSides];
                    }
                }
                storedResults[currentNumDice][currentTarget] = numWaysToReach;
            }
        }
        return storedResults[numDice][target];
    }

//     recursion method
//    public int diceThrows(int numDice, int numSides, int target) {
//        int[][] storedResults = new int[numDice+1][target+1];
//
//        for(int[] row : storedResults) {
//            Arrays.fill(row, -1);
//        }
//
//        return diceThrowsHelper(numDice, numSides, target, storedResults);
//    }
//
//    private int diceThrowsHelper(int numDice, int numSides, int target, int[][] storedResults) {
//
//        if(numDice == 0){
//            return target == 0 ? 1 : 0;
//        }
//
//        if(storedResults[numDice][target] != -1){
//            return storedResults[numDice][target];
//        }
//
//        int numWaysToReachTarget = 0;
//
//        for(int face = 1; face <= numSides; face++) {
//
//            if(target - face >= 0){
//                numWaysToReachTarget += diceThrowsHelper(numDice-1, numSides, target-face, storedResults);
//            }
//        }
//        storedResults[numDice][target] = numWaysToReachTarget;
//        return numWaysToReachTarget;
//    }
}
