package arrays;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightConnection {

    static class Coordinate{
        public int x;
        public int y;
        public int move;

        public Coordinate(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }

        public boolean checkMate(Coordinate coordinate){
            return coordinate.x == this.x && coordinate.y == this.y;
        }

        @Override
        public String toString() {
            return this.x+"|"+this.y;
        }
    }

    private static final int[][] directions = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};


    public int knightConnection(int[] knightA, int[] knightB) {
        Coordinate start = new  Coordinate(knightA[0], knightA[1], 1);
        Coordinate target = new  Coordinate(knightB[0], knightB[1], 0);

        Queue<Coordinate> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start.toString());

        while(!queue.isEmpty()){
            Coordinate coordinate = queue.poll();

            if(target.checkMate(coordinate)){
                return coordinate.move/2;
            }
            addNextMove(queue, coordinate, visited);
        }
        return -1;
    }

    private void addNextMove(Queue<Coordinate> queue, Coordinate coordinate, Set<String> visited) {
        int move = coordinate.move + 1;
        for(int[] direction : directions){
            int nextX = coordinate.x + direction[0];
            int nextY = coordinate.y + direction[1];
            Coordinate nextCoordinate = new Coordinate(nextX, nextY, move);
            if(visited.contains(nextCoordinate.toString())) continue;
            visited.add(nextCoordinate.toString());
            queue.add(nextCoordinate);
        }
    }
}
