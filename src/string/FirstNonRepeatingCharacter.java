package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = buildFrequencyMap(string);
        return findFirstUniqueIndex(string, map);
    }

    private Map<Character, Integer> buildFrequencyMap(String string){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(Character c : string.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private int findFirstUniqueIndex(String string, Map<Character, Integer> map){
        for(int i = 0; i < string.length(); i++){
            Character c = string.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
