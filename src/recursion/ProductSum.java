package recursion;

import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return calculateProductSum(array, 1);
    }

    private  static int calculateProductSum(List<Object> array, int depth) {
        int sum = 0;

        for (Object element : array) {
            sum += getElementValue(element, depth);
        }
        return sum * depth;
    }

    private static int getElementValue(Object element, int depth) {
        if(isList(element)){
            return calculateProductSum(castToList(element), depth+1);
        }
        return castToInt(element);
    }

    private static boolean isList(Object element) {
        return element instanceof List;
    }

    private static List<Object> castToList(Object element) {
        return (List<Object>) element;
    }
    private static int castToInt(Object element) {
        return (int) element;
    }

}
