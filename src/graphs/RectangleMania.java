package graphs;

import java.util.HashSet;
import java.util.List;

public class RectangleMania {

    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point[] getPointList(List<Integer[]> coordinates){
            Point[] points = new Point[coordinates.size()];

            for(int i = 0; i < coordinates.size(); i++){
                Point point = new Point(coordinates.get(i)[0], coordinates.get(i)[1]);
                points[i] = point;
            }
            return points;
        }

        public boolean isDiagonal(Point point2) {
            return this.x !=  point2.x && this.y != point2.y;
        }

        @Override
        public String toString() {
            return this.x + ":" + this.y;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(x);
            result = 31 * result + Integer.hashCode(y);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(!(obj instanceof Point point)) return false;
            return this.x == point.x && this.y == point.y;
        }
    }

    public static int rectangleMania(List<Integer[]> coordinates) {
        Point[] points = Point.getPointList(coordinates);
        HashSet<Point> pointSet = getPointSet(points);
        int rectangleCount = 0;

        for(int index1 = 0; index1 < points.length; index1++){
            Point diagonalStart = points[index1];

            for(int index2 = index1+1; index2 < points.length; index2++){
                Point diagonalEnd = points[index2];

                // diagonal points
                if(diagonalStart.isDiagonal(diagonalEnd)){

                    if(pointSet.contains(new Point(diagonalStart.x, diagonalEnd.y)) &&
                            pointSet.contains(new Point(diagonalEnd.x,  diagonalStart.y))){
                        rectangleCount++;
                    }
                }
            }
        }

        return rectangleCount/2;
    }

    private static HashSet<Point> getPointSet(Point[] points) {
        HashSet<Point> pointSet = new HashSet<>();
        for(int i = 0; i < points.length; i++){
            pointSet.add(points[i]);
        }
        return pointSet;
    }

}
