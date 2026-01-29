package string;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> frequencyCharMap = buildFrequencyCharMap(string);
        return findFirstUniqueIndex(frequencyCharMap, string);
    }

    private HashMap<Character, Integer> buildFrequencyCharMap(String string){
        HashMap<Character, Integer> frequencyCharMap = new HashMap<>();

        for(int i=0;i<string.length();i++){
            char key = string.charAt(i);
            frequencyCharMap.put(key, frequencyCharMap.getOrDefault(key, 0)+1);
        }
        return frequencyCharMap;
    }

    private int findFirstUniqueIndex( HashMap<Character, Integer> frequencyCharMap, String string ){
        for(int i=0;i<string.length();i++){
            if(1 == frequencyCharMap.get(string.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
