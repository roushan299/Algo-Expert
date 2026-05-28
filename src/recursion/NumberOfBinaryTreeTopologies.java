package recursion;

import java.util.HashMap;

public class NumberOfBinaryTreeTopologies {

    public static int numberOfBinaryTreeTopologies(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return numberOfBinaryTreeTopologies(n, cache);
    }

    public static int numberOfBinaryTreeTopologies(int n, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(n)) return cache.get(n);

        int numberOfTrees = 0;

        for(int leftTreesSize = 0; leftTreesSize <n; leftTreesSize++){
            int rightTreesSize = n-1-leftTreesSize;
            int numberOfLeftTrees = numberOfBinaryTreeTopologies(leftTreesSize, cache);
            int numberOfRightTrees = numberOfBinaryTreeTopologies(rightTreesSize, cache);
            numberOfTrees += numberOfLeftTrees * numberOfRightTrees;
        }
        cache.put(n, numberOfTrees);
        return numberOfTrees;
    }




//    public static int numberOfBinaryTreeTopologies(int n) {
//
//        if(n == 0){
//            return 1;
//        }
//
//        int numberOfTress = 0;
//        for(int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++){
//            int rightTreeSize = n - 1 - leftTreeSize;
//            int numberOfLeftTress = numberOfBinaryTreeTopologies(leftTreeSize);
//            int numberOfRightTress = numberOfBinaryTreeTopologies(rightTreeSize);
//            numberOfTress = numberOfTress+numberOfLeftTress + numberOfRightTress;
//        }
//        return numberOfTress;
//    }

}
