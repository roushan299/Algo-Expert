package searching;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] largest = initializeLargest();
        updateLargest(array, largest);
        return largest;
    }

    private static void updateLargest(int[] array, int[] largest) {
        for(int num : array){
            update(num, largest);
        }
    }

    private static void update(int num, int[] largest) {

        if(num > largest[2]){
            shiftAndUpdate(largest, num, 2);
        }else if(num > largest[1]){
            shiftAndUpdate(largest, num, 1);
        } else if (num > largest[0]) {
            shiftAndUpdate(largest, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] largest, int num, int index) {

        for(int i=0;i<index;i++){
            largest[i] = largest[i+1];
        }
        largest[index] = num;
    }

    private static int[] initializeLargest() {
        return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    }

}
