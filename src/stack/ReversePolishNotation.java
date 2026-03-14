package stack;

import java.util.Stack;

public class ReversePolishNotation {

    public int reversePolishNotation(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){

            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();

                int result = solve(a, b, token);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int solve(int a, int b, String operator){

        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    private boolean isOperator(String token){
        return "+-*/".contains(token);
    }
}
