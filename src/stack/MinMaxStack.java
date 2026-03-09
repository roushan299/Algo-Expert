package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinMaxStack {

    private  List<Integer> stack = new ArrayList<>();
    private  List<Integer> min = new ArrayList<>();
    private  List<Integer> max = new ArrayList<>();

    public int peek() {
        return this.stack.get(this.stack.size() - 1);
    }

    public int pop() {
        int value = peek();
        if(!max.isEmpty() && max.get(max.size()-1) == value){
            max.remove(max.size()-1);
        }

        if(!min.isEmpty() && min.get(min.size()-1) == value){
            min.remove(min.size()-1);
        }
        return stack.remove(stack.size()-1);
    }

    public void push(Integer number) {
        if(stack.isEmpty()){
            min.add(number);
            max.add(number);
        } else {
            if(number >= max.get(max.size() - 1)) {
                max.add(number);
            }
            if(number <= min.get((min.size()-1))){
                min.add(number);
            }
        }
        stack.add(number);
    }

    public int getMin() {
        return min.get(min.size()-1);
    }

    public int getMax() {
        return max.get(max.size()-1);
    }
}
