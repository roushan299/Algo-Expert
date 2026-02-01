package arrays;

import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;

        while (left < right) {
            right = moveRightPointer(array, right, toMove);

            if(left < right && shouldSwap(array, left, toMove)) {
                swap(array, left, right);
                right--;
            }
            left++;
        }
        return array;
    }

    private static int moveRightPointer(List<Integer> array,int right, int toMove) {

        while(right >= 0 && array.get(right) == toMove) {
            right--;
        }
        return right;
    }

    private static void swap(List<Integer> array, int i, int j) {
      int temp = array.get(i);
      array.set(i, array.get(j));
      array.set(j, temp);
    }

    private static boolean shouldSwap(List<Integer> array, int index, int toMove) {
        return array.get(index) == toMove;
    }

}
