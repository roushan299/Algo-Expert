package string;

import java.util.HashMap;

public class longestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplication(String str) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();

        int startIdx = 0;
        int maxLength = 0;
        int longestStart = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(lastSeen.containsKey(c)){
                startIdx = Math.max(startIdx, lastSeen.get(c)+1);
            }
            lastSeen.put(c, i);

            int currentLength = i - startIdx+1;

            if(currentLength > maxLength){
                maxLength = currentLength;
                longestStart = startIdx;
            }

        }
        return maxLength == 0 ? "" : str.substring(longestStart, longestStart + maxLength);
    }
}
