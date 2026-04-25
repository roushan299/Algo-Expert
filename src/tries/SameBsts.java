package tries;

import java.util.ArrayList;
import java.util.List;

public class SameBsts {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo, int minValue, int maxValue) {
        if(rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;
        if(arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) return false;

        int leftRootIdxOne = getIdxOfFirstSmallerValue(arrayOne, rootIdxOne, minValue);
        int leftRootIdxTwo = getIdxOfFirstSmallerValue(arrayTwo, rootIdxTwo, minValue);
        int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxValue);
        int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxValue);

        int currentValue = arrayOne.get(rootIdxOne);
        boolean leftSubTreeSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minValue, currentValue);
        boolean rightSubTreeSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxValue);

        return leftSubTreeSame && rightSubTreeSame;
    }

    private static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxValue) {

        for(int i = startingIdx+1; i <array.size(); i++) {
            if(array.get(i) >= array.get(startingIdx) && array.get(i) < maxValue) return i;
        }
        return -1;
    }

    private static int getIdxOfFirstSmallerValue(List<Integer> array, int startingIdx, int minValue) {

        for(int i=startingIdx+1; i<array.size(); i++) {
            if(array.get(i)< array.get(startingIdx) && array.get(i) >= minValue) return i;
        }
        return -1;
    }


//    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
//
//        if(arrayOne.size() != arrayTwo.size()) return false;
//        if(arrayOne.size() == 0 &&  arrayTwo.size() == 0) return true;
//        if(arrayOne.get(0) !=  arrayTwo.get(0)) return false;
//        List<Integer> leftOne = getSmaller(arrayOne);
//        List<Integer> leftTwo = getSmaller(arrayTwo);
//        List<Integer> rightOne = getBiggerOrEqual(arrayOne);
//        List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
//        return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
//    }
//
//    private static List<Integer> getBiggerOrEqual(List<Integer> array) {
//        List<Integer> bigger = new ArrayList<>();
//        for(int i = 1; i < array.size(); i++) {
//            if(array.get(i) >= array.get(0)) {
//                bigger.add(array.get(i));
//            }
//        }
//        return bigger;
//    }
//
//    private static List<Integer> getSmaller(List<Integer> array) {
//        List<Integer> smaller = new ArrayList<>();
//
//        for(int i = 1; i < array.size(); i++) {
//            if(array.get(i) < array.get(0)) {
//                smaller.add(array.get(i));
//            }
//        }
//        return smaller;
//    }
}
