package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class SweetAndSavory {
    public int[] sweetAndSavory(int[] dishes, int target) {
        ArrayList<Integer> sweetDishes = new ArrayList<>();
        ArrayList<Integer> savoryDishes = new ArrayList<>();
        distinctDishes(dishes, sweetDishes, savoryDishes);
        if(sweetDishes.isEmpty() || savoryDishes.isEmpty()) {
            return new int[]{0, 0};
        }

        int sweetIndex = sweetDishes.size() - 1;
        int savoryIndex = 0;
        int bestDiff = Integer.MAX_VALUE;
        int[] bestPair = new int[]{0, 0};


        while (sweetIndex >= 0 &&  savoryIndex < savoryDishes.size()) {
            int sweet =  sweetDishes.get(sweetIndex);
            int savory =  savoryDishes.get(savoryIndex);
            int currentSum =  sweet + savory;

            if(currentSum <= target) {
                int currentDiff = target - currentSum;

                if(currentDiff < bestDiff) {
                    bestDiff = currentDiff;
                    bestPair = new int[]{sweet, savory};
                }
                savoryIndex++;
            }else {
                sweetIndex--;
            }
        }
        return bestPair;
    }

    private void distinctDishes(int[] dishes, ArrayList<Integer> sweetDishes, ArrayList<Integer> savoryDishes) {

        for(int dish : dishes) {
            if(dish < 0){
                sweetDishes.add(dish);
            }else{
                savoryDishes.add(dish);
            }
        }
        Collections.sort(sweetDishes);
        Collections.sort(savoryDishes);
    }
}
