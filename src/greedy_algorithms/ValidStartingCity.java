package greedy_algorithms;

public class ValidStartingCity {
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int fuelLeft = 0;
        int startIndex = 0;

        for(int i = 0; i < distances.length; i++){
            fuelLeft += fuel[i]*mpg - distances[i];

            if(fuelLeft < 0){
                startIndex = i+1;
                fuelLeft = 0;
            }
        }
        return startIndex;
    }
}
