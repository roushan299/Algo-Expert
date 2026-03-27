package graphs;

public class SingleCycleCheck {
    public static boolean hasSingleCycle(int[] array) {
       int numElementsVisited = 0;
       int currentIndex = 0;

       while(numElementsVisited < array.length) {
           if(numElementsVisited > 0 && currentIndex == 0) return false;

           numElementsVisited +=1;
           currentIndex = getNextIdx(currentIndex, array);
       }
       return currentIndex == 0;
    }

    private static int getNextIdx(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

}
