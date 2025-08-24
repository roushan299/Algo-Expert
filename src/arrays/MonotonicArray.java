package arrays;

public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        if (array.length <= 1) {
            return true;
        }

        String mode = detectInitialMode(array);
        return checkMonotonic(array, mode);
    }

    private static String detectInitialMode(int[] array) {
        return array[0] <= array[array.length - 1] ? "Non-Decreasing" : "Non-Increasing";
    }

    private static boolean checkMonotonic(int[] array, String mode) {
        for (int i = 1; i < array.length; i++) {
            if ("Non-Decreasing".equals(mode) && array[i - 1] > array[i]) {
                return false;
            } else if ("Non-Increasing".equals(mode) && array[i - 1] < array[i]) {
                return false;
            }
        }
        return true;
    }
}
