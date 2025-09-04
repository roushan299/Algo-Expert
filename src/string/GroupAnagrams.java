package string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        if(words == null || words.size() == 0){
            return Collections.emptyList();
        }

        Map<String, List<String>> anagramMap = buildAnagramMap(words);
        return new ArrayList<>(anagramMap.values());
    }

    private static Map<String, List<String>> buildAnagramMap(List<String> words) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word : words){
            String sortedWord = sortedWord(word);
            anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        return anagramMap;
    }

    private static String sortedWord(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


}
