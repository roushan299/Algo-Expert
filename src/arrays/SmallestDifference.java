package arrays;

import java.util.Arrays;

public class SmallestDifference {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        sortArrays(arrayOne, arrayTwo);
        return findSmallestDifference(arrayOne, arrayTwo);
    }

    private static int[] findSmallestDifference( int[] arrayOne, int[] arrayTwo ) {
        int indexOne = 0;
        int indexTwo = 0;

        int smallestDiff = Integer.MAX_VALUE;
        int[] results = new int[]{arrayOne[0], arrayTwo[0]};

        while (indexOne<arrayOne.length && indexTwo<arrayTwo.length){
            int valueOne = arrayOne[indexOne];
            int valueTwo = arrayTwo[indexTwo];
            int diff = calculateDifference(valueOne, valueTwo);

            if(diff<smallestDiff){
                smallestDiff = diff;
                updateResult(results, valueOne, valueTwo);
            }

            if(valueOne<valueTwo){
                indexOne++;
            }else{
                indexTwo++;
            }
        }
        return results;
    }

    private static void updateResult( int[] results, int valueOne, int valueTwo ) {
        results[0] = valueOne;
        results[1] = valueTwo;
    }

    private static int calculateDifference( int valueOne, int valueTwo ) {
        return Math.abs(valueTwo - valueOne);
    }

    private static void sortArrays( int[] arrayOne, int[] arrayTwo ) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
    }
}
