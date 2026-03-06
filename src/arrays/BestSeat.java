package arrays;

public class BestSeat {
    public int bestSeat(int[] seats) {
        int bestSeat = -1;
        int maxSpace = 0;
        int left = 0;

        while (left < seats.length) {
            int right = findNextOccupiedSeat(seats, left+1);
            int availableSpace = calculateAvailableSpace(left, right);
            
            if (availableSpace > maxSpace) {
                maxSpace = availableSpace;
                bestSeat = findMiddleSeat(left, right);
            }
            left = right;
        }

        return bestSeat;
    }

    private int findMiddleSeat(int left, int right) {
        return (left + right)/2;
    }

    private int calculateAvailableSpace(int left, int right) {
        return right - left - 1;
    }

    private int findNextOccupiedSeat(int[] seats, int start) {
        int index = start;

        while (index < seats.length && !isOccupied(seats, index)) {
            index++;
        }
        return index;
    }

    private boolean isOccupied(int[] seats, int index) {
        return seats[index] == 1;
    }
}
