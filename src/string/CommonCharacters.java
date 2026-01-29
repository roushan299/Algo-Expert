package string;

import java.util.*;

public class CommonCharacters {
    public String[] commonCharacters(String[] strings) {
        Map<String, Integer> charCountMap = buildCharacterFrequencyMap(strings);
        return extractCommonCharacter(charCountMap, strings.length);
    }

    private Map<String, Integer> buildCharacterFrequencyMap( String[] strings ) {
        Map<String, Integer> charCountMap = new HashMap<String, Integer>();

        for(String str: strings){
            Set<Character> uniqueChars = getUniqueCharSet(str);
            updateCharacterCount(charCountMap, uniqueChars);
        }
        return charCountMap;
    }

    private void updateCharacterCount( Map<String, Integer> charCountMap, Set<Character> uniqueChars ) {
        for(Character ch: uniqueChars){
            String key = String.valueOf(ch);
            charCountMap.put(key, charCountMap.getOrDefault(key, 0)+1);
        }
    }

    private Set<Character> getUniqueCharSet( String str ) {
        Set<Character> uniqueChars = new HashSet<>();
        for(char ch: str.toCharArray()){
            uniqueChars.add(ch);
        }
        return uniqueChars;

    }

    private String[] extractCommonCharacter( Map<String, Integer> charCountMap, int wordCount ) {
        List<String> result = new ArrayList<String>();

        for(Map.Entry<String, Integer> entry: charCountMap.entrySet()){
            if(entry.getValue() == wordCount){
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[0]);
    }
}
