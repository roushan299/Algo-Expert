package string;

public class ReverseWordString {
    public String reverseWordsInString(String string) {
        if(string == null || string.isEmpty()){
            return string;
        }

        char[] charArray = string.toCharArray();
        reverse(charArray, 0, charArray.length-1);

        int start = 0;

        for(int i = 0; i <= charArray.length; i++){
            if(i == charArray.length || charArray[i] == ' '){
                reverse(charArray, start, i-1);
                start = i+1;
            }
        }
        return String.valueOf(charArray);
    }

    private void reverse(char[] charArray, int start, int end){
        while(start < end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
