package arrays;

public class WaterfallStreams {

    public double[] waterfallStreams(double[][] array, int source) {
        double[] rowAbove = copyRow(array, 0);
        rowAbove[source] = -1;

        for(int row = 1; row < array.length; row++){
            double[] currentRow = copyRow(array, row);
            processRow(rowAbove, currentRow);
            rowAbove = currentRow;
        }
        return buildFinalBuckets(rowAbove);
    }

    private double[] copyRow(double[][] array, int row) {
        double[] copiedRow = new double[array[row].length];
        for(int col = 0; col < array[row].length; col++){
            copiedRow[col] = array[row][col];
        }
        return copiedRow;
    }

    private void processRow(double[] rowAbove, double[] currentRow) {
        for(int col = 0;col < rowAbove.length;col++){
            double waterAbove = rowAbove[col];
            if(!hasWater(waterAbove)) continue;
            if(!hasBlock(currentRow, col)){
                flowDown(currentRow, col, waterAbove);
                continue;
            }
            splitWater(rowAbove, currentRow, col, waterAbove);
        }
        
    }
    private boolean hasWater(double value) {
        return value < 0;
    }

    private boolean hasBlock(double[] rows, int col) {
        return rows[col] == 1;
    }

    private void flowDown(double[] currentRow, int col, double waterAbove) {
        currentRow[col] += waterAbove;
    }

    private void splitWater(double[] rowAbove, double[] currentRow, int col, double waterAbove) {
        double splitWater = waterAbove/2.0;
        spreadRight(rowAbove, currentRow, col, splitWater);
        spreadLeft(rowAbove, currentRow, col, splitWater);
    }

    private void spreadRight(double[] rowAbove, double[] currentRow, int startCol, double water) {
        int col = startCol;

        while(col + 1 < rowAbove.length){
            col++;

            if(hasBlock(rowAbove, col)){
                break;
            }

            if(!hasBlock(currentRow, col)){
                currentRow[col] += water;
                break;
            }
        }
    }

    private void spreadLeft(double[] rowAbove, double[] currentRow, int startCol, double water) {
        int col = startCol;

        while (col - 1 >= 0){
            col--;
            if(hasBlock(rowAbove, col)){
                break;
            }
            if(!hasBlock(currentRow, col)){
                currentRow[col] += water;
                break;
            }
        }
    }


    private double[] buildFinalBuckets(double[] finalRow) {
        double[] buckets = new double[finalRow.length];
        for(int col = 0; col < finalRow.length; col++){
            buckets[col] = finalRow[col] < 0 ? -100*finalRow[col] : 0;
        }
        return buckets;
    }

}
