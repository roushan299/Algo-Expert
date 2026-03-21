package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RevealMinesweeper {

    public String[][] revealMinesweeper(String[][] board, int row, int column) {
        if(isMine(board, row, column)) {
            setCell(board, row, column, "X");
            return board;
        }
        ArrayList<int[]> neighbours = getDirections(board, row, column);
        int mineCount = countAdjacentMines(board, neighbours);

        if(mineCount > 0){
            setCell(board, row, column, String.valueOf(mineCount));
            return board;
        }
        setCell(board, row, column, "0");

        for(int[] neighbour : neighbours){
            if(isHidden(board, neighbour[0], neighbour[1])) {
                revealMinesweeper(board, neighbour[0], neighbour[1]);
            }
        }
        return board;
    }


    private void setCell(String[][] board, int row, int column, String value) {
        board[row][column] = value;
    }

    private int countAdjacentMines(String[][] board, ArrayList<int[]> neighbours) {
        int mineCount = 0;

        for(int[]  neighbour : neighbours){
            if(isMine(board, neighbour[0], neighbour[1])) mineCount++;
        }
        return mineCount;
    }

    private boolean isMine(String[][] board, int row, int column) {
        return board[row][column].equals("M");
    }

    private boolean isHidden(String[][] board, int row, int column) {
        return board[row][column].equals("H");
    }

    private ArrayList<int[]> getDirections(String[][] board, int row, int column) {
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0},
                                         {1,1}, {-1,-1}, {1,-1}, {-1,1}};

        ArrayList<int[]> neighbours = new ArrayList<>();

        for(int index = 0; index < directions.length; index++) {
            int newRow = row + directions[index][0];
            int newColumn = column + directions[index][1];

            if(isValidRow(newRow, board) && isValidColumn(newColumn, board)){
                neighbours.add(new int[]{newRow, newColumn});
            }
        }
        return neighbours;
    }

    private boolean isValidRow(int row, String[][] board) {
        return row >= 0 && row < board.length;
    }

    private boolean isValidColumn(int column, String[][] board) {
        return column >= 0 && column < board[0].length;
    }


}
