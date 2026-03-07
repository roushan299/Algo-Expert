package string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = buildAnagramsMap(words);
        return new  ArrayList<>(map.values());
    }

    private static Map<String, List<String>> buildAnagramsMap(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key  = getSortedKey(word);
            List<String> list = map.getOrDefault(key,  new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        return map;
    }

    private static String getSortedKey(String word) {
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
