package string;

import java.util.Stack;

public class LongestBalancedSubstring {

    private static final Character OPEN_BRACKET = '(';
    private static final Character CLOSE_BRACKET = ')';

    public int longestBalancedSubstring(String string) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for(int index = 0;index<string.length();index++){
            if(OPEN_BRACKET == string.charAt(index)){
                stack.push(index);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(index);
                }else {
                    maxLength = Math.max(maxLength, index-stack.peek());
                }
            }
        }
        return maxLength;
    }

//    public int longestBalancedSubstring(String string) {
//        int longest = 0;
//        for(int left = 0; left < string.length(); left++){
//            for(int right = left+1; right <= string.length(); right++){
//                String subString = string.substring(left, right);
//                if(isBalanced(subString)){
//                    longest = Math.max(longest, right - left);
//                }
//            }
//        }
//        return longest;
//    }
//
//    private boolean isBalanced(String subString) {
//        Stack<Character> stack = new Stack<>();
//
//        for(int index = 0; index < subString.length(); index++){
//            char bracket =  subString.charAt(index);
//            if(OPEN_BRACKET == bracket){
//                stack.push(bracket);
//            }else if(CLOSE_BRACKET == bracket){
//                if(!stack.isEmpty()){
//                    stack.pop();
//                }else {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

}
