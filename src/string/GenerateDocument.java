package string;

import java.util.HashMap;

public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {

        HashMap<Character, Integer> characterIntegerHashMap = getFrequencyCharMap(characters);
        HashMap<Character, Integer> documentIntegerHashMap = getFrequencyCharMap(document);

        for(Character key: documentIntegerHashMap.keySet()){
            if(!characterIntegerHashMap.containsKey(key)){
                return false;
            }
            if(characterIntegerHashMap.get(key) < documentIntegerHashMap.get(key)){
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> getFrequencyCharMap(String str){
        HashMap<Character, Integer> frequencyCharMap = new HashMap<>();

        for(Character key: str.toCharArray()){
            frequencyCharMap.put(key, frequencyCharMap.getOrDefault(key, 0)+1);
        }
        return frequencyCharMap;
    }

}
