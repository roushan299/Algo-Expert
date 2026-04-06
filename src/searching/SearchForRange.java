package searching;

public class SearchForRange {

    private static int getMidIdx(int leftIdx, int rightIdx) {
        return (leftIdx + rightIdx) / 2;
    }

    public static int[] searchForRange(int[] array, int target) {
        int lefBoundary = findBoundary(array, target, true);
        int rightBoundary = findBoundary(array, target, false);
        return new  int[]{lefBoundary, rightBoundary};
    }

    private static int findBoundary(int[] array, int target, boolean findLeft) {
        int leftIdx = 0;
        int rightIdx = array.length - 1;
        int boundary = -1;

        while(leftIdx <= rightIdx){
            int midIdx = getMidIdx(leftIdx, rightIdx);

            if(array[midIdx] == target){
                boundary = midIdx;

                if(findLeft){
                    rightIdx = midIdx - 1;
                }else {
                    leftIdx = midIdx + 1;
                }

            }else if(array[midIdx] < target){
                leftIdx = midIdx + 1;
            }else {
                rightIdx = midIdx - 1;
            }
        }
        return boundary;
    }

//    public static int[] searchForRange(int[] array, int target) {
//       return searchForRangeHelper(array, target, 0, array.length-1);
//    }
//
//    private static int[] searchForRangeHelper(int[] array, int target, int leftIdx, int rightIdx) {
//
//        while(leftIdx <= rightIdx){
//            int midIdx = getMidIdx(leftIdx, rightIdx);
//            int potentialMatch = array[midIdx];
//            if(potentialMatch == target){
//                return getRange(array, midIdx, target);
//            } else if (array[midIdx] < target) {
//                leftIdx = midIdx + 1;
//            }else {
//                rightIdx = midIdx - 1;
//            }
//        }
//        return new  int[]{-1, -1};
//    }
//
//    private static int[] getRange(int[] array, int midIdx, int target) {
//        int leftIdx = midIdx-1;
//        int rightIdx = midIdx+1;
//
//        while (leftIdx >= 0 && array[leftIdx] == target){
//            leftIdx--;
//        }
//        while (rightIdx < array.length && array[rightIdx] == target){
//            rightIdx++;
//        }
//        return new  int[]{leftIdx+1, rightIdx-1};
//    }
//

}
