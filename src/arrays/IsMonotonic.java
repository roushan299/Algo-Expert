package arrays;

public class IsMonotonic {

    public static boolean isMonotonic(int[] array) {

        if(array.length < 2) {
            return true;
        }
        return isDecreasing(array) || isIncreasing(array);
    }

    private static boolean isIncreasing(int[] array) {
        for(int i=1;i< array.length;i++){
            if(array[i-1] > array[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDecreasing(int[] array) {
        for(int i=1;i<array.length;i++){
            if(array[i-1] < array[i]) {
                return false;
            }
        }
        return true;
    }


}
