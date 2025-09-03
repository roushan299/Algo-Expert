package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        Set<String> seen = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(String word : words){
            String reverseWord = reverse(word);
            if(seen.contains(reverseWord) && !word.equals(reverseWord)){
                result.add(createPair(word, reverseWord));
            }
            seen.add(word);
        }
        return result;
    }

    private ArrayList<String> createPair(String word, String reverseWord){
        ArrayList<String> pair = new ArrayList<>();
        pair.add(word);
        pair.add(reverseWord);
        return pair;
    }

    private String reverse(String word){
        return new  StringBuilder(word).reverse().toString();
    }


}
