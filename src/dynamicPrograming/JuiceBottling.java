package dynamicPrograming;

import java.util.ArrayList;

public class JuiceBottling {


    public ArrayList<Integer> juiceBottling(int[] prices){
        int n = prices.length;
        int[] maxProfit = new int[n];
        int[] dividingPoints = new int[n];


        for(int size = 1; size < n; size++){
            maxProfit[size] = prices[size];
            dividingPoints[size] = size;

            for(int cut = 1; cut < size; cut++){
                int possibleProfit = prices[cut] + maxProfit[size - cut];

                if(possibleProfit > maxProfit[size]){
                    maxProfit[size] = possibleProfit;
                    dividingPoints[size] = cut;
                }
            }
        }

        ArrayList<Integer> solution = new ArrayList<>();
        int size = n - 1;

        while(size > 0){
            int piece = dividingPoints[size];
            solution.add(piece);
            size -= piece;
        }
        return solution;
    }




//    public ArrayList<Integer> juiceBottling(int[] prices) {
//        int n = prices.length;
//
//        int[] maxProfit = new int[n];
//        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            solutions.add(new ArrayList<>());
//        }
//
//        for(int size = 1; size < n; size++){
//            maxProfit[size] = prices[size];
//            ArrayList<Integer> best = new  ArrayList<>();
//            best.add(size);
//
//            for(int cut = 1; cut < size; cut++){
//                int profit = prices[cut] + maxProfit[size-cut];
//
//                if(profit > maxProfit[size]){
//                    maxProfit[size] = profit;
//
//                    best = new  ArrayList<>();
//                    best.add(cut);
//                    best.addAll(solutions.get(size - cut));
//                }
//            }
//            solutions.set(size, best);
//        }
//        return solutions.get(n-1);
//    }

}
