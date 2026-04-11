package stack;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleUnderSkyline {

    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        Stack<Integer> pillarIndices = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<=buildings.size();i++){
            int height = (i == buildings.size()) ? 0 : buildings.get(i);

            while (!pillarIndices.isEmpty() && height < buildings.get(pillarIndices.peek())) {
                int h = buildings.get(pillarIndices.pop());
                int width = pillarIndices.isEmpty() ? i : i- pillarIndices.peek() -1;
                maxArea = Math.max(maxArea, h * width);
            }
            pillarIndices.push(i);
        }
        return maxArea;
    }


//    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
//       int maxArea = 0;
//
//       for(int pillarIdx =0;pillarIdx<buildings.size();pillarIdx++){
//           int currentHeight = buildings.get(pillarIdx);
//
//           int furthestLeft = pillarIdx;
//
//           while (furthestLeft > 0 && buildings.get(furthestLeft-1) >= currentHeight){
//               furthestLeft--;
//           }
//
//           int furthestRight = pillarIdx;
//
//           while (furthestRight < buildings.size()-1 && buildings.get(furthestRight+1) >= currentHeight){
//               furthestRight++;
//           }
//           int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1)* currentHeight;
//           maxArea = Math.max(maxArea, areaWithCurrentBuilding);
//        }
//        return maxArea;
//    }

//
//    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
//        int maxArea = 0;
//
//        for(int i=0; i<buildings.size(); i++) {
//            int minHeight = Integer.MAX_VALUE;
//
//            for(int j=i;j<buildings.size();j++) {
//                minHeight = Math.min(minHeight, buildings.get(j));
//                int width = j-i+1;
//                maxArea = Math.max(maxArea, width*minHeight);
//            }
//        }
//        return maxArea;
//    }

//    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
//        int maxArea = 0;
//
//        for(int i=0; i<buildings.size(); i++) {
//            for(int j=0; j<=i; j++) {
//                int height = getMinHeight(buildings, j, i);
//                int width = i-j+1;
//                int area = height*width;
//                maxArea = Math.max(area, maxArea);
//            }
//        }
//        return maxArea;
//    }
//
//    private int getMinHeight(ArrayList<Integer> buildings, int start, int end) {
//        int height = Integer.MAX_VALUE;
//        for(int k=start; k<=end; k++) {
//            height = Math.min(height, buildings.get(k));
//        }
//        return height;
//    }

}
