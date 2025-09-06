package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MiniumCharacterForWords {

    public char[] minimumCharactersForWords(String[] words) {
        if(words == null || words.length == 0){
            return new char[0];
        }

        HashMap<Character, Integer> characterMap = createCharMap(words[0]);

        for(int i = 1; i < words.length; i++){
            HashMap<Character, Integer> nextCharacterMap = createCharMap(words[i]);
            mergeCharacterMap(characterMap, nextCharacterMap);
        }

        List<Character> resultList = new ArrayList<>();
        for(Character character : characterMap.keySet()){
            for(int i = 0; i < characterMap.get(character); i++){
                resultList.add(character);
            }
        }
        char[] result = new char[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }

    private void mergeCharacterMap(HashMap<Character, Integer> characterMap, HashMap<Character, Integer> nextCharacterMap) {

        for(Character character : nextCharacterMap.keySet()){
            characterMap.put(character, Math.max(characterMap.getOrDefault(character, 0), nextCharacterMap.get(character)));
        }
    }

    private HashMap<Character, Integer> createCharMap(String word) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(char c : word.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        return charMap;
    }
}
