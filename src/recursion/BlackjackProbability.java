package recursion;

import java.util.HashMap;
import java.util.Map;

public class BlackjackProbability {

    public float blackjackProbability(int target, int startingHand) {
        Map<Integer, Double> memo = new HashMap<Integer, Double>();
        double result = calculateBlackJackProbability(target, startingHand, memo);
        return toFloat(result);
    }

    private float toFloat(double result) {
        return (float)  result;
    }

    private double calculateBlackJackProbability(int target, int currentHand, Map<Integer, Double> memo) {

        if(isMemoized(currentHand, memo)){
            return memo.get(currentHand);
        }

        if(isBust(currentHand, target)){
            return 1.0;
        }

        if(shouldStop(currentHand, target)){
            return 0.0;
        }
        double probability = calculateMoves(target, currentHand, memo);
        memoize(currentHand, probability, memo);
        return probability;
    }

    private double calculateMoves(int target, int currentHand, Map<Integer, Double> memo) {
        double total = 0.0;

        for(int drawnCard =1;drawnCard<=10;drawnCard++){
            total += probabilityOfCard() * calculateBlackJackProbability(target, currentHand+drawnCard, memo);
        }
        return total;
    }

    private double probabilityOfCard() {
        return 0.1;
    }

    private boolean shouldStop(int currentHand, int target) {
        return currentHand + 4 >= target;
    }

    private boolean isBust(int currentHand, int target) {
        return currentHand > target;
    }

    private void memoize(int currentHand, double probability, Map<Integer, Double> memo) {
        memo.put(currentHand, probability);
    }

    private boolean isMemoized(int currentHand, Map<Integer, Double> memo) {
        return memo.containsKey(currentHand);
    }


}
