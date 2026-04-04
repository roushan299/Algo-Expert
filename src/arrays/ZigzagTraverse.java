package arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> result = new ArrayList<>();
        int rowLength = array.size();
        int columnLength = array.get(0).size();

        int row = 0;
        int column = 0;
        boolean isGoingDown = true;


        while (!isOutOfOrder(row, column, rowLength, columnLength)) {
            result.add(array.get(row).get(column));

            if(isGoingDown){
                if(isAtStartColumn(column) || isAtEndRow(row, rowLength)){
                  isGoingDown = false;

                  if(isAtEndRow(row, rowLength)){
                      column++;
                  }else {
                      row++;
                  }

                } else {
                    row++;
                    column--;
                }
            }else {
               if(isAtStartRow(row) || isAtEndColumn(column, columnLength)){
                isGoingDown = true;

                if(isAtEndColumn(column, columnLength)){
                    row++;
                }else {
                    column++;
                }

               }else{
                    row--;
                    column++;
                }
            }

        }

        return result;
    }

    public static boolean isOutOfOrder(int row, int column, int rowLength, int columnLength) {
        return row < 0 || row >= rowLength || column < 0 || column >= columnLength;
    }

    public static boolean isAtStartColumn(int column){
        return column == 0;
    }

    public static boolean isAtEndColumn(int column, int columnLength){
        return column == columnLength - 1;
    }

    public static boolean isAtStartRow(int row){
        return row == 0;
    }

    public static boolean isAtEndRow(int row, int rowLength){
        return row == rowLength - 1;
    }

}
