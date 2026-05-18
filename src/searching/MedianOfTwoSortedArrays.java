package searching;

public class MedianOfTwoSortedArrays {


    public float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
        int totalLength = arrayOne.length + arrayTwo.length;
        int[] smallArray = arrayOne.length > arrayTwo.length ? arrayTwo : arrayOne;
        int[] bigArray = arrayOne.length > arrayTwo.length ? arrayOne : arrayTwo;

        int leftIndex = 0;
        int rightIndex = smallArray.length - 1;
        int mergedPartitionIdx = (totalLength-1)/2;


        while (true){
            int smallPartitionIdx = (leftIndex + rightIndex)/2;
            int bigPartitionIdx = mergedPartitionIdx - smallPartitionIdx - 1;

            int smallMaxLeftValue = smallPartitionIdx >= 0 ?
                    smallArray[smallPartitionIdx] : Integer.MIN_VALUE;

            int smallMinRightValue = smallPartitionIdx + 1 < smallArray.length ?
                    smallArray[smallPartitionIdx+1] : Integer.MAX_VALUE;

            int bigMaxLeftValue =  bigPartitionIdx >= 0 ?
                    bigArray[bigPartitionIdx] : Integer.MIN_VALUE;

            int bigMinRightValue = bigPartitionIdx + 1 < bigArray.length ?
                    bigArray[bigPartitionIdx + 1] : Integer.MAX_VALUE;

            if(smallMaxLeftValue > bigMinRightValue){
                rightIndex = smallPartitionIdx-1;
            } else if (bigMaxLeftValue > smallMinRightValue) {
                leftIndex = smallPartitionIdx+1;
            }else {
                if(totalLength % 2 ==0){
                    return (Math.max(smallMaxLeftValue, bigMaxLeftValue) + Math.min(smallMinRightValue, bigMinRightValue)) / 2.0f;
                }else {
                    return Math.max(smallMaxLeftValue, bigMaxLeftValue);
                }
            }

        }
    }

//    public float medianOfTwoSortedArrays(int[] arrayOne, int[] arrayTwo) {
//        int totalLength = arrayOne.length + arrayTwo.length;
//        int indexOne = 0;
//        int indexTwo = 0;
//        int middleIndex = (totalLength-1) / 2;
//
//
//        while (indexOne + indexTwo < middleIndex) {
//
//            if(indexOne >= arrayOne.length) {
//                indexTwo++;
//            }else if(indexTwo >= arrayTwo.length) {
//                indexOne++;
//            } else if (arrayOne[indexOne] < arrayTwo[indexTwo]) {
//                indexOne++;
//            }else {
//                indexTwo++;
//            }
//        }
//
//        if(totalLength % 2 == 0) {
//             boolean areBothValuesArrayOne = indexTwo >= arrayTwo.length ||
//                     (indexOne + 1 < arrayOne.length && arrayTwo[indexTwo] > arrayOne[indexOne+1]);
//             boolean areBothValuesArrayTwo = indexOne >= arrayOne.length ||
//                     (indexTwo + 1 < arrayTwo.length && arrayOne[indexOne] > arrayTwo[indexTwo+1] );
//
//             int valueOne = areBothValuesArrayOne ? arrayOne[indexOne+1] : arrayTwo[indexTwo];
//             int valueTwo = areBothValuesArrayTwo ? arrayTwo[indexTwo+1] : arrayOne[indexOne];
//             return (valueOne + valueTwo) / 2.0f;
//        }
//
//        int valueOne = indexOne < arrayOne.length ?  arrayOne[indexOne] : Integer.MAX_VALUE;
//        int valueTwo = indexTwo < arrayTwo.length ?  arrayTwo[indexTwo] : Integer.MAX_VALUE;
//        return Math.min(valueOne, valueTwo);
//    }


}
