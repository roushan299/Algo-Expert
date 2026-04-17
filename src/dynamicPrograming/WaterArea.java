package dynamicPrograming;

public class WaterArea {

    public static int waterArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int[] leftMax = getLeftMaxArr(heights);
        int[] rightMax = getRightMaxArr(heights);

        int totalWater = 0;

        for(int i = 0; i < heights.length; i++){
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            int height = heights[i];

            if(height < minHeight){
                totalWater += minHeight - height;
            }

        }
        return totalWater;
    }

    private static int[] getRightMaxArr(int[] heights) {
        int[] rightMaxArr = new int[heights.length];
        rightMaxArr[heights.length - 1] = heights[heights.length - 1];

        for (int i = heights.length - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(rightMaxArr[i + 1], heights[i]);
        }
        return rightMaxArr;
    }

    private static int[] getLeftMaxArr(int[] heights) {
        int[] leftMaxArr = new int[heights.length];
        leftMaxArr[0] = heights[0];

        for(int i = 1; i < heights.length; i++){
            leftMaxArr[i] = Math.max(leftMaxArr[i-1], heights[i]);
        }
        return leftMaxArr;
    }

}
