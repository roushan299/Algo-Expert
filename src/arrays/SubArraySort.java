package arrays;

public class SubArraySort {

    public static int[] subarraySort(int[] array) {
        int[] result = new int[]{-1,-1};
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            int num = array[i];
            if(isOutOfOrder(i, num, array)){
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }

        if(minOutOfOrder == Integer.MAX_VALUE){
            return result;
        }
        int left = findLeftBoundary(array, minOutOfOrder);
        int right = findRightBoundary(array, maxOutOfOrder);

        return new int[]{left, right};

    }

    private static int findRightBoundary(int[] array, int maxOutOfOrder) {
            int right = array.length - 1;
            while(right >= 0 && array[right] >= maxOutOfOrder){
                right--;
            }
            return right;
    }

    private static int findLeftBoundary(int[] array, int minOutOfOrder) {
        int left = 0;
        while (left < array.length && minOutOfOrder >= array[left]){
            left++;
        }
        return left;
    }

    private static boolean isOutOfOrder(int index, int num, int[] array) {
        if(index == 0){
            return num > array[index+1];
        }

        if(index == array.length-1){
            return num < array[index-1];
        }
        return num > array[index+1] || num < array[index-1];
    }
}
