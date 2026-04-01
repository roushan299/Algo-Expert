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

        int subArrayLeftIdx = 0;
        int subArrayRightIdx = array.length - 1;
        while (minOutOfOrder >= array[subArrayLeftIdx]){
            subArrayLeftIdx++;
        }
        while (maxOutOfOrder <= array[subArrayRightIdx]){
            subArrayRightIdx--;
        }
        return new int[]{subArrayLeftIdx, subArrayRightIdx};

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
