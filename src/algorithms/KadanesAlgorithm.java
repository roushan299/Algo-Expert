package algorithms;

public class KadanesAlgorithm {
    public static int kadanesAlgorithm(int[] array) {
        int currentMax = initialize(array);
        int globalMax = currentMax;

        for(int i = 1; i < array.length; i++){
            currentMax = calculateCurrentMax(currentMax, array[i]);
            globalMax = updateGlobalMax(globalMax, currentMax);
        }
        return globalMax;
    }

    private static int initialize(int[] array){
        return array[0];
    }

    private static int calculateCurrentMax(int prevMax, int currentElement){
        return Math.max(currentElement, currentElement+prevMax);
    }

    private static int updateGlobalMax(int globalMax, int currentMax){
        return Math.max(currentMax, globalMax);
    }
}
