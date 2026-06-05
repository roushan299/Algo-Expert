package sorting;

public class CountInversions {

    public int countInversions(int[] array) {
        return countInversions(array, 0, array.length-1);
    }

    public int countInversions(int[] array, int start, int end) {

        if(start >= end) return 0;
        int mid = start + (end - start)/2;

        int leftCountInversion =  countInversions(array, start, mid);
        int rightCountInversion =  countInversions(array, mid+1, end);
        int crossInversions = merge(array, start, mid, end);
        return leftCountInversion + rightCountInversion + crossInversions;

    }

    private int merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end-start+1];

        int left = start;
        int right = mid+1;
        int k = 0;
        int inversions = 0;

        while (left <= mid && right <= end) {

            if(array[left] <= array[right]) {
                temp[k] = array[left];
                left++;
            }else {
                inversions += (mid - left + 1);
                temp[k] = array[right];
                right++;
            }
            k++;
        }

        while (left <= mid) {
            temp[k++] = array[left++];
        }
        while (right <= end) {
            temp[k++] = array[right++];
        }

        for(int i=0;i<temp.length;i++){
            array[start+i] = temp[i];
        }
        return inversions;
    }


//    public int countInversions(int[] array) {
//        int countInversions = 0;
//
//        for(int i = 0; i < array.length; i++) {
//            for(int j = i+1; j < array.length; j++) {
//                if(array[i] > array[j]) countInversions++;
//            }
//        }
//        return countInversions;
//    }
}
