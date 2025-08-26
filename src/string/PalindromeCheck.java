package string;
public class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        int leftIdx = 0;
        int rightIdx = str.length()-1;
        while (leftIdx <= rightIdx){
            if(str.charAt(leftIdx) != str.charAt(rightIdx)){
                return false;
            }else {
                leftIdx++;
                rightIdx--;
            }
        }
        return true;
    }
}
