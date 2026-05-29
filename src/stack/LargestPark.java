package stack;

import java.util.Stack;

public class LargestPark {

    public int largestPark(boolean[][] land) {
        int[] heights = new  int[land[0].length];
        int maxArea = 0;

        for(int row=0;row<land.length;row++){
            for(int col=0;col<land[0].length;col++){
                heights[col] = isOccupied(land, row, col) ? 0 : heights[col]+1;
            }
            maxArea = Math.max(maxArea, largestRectangleHistogram(heights));
        }
        return maxArea;
    }

    private int largestRectangleHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int columnIndex = 0; columnIndex < heights.length; columnIndex++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[columnIndex]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? columnIndex : columnIndex-stack.peek()-1;
                maxArea = Math.max(maxArea, width*height);
            }
            stack.push(columnIndex);
        }

        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, width*height);
        }
        return maxArea;
    }

    private boolean isOccupied(boolean[][] land, int row, int col) {
        return land[row][col];
    }


}
