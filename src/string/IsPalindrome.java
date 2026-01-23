package string;

public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = getLastIndex(str);

        while (shouldContinue(left, right)){
            if(!isMatching(str, left, right)){
                return false;
            }
            left = moveLeft(left);
            right = moveRight(right);
        }
        return true;
    }

    private static int moveRight(int right) {
        return right - 1;
    }

    private static int moveLeft(int left) {
        return left + 1;
    }

    private static boolean isMatching(String str, int left, int right) {
        return  str.charAt(left) == str.charAt(right);
    }

    private static boolean shouldContinue(int left, int right) {
        return left < right;
    }

    private static int getLastIndex(String str) {
        return str.length() - 1;
    }
}
