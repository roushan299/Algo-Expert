package stack;

import java.util.Stack;

public class CollidingAsteroids {

    public int[] collidingAsteroids(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();

        for(int asteroid : asteroids){
            processAsteroid(stack, asteroid);
        }

        return convertStackToArray(stack);
    }

    private int[] convertStackToArray(Stack<Integer> stack) {

        return  stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private void processAsteroid(Stack<Integer> stack, int asteroid) {

        boolean destroyed = false;

        while(!stack.isEmpty() && isCollision(stack.peek(), asteroid)){
            int result = resolveCollision(stack.peek(), asteroid);

            if(result == 0){
                stack.pop();
                destroyed = true;
                break;
            } else if (result == stack.peek()) {
                destroyed = true;
                break;
            }else {
                stack.pop();
            }
        }

        if(!destroyed){
            stack.push(asteroid);
        }
    }

    private int resolveCollision(int prev, int curr) {
        int absPrev = Math.abs(prev);
        int absCurr = Math.abs(curr);

        if(absPrev == absCurr) return 0;

        return absPrev > absCurr ? prev : curr;
    }

    private boolean isCollision(Integer prev, int curr) {
        return prev > 0 && curr < 0;
    }

}
