package stack;

import java.util.Stack;

public class BestDigits {

    public String bestDigits(String number, int numDigits) {
        Stack<Character> stack = buildStack(number, numDigits);
        return buildResult(stack);
    }

    private String buildResult(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for(char digit: stack){
            sb.append(digit);
        }
        return sb.toString();
    }

    private Stack<Character> buildStack(String number, int numDigits) {
        Stack<Character> stack = new Stack<>();

        for(char digit: number.toCharArray()) {
            numDigits = removeSmallerDigits(stack, digit, numDigits);
            stack.push(digit);
        }

        removeRemainingDigits(stack, numDigits);
        return stack;
    }

    private void removeRemainingDigits(Stack<Character> stack, int numDigits) {
        while(!stack.isEmpty() && numDigits > 0){
            stack.pop();
            numDigits--;
        }
    }

    private int removeSmallerDigits(Stack<Character> stack, char digit, int numDigits) {
        
        while(!stack.isEmpty() && numDigits > 0 && stack.peek() < digit) {
            stack.pop();
            numDigits--;
        }
        
        return numDigits;
    }

}
