package dynamicPrograming;



public class LevenshteinDistance {


    public static int levenshteinDistance(String str1, String str2) {
        int[][] table = initializeTable(str1.length(), str2.length());
        fillBaseCase(table);

        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                table[row][col] = computeCell(table, str1, str2, row, col);
            }
        }

        return table[str1.length()][str2.length()];
    }

    private static int[][] initializeTable(int len1, int len2) {
        return new int[len1 + 1][len2 + 1];
    }

    private static void fillBaseCase(int[][] editsTable) {
        for(int i = 0; i < editsTable.length; i++){
            editsTable[i][0] = i;
        }
        for(int i = 0; i < editsTable[0].length; i++){
            editsTable[0][i] = i;
        }
    }
    private static int computeCell(int[][] table, String str1, String str2, int row, int col) {
        char ch1 = str1.charAt(row - 1);
        char ch2 = str2.charAt(col - 1);

        if (ch1 == ch2) {
            return table[row - 1][col - 1];
        }

        return 1 + minOfThree(
                table[row][col - 1],     // insert
                table[row - 1][col],     // delete
                table[row - 1][col - 1]  // replace
        );
    }

    private static int minOfThree(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
