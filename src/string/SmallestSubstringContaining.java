package string;

import java.util.HashMap;

public class SmallestSubstringContaining {

    public static String smallestSubstringContaining(String bigString, String smallString) {
        HashMap<Character, Integer> targetCharCounts = getFrequencyMap(smallString);
        HashMap<Character, Integer> subStringCharCounts = new HashMap<>();

        int left = 0;
        int right = 0;
        int numUniqueCharsDone = 0;
        int numUniqueChars = targetCharCounts.size();
        int[] bestBounds = {0, Integer.MAX_VALUE};

        while (right < bigString.length()) {
            char rightChar = bigString.charAt(right);

            if(targetCharCounts.containsKey(rightChar)) {
                subStringCharCounts.put(rightChar, subStringCharCounts.getOrDefault(rightChar, 0) + 1);

                if(subStringCharCounts.get(rightChar).intValue() == targetCharCounts.get(rightChar).intValue()) {
                    numUniqueCharsDone++;
                }
            }

            while (numUniqueChars == numUniqueCharsDone && left <= right){
                int currentLength = right - left;
                int prevLength =  bestBounds[1] - bestBounds[0];

                if(currentLength < prevLength){
                    bestBounds[0] = left;
                    bestBounds[1] = right;
                }

                char leftChar = bigString.charAt(left);
                if(targetCharCounts.containsKey(leftChar)) {

                    if(subStringCharCounts.get(leftChar).intValue() == targetCharCounts.get(leftChar).intValue()) {
                        numUniqueCharsDone--;
                    }

                    subStringCharCounts.put(leftChar, subStringCharCounts.get(leftChar)-1);
                }

                left++;
            }

            right++;
        }
        return getStringFromBounds(bigString, bestBounds);
    }

    private static HashMap<Character, Integer> getFrequencyMap(String smallString) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch : smallString.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    private static String getStringFromBounds(String string, int[] bestBounds) {
        if(bestBounds[1] == Integer.MAX_VALUE) {
            return "";
        }
        return string.substring(bestBounds[0], bestBounds[1]+1);
    }
}
