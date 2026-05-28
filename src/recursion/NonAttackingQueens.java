package recursion;

import java.util.HashSet;

public class NonAttackingQueens {
    
    
    public int nonAttackingQueens(int n) {
        HashSet<Integer> blockedColumns = new HashSet<Integer>();
        HashSet<Integer> blockedUpDiagonals = new HashSet<>();
        HashSet<Integer> blockedDownDiagonals = new HashSet<>();
        return getNumberOfAttackingQueenPlacements(0, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, n);
    }

    private int getNumberOfAttackingQueenPlacements(int row, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUpDiagonals, HashSet<Integer> blockedDownDiagonals, int boardSize) {
        if(row == boardSize) return 1;
        int validPlacements = 0;

        for(int col = 0; col < boardSize; col++) {
            if(isNonAttackingPlacements(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals)){
                placeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
                validPlacements += getNumberOfAttackingQueenPlacements(row+1, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, boardSize);
                removeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
            }
        }
        return validPlacements;
    }

    private boolean isNonAttackingPlacements(int row, int col, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUpDiagonals, HashSet<Integer> blockedDownDiagonals) {
        boolean sameColum = blockedColumns.contains(col);
        boolean inUpDiagonal = blockedUpDiagonals.contains(row+col);
        boolean inDownDiagonal = blockedDownDiagonals.contains(row - col);

        return !sameColum && !inUpDiagonal && !inDownDiagonal;
    }

    private void placeQueen(int row, int col, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUpDiagonals, HashSet<Integer> blockedDownDiagonals) {
        blockedColumns.add(col);
        blockedUpDiagonals.add(row+col);
        blockedDownDiagonals.add(row-col);
    }

    private void removeQueen(int row, int col, HashSet<Integer> blockedColumns, HashSet<Integer> blockedUpDiagonals, HashSet<Integer> blockedDownDiagonals) {
        blockedColumns.remove(col);
        blockedUpDiagonals.remove(row+col);
        blockedDownDiagonals.remove(row-col);
    }

//    public int nonAttackingQueens(int n) {
//        int[] columnPlacements = new  int[n];
//        return getNumberOfNonAttackingPlacementQueen(0, columnPlacements, n);
//    }
//
//    private int getNumberOfNonAttackingPlacementQueen(int row, int[] columnPlacements, int boardSize) {
//
//        if(row == boardSize) return 1;
//
//        int validPlacement = 0;
//
//        for(int col=0;col<boardSize;col++){
//            
//            if(isNonAttackingPlacement(row, col, columnPlacements)){
//                columnPlacements[row] = col;
//                validPlacement += getNumberOfNonAttackingPlacementQueen(row + 1, columnPlacements, boardSize);
//            }
//        }
//        return validPlacement;
//    }
//
//    private boolean isNonAttackingPlacement(int row, int col, int[] columnPlacements) {
//
//        for(int previousRow = 0;previousRow < row;previousRow++){
//            int columnToCheck = columnPlacements[previousRow];
//            boolean sameColumn = columnToCheck == col;
//            boolean onDiagonal = Math.abs(columnToCheck - col) == Math.abs(row - previousRow);
//            if(sameColumn || onDiagonal) return false;
//        }
//        return true;
//    }


}
