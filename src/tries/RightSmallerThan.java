package tries;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    static class SpecialBST{
        int value;
        int leftSubTreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value){
            this.value = value;
            this.leftSubTreeSize = 0;
        }

        public void insert(int value, int idx, List<Integer> result, int numSmallerAtInsertTime){
            if(value < this.value){
                leftSubTreeSize++;

                if(left == null){
                    left = new  SpecialBST(value);
                    result.set(idx, numSmallerAtInsertTime);
                }else {
                    left.insert(value, idx, result, numSmallerAtInsertTime);
                }
            }else {
                numSmallerAtInsertTime += leftSubTreeSize;

                if(value > this.value) numSmallerAtInsertTime++;

                if(right == null){
                    right = new  SpecialBST(value);
                    result.set(idx, numSmallerAtInsertTime);
                }else {
                    right.insert(value, idx, result, numSmallerAtInsertTime);
                }
            }
        }

    }

    public static List<Integer> rightSmallerThan(List<Integer> array){

        if(array == null || array.isEmpty()) return new  ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) result.add(0);

        SpecialBST bst = new SpecialBST(array.get(array.size()-1));

        for(int i=array.size()-2; i>=0; i--){
            bst.insert(array.get(i), i, result, 0);
        }
        return result;
    }









//    public static List<Integer> rightSmallerThan(List<Integer> array) {
//        List<Integer> rightSmallerThan = new ArrayList<>();
//
//        for(int i = 0; i < array.size(); i++) {
//            int count = 0;
//            for(int j = i+1; j < array.size(); j++) {
//                if(array.get(i) > array.get(j)) count++;
//            }
//            rightSmallerThan.add(count);
//        }
//        return rightSmallerThan;
//    }


}
