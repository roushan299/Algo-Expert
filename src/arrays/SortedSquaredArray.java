package arrays;

public class SortedSquaredArray {
    public int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        int writePos = array.length - 1;

        while (left <= right) {
            writePos = placeNextSquare(array, result, left, right, writePos);

            if(isRightAbsGreater(array, left, right)){
                right--;
            }else {
                left++;
            }
        }
        return result;
    }

    private boolean isRightAbsGreater(int[] array, int left, int right) {
        return Math.abs(array[right]) > Math.abs(array[left]);
    }

    private int placeNextSquare(int[] array, int[] result, int left, int right, int writePos) {
        int valueToSquare = getLargerAbsValue(array[left], array[right]);
        result[writePos] = square(valueToSquare);
        return writePos - 1;
    }

    private int getLargerAbsValue(int leftValue, int rightValue) {
        return Math.abs(rightValue) > Math.abs(leftValue) ? rightValue:leftValue;
    }

    private  int square(int value) {
        return value*value;
    }
}
