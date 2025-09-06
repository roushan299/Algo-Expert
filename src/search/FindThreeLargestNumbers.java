package search;

public class FindThreeLargestNumbers {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargestNumbers = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : array) {
            updateLargest(threeLargestNumbers, num);
        }
        return threeLargestNumbers;
    }

    private static void updateLargest(int[] threeLargestNumbers, int num) {
        if (threeLargestNumbers[2] < num) {
            shiftAndUpdate(threeLargestNumbers, num, 2);
        } else if (threeLargestNumbers[1] < num) {
            shiftAndUpdate(threeLargestNumbers, num, 1);
        } else if (threeLargestNumbers[0] < num) {
            shiftAndUpdate(threeLargestNumbers, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] threeLargestNumbers, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (index == i) {
                threeLargestNumbers[i] = num;
            } else {
                threeLargestNumbers[i] = threeLargestNumbers[i + 1];
            }
        }
    }
}
