package stack;

import java.util.ArrayList;
import java.util.Stack;


public class SortStack {

    public ArrayList<Integer> sortStack(ArrayList<Integer> array) {
        Stack<Integer> stack = new Stack<>();

        for(int num : array){
            stack.push(num);
        }
        sort(stack);
        return new  ArrayList<>(stack);
    }

    private void sort(Stack<Integer> stack){
        if(stack.isEmpty()) return;

        int top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    private  void insert(Stack<Integer> stack, int value){

        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);
            return;
        }

        int top = stack.pop();
        insert(stack,value);
        stack.push(top);
    }

}
