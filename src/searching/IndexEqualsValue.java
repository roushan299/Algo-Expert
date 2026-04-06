package searching;

public class IndexEqualsValue {

    public int indexEqualsValue(int[] array) {
        int leftIdx = 0;
        int rightIdx = array.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = getMidIdx(leftIdx, rightIdx);
            int midValue =  array[midIdx];

            if(midValue < midIdx){
                leftIdx = midIdx + 1;
            } else if (midValue == midIdx && midValue == 0) {
                return midValue;
            } else if (midValue == midIdx && array[midIdx-1] < midIdx - 1) {
                return midIdx;
            }else {
                rightIdx = midIdx - 1;
            }

        }
        return -1;
    }


    private int getMidIdx(int leftIdx, int rightIdx) {
        return (leftIdx + rightIdx) / 2;
    }

//    public int indexEqualsValue(int[] array) {
//        return indexEqualsValueHelper(array, 0, array.length-1);
//    }
//
//    private int indexEqualsValueHelper(int[] array, int leftIdx, int rightIdx) {
//
//        if(leftIdx > rightIdx)  return -1;
//
//        int midIdx = getMidIdx(leftIdx, rightIdx);
//        int midValue = array[midIdx];
//
//        if(midValue < midIdx){
//            return indexEqualsValueHelper(array, midIdx+1, rightIdx);
//        } else if (midValue == midIdx && midValue == 0) {
//            return midIdx;
//        }else if (midValue == midIdx && array[midIdx -1] < midIdx -1){
//            return midIdx;
//        }else {
//            return indexEqualsValueHelper(array, leftIdx, midIdx-1);
//        }
//
//    }


}
