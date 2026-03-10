package stack;

import java.nio.file.attribute.AclFileAttributeView;
import java.util.Stack;

public class BalanceBrackets {

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char bracket = str.charAt(i);

            if(isOpeningBracket(bracket)){
                stack.push(bracket);
            } else if(isClosingBracket(bracket)){
                if(stack.isEmpty()){
                    return false;
                }
                    char open = stack.peek();
                    if(isMatchingPair(open, bracket)){
                        stack.pop();
                    }else {
                        return false;
                    }

            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch){
        return ch == '{' || ch == '[' || ch == '(';
    }

    private static boolean isClosingBracket(char ch){
        return ch == '}' || ch == ')' || ch == ']';
    }

    private static boolean isMatchingPair(char open, char close){
        return (open == '{' && close == '}') ||
                (open == '[' && close == ']') ||
                (open == '(' && close == ')');
    }

}
