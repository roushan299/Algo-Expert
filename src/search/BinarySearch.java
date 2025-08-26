package search;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int leftIdx = 0;
        int rightIdx = array.length-1;

        while ( leftIdx <=  rightIdx ){
            int middleIdx = (leftIdx+rightIdx)/2;
            if(array[middleIdx] == target){
                return middleIdx;
            }else if (array[middleIdx] > target) {
                rightIdx = middleIdx -1;
            }else {
                leftIdx = middleIdx+1;
            }
        }
        return -1;
    }

}
