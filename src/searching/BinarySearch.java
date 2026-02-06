package searching;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while(isValidRange(left, right)) {
            int mid = getMid(left, right);
            if(array[mid] == target) {
                return mid;
            }else if(array[mid] < target) {
                left = moveRight(mid);
            }else{
                right = moveLeft(mid);
            }
        }

        return -1;
    }

    private static boolean isValidRange(int left, int right) {
        return left >= 0 && right >= 0 && left <= right;
    }

    private static int getMid(int left, int right) {
        return left + (right - left) / 2;
    }

    private static int moveRight(int mid){
        return mid + 1;
    }

    private static int moveLeft(int mid){
        return mid - 1;
    }


}
