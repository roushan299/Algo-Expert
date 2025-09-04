package string;

public class LongestPalindromicSubString {

    public static String longestPalindromicSubstring(String str) {
        if(isInvalidInput(str)){
            return str;
        }
        int[] strIndexes = new int[]{0, 0};

        for(int i=0;i<str.length();i++){
            int[] odd = findPalindromeBetween(str, i-1, i+1);
            int[] even = findPalindromeBetween(str, i-1, i);

            int[] greaterBetweenTwo = longerSubString(even, odd);
            strIndexes =  longerSubString(strIndexes, greaterBetweenTwo);
        }
        return  str.substring(strIndexes[0], strIndexes[1]+1);
    }

    private static int[] longerSubString(int[] first, int[] second) {
        return (second[1] - second[0]) > (first[1] - first[0]) ? second : first;
    }

    private static boolean isInvalidInput(String str) {
        return str == null || str.length() <=1;
    }

    private static int[] findPalindromeBetween(String str, int left, int right) {

        while (left >=0 && right < str.length() ){
            if(str.charAt(left) != str.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return new int[]{left+1, right-1};
    }


}
