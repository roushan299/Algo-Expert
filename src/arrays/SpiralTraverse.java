package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static List<Integer> spiralTraverse( int[][] array) {
        int startRow = 0;
        int endRow = array.length-1;
        int startCol = 0;
        int endCol = array[0].length-1;
        List<Integer> elementList = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol){

            for(int i=startCol;i<=endCol;i++){
                elementList.add(array[startRow][i]);
            }
            startRow ++;

            for(int j=startRow;j<=endRow;j++){
                elementList.add(array[j][endCol]);
            }
            endCol--;

            if(startRow <= endRow) {
                for ( int k = endCol; k >= startCol; k-- ) {
                    elementList.add( array[endRow][k] );
                }
                endRow--;
            }

            if(startCol <= endCol) {
                for ( int l = endRow; l >= startRow; l-- ) {
                    elementList.add( array[l][startCol] );
                }
                startCol++;
            }
        }

        return elementList;
    }
}
