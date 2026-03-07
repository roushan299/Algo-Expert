package string;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumCharactersForWords {

    public char[] minimumCharactersForWords(String[] words) {
        if(words==null||words.length==0){
            return new char[0];
        }
        HashMap<Character, Integer> maxFreq = computeMaxFrequency(words);
        return buildCharArray(maxFreq);
    }

    private char[] buildCharArray(HashMap<Character, Integer> maxFreq) {
        StringBuilder sb = new StringBuilder();

        for(Character key : maxFreq.keySet()){
            int freq = maxFreq.get(key);

            for(int i=0;i<freq;i++){
                sb.append(key);
            }
        }
        return sb.toString().toCharArray();
    }

    private HashMap<Character, Integer> computeMaxFrequency(String[] words) {
        HashMap<Character, Integer> maxFreq = getCharFrequency(words[0]);

        for(int i=1;i<words.length;i++){
            HashMap<Character, Integer> currentFreq = getCharFrequency(words[i]);
            updateMaxFrequencies(maxFreq, currentFreq);
        }
        return maxFreq;
    }

    private void updateMaxFrequencies(HashMap<Character, Integer> maxFreq, HashMap<Character, Integer> currentFreq) {
        for (Character key : currentFreq.keySet()) {
            int value = Math.max(currentFreq.get(key), maxFreq.getOrDefault(key, 0));
            maxFreq.put(key, value);
        }
    }

    private HashMap<Character, Integer> getCharFrequency(String word) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            freq.put(word.charAt(i), freq.getOrDefault(word.charAt(i), 0) + 1);
        }
        return freq;
    }
}
