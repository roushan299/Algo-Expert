package dynamicPrograming;

public class MaximizeExpression {

    public int maximizeExpression(int[] array) {
        if(array == null || array.length < 4) return 0;

        int n = array.length;

        int[] maxA = new int[n];
        int[] maxAMinusB = new int[n];
        int[] maxAMinusBPlusC = new int[n];
        int[] maxAMinusBPlusCMinusD = new int[n];

        maxA[0] = array[0];
        for(int i = 1; i < n; i++){
            maxA[i] = Math.max(array[i], maxA[i-1]);
        }

        maxAMinusB[1] = maxA[0]-array[1];
        for(int i = 2; i < n; i++){
            maxAMinusB[i] = Math.max(maxAMinusB[i-1], maxA[i-1]-array[i]);
        }

        maxAMinusBPlusC[2] = maxAMinusB[1]+array[2];
        for(int i = 3; i < n; i++){
            maxAMinusBPlusC[i] = Math.max(maxAMinusBPlusC[i-1], maxAMinusB[i-1]+array[i]);
        }

        maxAMinusBPlusCMinusD[3] = maxAMinusBPlusC[2]-array[3];
        for(int i = 4; i < n; i++){
            maxAMinusBPlusCMinusD[i] = Math.max(maxAMinusBPlusCMinusD[i-1], maxAMinusBPlusC[i-1]-array[i]);
        }

        return maxAMinusBPlusCMinusD[n-1];
    }


//    public int maximizeExpression(int[] array) {
//        if(array == null || array.length < 3) return 0;
//        int maxSum = Integer.MIN_VALUE;
//
//        for(int indexA = 0; indexA < array.length-3; indexA++){
//            for(int indexB = indexA+1; indexB < array.length-2; indexB++){
//                for(int indexC = indexB+1; indexC < array.length-1; indexC++){
//                    for(int indexD = indexC+1; indexD < array.length; indexD++){
//                       int currentSum = evaluateExpression(array, indexA, indexB, indexC, indexD);
//                       maxSum = Math.max(maxSum, currentSum);
//                    }
//                }
//            }
//
//        }
//        return maxSum == Integer.MIN_VALUE ? 0 : maxSum;
//    }
//
//    private int evaluateExpression(int[] array, int a,  int b, int c, int d){
//        return array[a] - array[b] + array[c] - array[d];
//    }
}
