package string;

import java.util.ArrayList;

public class ReverseWordsInString {

    public String reverseWordsInString(String string) {
        ArrayList<String> wordAndSpaces = splitWordsAndSpaces(string);
        reverseList(wordAndSpaces);
        return joinWordsAndSpaces(wordAndSpaces);
    }

    private String joinWordsAndSpaces(ArrayList<String> words) {
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word);
        }
        return sb.toString();
    }

    private void reverseList(ArrayList<String> list) {
        int start = 0;
        int end = list.size()-1;

        while(start<end){
            String temp = list.get(start);
            list.set(start,list.get(end));
            list.set(end,temp);
            start++;
            end--;
        }
    }

    private ArrayList<String> splitWordsAndSpaces(String string) {
        ArrayList<String> wordAndSpaces = new ArrayList<>();
        int startOfWord = 0;

        for(int idx=0;idx<string.length();idx++){
            char character = string.charAt(idx);

            if(character == ' '){
                if(startOfWord != idx){
                    wordAndSpaces.add(string.substring(startOfWord,idx));
                }
                wordAndSpaces.add(" ");
                startOfWord = idx+1;
            }
        }

        if(startOfWord < string.length()){
            wordAndSpaces.add(string.substring(startOfWord));
        }
        return wordAndSpaces;
    }


}
