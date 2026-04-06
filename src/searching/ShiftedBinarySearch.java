package searching;

public class ShiftedBinarySearch {

    public static int shiftedBinarySearch(int[] array, int target) {
      return shiftedBinarySearchHelper(array, target, 0, array.length-1);
    }

    private static int shiftedBinarySearchHelper(int[] array, int target, int leftIdx, int rightIdx) {


        while (leftIdx <= rightIdx){
            int midIdx = getMidIdx(leftIdx, rightIdx);
            int midVal = array[midIdx];
            int leftVal = array[leftIdx];
            int rightVal = array[rightIdx];

            if(target == midVal) return midIdx;
            else if(leftVal <= midVal){
                if(target < midVal && target >= leftVal){
                    rightIdx = midIdx-1;
                }else {
                    leftIdx = midIdx+1;
                }
            }else {
                if(target > midVal && target <= rightVal){
                    leftIdx = midIdx+1;
                }else {
                    rightIdx = midIdx-1;
                }
            }
        }
        return -1;
    }


//    private static int shiftedBinarySearchHelper(int[] array, int target, int leftIdx, int rightIdx) {
//        if(leftIdx > rightIdx) return -1;
//
//        int midIdx = getMidIdx(leftIdx, rightIdx);
//
//        int potentialMatch = array[midIdx];
//        int leftValue  = array[leftIdx];
//        int rightValue = array[rightIdx];
//
//        if(potentialMatch == target) return midIdx;
//        else if(leftValue <= potentialMatch){
//
//            if(target < potentialMatch && target  >= leftValue){
//                return shiftedBinarySearchHelper(array, target, leftIdx, midIdx-1);
//            }else {
//                return shiftedBinarySearchHelper(array, target, midIdx+1, rightIdx);
//            }
//        }else {
//
//            if(target > potentialMatch && target  <= rightValue){
//                return shiftedBinarySearchHelper(array, target, midIdx+1, rightIdx);
//            }else {
//                return shiftedBinarySearchHelper(array, target, leftIdx, midIdx-1);
//            }
//        }
//
//    }

    private static int getMidIdx(int left, int right){
        return (left + right) / 2;
    }
}
