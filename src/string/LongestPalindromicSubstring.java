package string;

import java.sql.Statement;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String str) {
        String res = "";

        for(int mid = 0; mid < str.length(); mid++) {
            // odd length palindrome
            String odd = expandFromCenter(str, mid, mid);

            //even length palindrome
            String even = expandFromCenter(str, mid, mid + 1);

            String longer = getLongerString(odd, even);
            res = getLongerString(longer, res);
        }
        return res;
    }

    private static String getLongerString(String str1, String str2) {
        return str1.length() > str2.length() ? str1 : str2;
    }

    private static String expandFromCenter(String str, int left, int right) {

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left+1, right);
    }

}
