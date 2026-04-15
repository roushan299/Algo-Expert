package recursion;

import java.util.ArrayList;

public class SolveSudoku {

    public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        solvePartialSudoku(board, 0, 0);
        return board;
    }

    private boolean solvePartialSudoku(ArrayList<ArrayList<Integer>> board, int row, int col) {
        int currentRow = row;
        int currentCol = col;
        
        if(col == board.size()) {
            currentRow += 1;
            currentCol = 0;
            
            if(currentRow == board.size()) {
                return true;
            }
        }
        
        if(board.get(currentRow).get(currentCol) == 0) {
            return tryDigitAtPosition(currentRow, currentCol, board);
        }
        return solvePartialSudoku(board, currentRow, currentCol+1);
    }

    private boolean tryDigitAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {

        for(int digit = 1; digit < 10; digit++) {
            if(isValidAtPosition(board, row, col, digit)) {
                board.get(row).set(col, digit);
                if(solvePartialSudoku(board, row, col+1)) {
                    return true;
                }
            }
            board.get(row).set(col, 0);
        }

        return false;
    }

    private boolean isValidAtPosition(ArrayList<ArrayList<Integer>> board, int row, int col, int value) {
        boolean rowIsValid = isRowValid(board, row, value);
        boolean colIsValid = isColValid(board, col, value);

        if(!rowIsValid || !colIsValid)  return false;

        int subGridRowStart =  row / 3;
        int subGridColStart = col / 3;

        for(int rowIdx = 0; rowIdx < 3; rowIdx++){
            for(int colIdx = 0;colIdx < 3;colIdx++){
                int rowToCheck = subGridRowStart * 3 + rowIdx;
                int colToCheck = subGridColStart * 3 + colIdx;
                int existingValue = board.get(rowToCheck).get(colToCheck);

                if(existingValue == value) return false;
            }
        }
        return true;
    }

    private boolean isColValid(ArrayList<ArrayList<Integer>> board, int col, int value) {
        for(int roWIdx = 0; roWIdx < 9; roWIdx++){
            int exitingValue = board.get(roWIdx).get(col);
            if(exitingValue == value) return false;
        }
        return true;
    }

    private boolean isRowValid(ArrayList<ArrayList<Integer>> board, int row, int value) {

        for(int colIdx = 0; colIdx < 9; colIdx++){
            int exitingValue = board.get(row).get(colIdx);
            if(exitingValue == value) return false;
        }
        return true;
    }
}
