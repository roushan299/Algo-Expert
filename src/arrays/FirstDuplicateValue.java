package arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {

    public int firstDuplicateValue(int[] array) {
        int[] arr = new int[array.length];

        for(int i = 0; i < array.length; i++){
            int index =  array[i]-1;
            if(arr[index] != 0){
                return arr[index];
            }
            arr[index] = array[i];
        }
        return -1;
    }
}
