package string;

import java.util.HashMap;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {
        if(document.isEmpty()) return true;
        if(characters.isEmpty()) return false;

        HashMap<Character, Integer> charCount = buildFrequencyMap(characters);
        return canFormDocument(document, charCount);
    }

    private boolean canFormDocument(String document, HashMap<Character, Integer> charCount) {
        for(char c : document.toCharArray()){
            int count = charCount.getOrDefault(c, 0);
            if(count == 0){
                return false;
            }
            charCount.put(c, count - 1);
        }
        return true;
    }

    private HashMap<Character, Integer> buildFrequencyMap(String characters) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char c : characters.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }




}
