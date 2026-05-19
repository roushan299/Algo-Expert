package searching;

public class OptimalAssemblyLine {

    public int optimalAssemblyLine(int[] stepDurations, int numStations) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for(int stepDuration: stepDurations) {
            right += stepDuration;
            left = Math.max(left, stepDuration);
        }

        int maxStationDuration = Integer.MAX_VALUE;

        while (left <= right) {
            int potentialMaxStationDuration = calculateMid(left, right);

            if(isPotentialSolution(stepDurations, numStations, potentialMaxStationDuration)){
                maxStationDuration = potentialMaxStationDuration;
                right = potentialMaxStationDuration - 1;
            }else {
                left = potentialMaxStationDuration + 1;
            }
        }
        return maxStationDuration;
    }

    private boolean isPotentialSolution(int[] stepDurations, int numStations, int potentialMaxStationDuration) {
        int stationRequired = 1;
        int currentDuration = 0;

        for(int stepDuration: stepDurations) {

            if(currentDuration + stepDuration > potentialMaxStationDuration){
                stationRequired ++;
                currentDuration = stepDuration;
            }else {
                currentDuration += stepDuration;
            }
        }

        return stationRequired <= numStations;
    }

    private int calculateMid(int left, int right) {
        return (left + right) / 2;
    }


}
