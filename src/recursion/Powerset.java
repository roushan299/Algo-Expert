package recursion;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, array, new ArrayList<Integer>(), result);
        return result;
    }

    private static void backtrack(int index, List<Integer> array, ArrayList<Integer> currentArray, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentArray));

        for(int i=index;i<array.size();i++){
            currentArray.add(array.get(i));
            backtrack(i+1, array, currentArray, result);
            currentArray.remove(currentArray.size()-1);
        }
    }

    public static List<List<Integer>> powersetIterative(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int index =0;index<array.size();index++){
            int value = array.get(index);
            int currentSize = result.size();
            for(int j=0;j<currentSize;j++){
                List<Integer> currentArray = result.get(j);
                List <Integer> newArray = new ArrayList<>(currentArray);
                newArray.add(value);
                result.add(newArray);
            }
        }
        return result;
    }


}
