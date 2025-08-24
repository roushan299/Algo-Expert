package arrays;

import java.util.List;

public class ValidateSubSequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
       int sequenceCount = 0;

       for(int idx = 0;idx<Math.min(array.size(), sequence .size());idx++){
           if(sequenceCount == sequence.size()){
               break;
           }
           if(array.get(idx) == sequence.get(sequenceCount)){
               sequenceCount++;
           }
       }
       return sequenceCount == sequence.size();
    }

}
