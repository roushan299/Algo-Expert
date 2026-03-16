package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for(int idx=0;idx<2*n;idx++){
            int circularIdx = idx % n;

            while(stack.size() > 0 && array[stack.peek()] < array[circularIdx]){
                int top = stack.pop();
                result[top] = array[circularIdx];
            }

            stack.push(circularIdx);
        }
        return result;
    }
}
