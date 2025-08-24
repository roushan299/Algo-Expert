package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftIdx = 0;
        int rightIdx = array.size() - 1;

        while ((leftIdx < rightIdx) ){

            while(leftIdx < rightIdx && array.get(rightIdx) == toMove){
                rightIdx--;
            }

            if(array.get(leftIdx) == toMove){
                int temp = array.get(leftIdx);
                array.set(leftIdx, array.get(rightIdx));
                array.set(rightIdx, temp);
            }
            leftIdx++;
        }
        return array;
    }
}
