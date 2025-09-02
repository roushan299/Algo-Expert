package arrays;

public class BestSeat {
    public int bestSeat(int[] seats) {
        int bestSeat = -1;
        int lastOccupied = 0;
        int maxSpace = 1;

        for(int i=1;i<seats.length;i++){
            if(seats[i] == 1){
                int space = i - lastOccupied;
                if(space > maxSpace){
                    maxSpace = space;
                    bestSeat = findMidSeat(lastOccupied, i);
                }
                lastOccupied = i;
            }
        }
        return bestSeat;
    }


    public int findMidSeat(int leftOccupied, int rightOccupied) {
        return (leftOccupied+rightOccupied)/2;
    }
}
