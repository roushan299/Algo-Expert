package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class LineThroughPoints {

    public static class Coordinate{
        public int x;
        public int y;

        public Coordinate(int[] point){
            this.x = point[0];
            this.y = point[1];
        }

        public static ArrayList<Coordinate> getCoordinateList(int[][] points){
            ArrayList<Coordinate> coordinates = new ArrayList<>();

            for(int[] point: points){
                coordinates.add(new Coordinate(point));
            }
            return coordinates;
        }

        public String getSlope(Coordinate coordinate){
            int diffX = coordinate.x - this.x;
            int diffY = coordinate.y - this.y;

            int gcd = getGCD(diffX, diffY);

            diffX /= gcd;
            diffY /= gcd;

            // normalize sign
            if(diffX < 0){
                diffX *= -1;
                diffY *= -1;
            }

            // handle vertical line
            if(diffX == 0){
                diffY = 1;
            }

            // handle vertical line
            if(diffY == 0){
                diffX = 1;
            }
            return diffY + ":" + diffX;
        }

        private int getGCD(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0){
                int temp = b;
                b = a % b;
                a = temp;
            }
            return  a == 0 ? 1 : a;
        }


    }


    public int lineThroughPoints(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }

        ArrayList<Coordinate> coordinates = Coordinate.getCoordinateList(points);
        int maxPoints = 1;
        for(int firstIndex = 0; firstIndex < points.length; firstIndex++){
            Coordinate coordinate1 = coordinates.get(firstIndex);
            HashMap<String, Integer> slopeCount = new HashMap<>();
            int currentMax = 0;

            for(int secondIndex = firstIndex + 1; secondIndex < points.length; secondIndex++){
                Coordinate coordinate2 = coordinates.get(secondIndex);
                String slopeKey = coordinate1.getSlope(coordinate2);
                int updatedCount = slopeCount.getOrDefault(slopeKey, 1) + 1;
                slopeCount.put(slopeKey, updatedCount);
                currentMax = Math.max(currentMax, updatedCount);
            }
            maxPoints =   Math.max(maxPoints, currentMax);
        }
        return maxPoints;
    }


}
