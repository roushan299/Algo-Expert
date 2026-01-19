package arrays;

import java.util.List;

public class ValidSubSequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int pos = 0;

        for(int i = 0; i < array.size(); i++) {
            if(sequence.size() > pos && (array.get(i) ==  sequence.get(pos))) {
                pos++;
            }
        }
        return sequence.size()-1 == pos;
    }
}
