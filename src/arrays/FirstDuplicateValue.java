package arrays;

public class FirstDuplicateValue {
    public int firstDuplicateValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
           int newIdx = Math.abs(array[i]) - 1;
           int value =  array[newIdx];
           if(value < 0){
               return Math.abs(array[i]);
           }
           array[newIdx] = array[newIdx] * -1;
        }
        return -1;
    }
}
