package algorithms;

import java.util.ArrayList;
import java.util.List;

public class GetPermutations {

    public static List<List<Integer>> getPermutations(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<>();
        permutate(0, array, permutations);
        return permutations;
    }

    private static void permutate(int index, List<Integer> array, List<List<Integer>> permutations) {
        if(index == array.size()-1){
            permutations.add(new ArrayList<>(array));
            return;
        }

        for(int i=index; i<array.size(); i++){
            swap(array, index, i);
            permutate(index+1, array, permutations);
            swap(array, index, i);
        }
    }

    private static void swap(List<Integer> array, int i, int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
