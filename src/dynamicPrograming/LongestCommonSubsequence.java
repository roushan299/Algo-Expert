package dynamicPrograming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {


    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        List<Character> result = new ArrayList<>();

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = str1.length();
        int j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
               result.add(0, str1.charAt(i-1));
               i--;
               j--;
            }else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }
        return result;
    }


//    public static List<Character> longestCommonSubsequence(String str1, String str2) {
//        String[][] dpStr = new String[str1.length()+1][str2.length()+1];
//
//        for(int i = 0; i < dpStr.length; i++) {
//            dpStr[i][0] = "";
//        }
//
//        for(int i = 0; i < dpStr[0].length; i++) {
//            dpStr[0][i] = "";
//        }
//
//        for(int i = 1; i < dpStr.length; i++) {
//            for(int j = 1; j < dpStr[0].length; j++) {
//                if(str1.charAt(i-1) == str2.charAt(j-1)) {
//                    dpStr[i][j] = dpStr[i-1][j-1] + str1.charAt(i-1);
//                }else {
//                    int length1 = dpStr[i-1][j].length();
//                    int length2 = dpStr[i][j-1].length();
//                    dpStr[i][j] = length1 > length2 ? dpStr[i-1][j] : dpStr[i][j-1];
//                }
//            }
//        }
//
//        String str = dpStr[str1.length()][str2.length()];
//
//        List<Character> list = new ArrayList<>();
//        for(int i = 0; i < str.length(); i++) {
//            list.add(str.charAt(i));
//        }
//        return list;
//    }

}
