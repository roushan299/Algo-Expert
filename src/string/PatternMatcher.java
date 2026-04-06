package string;

import java.util.HashMap;

public class PatternMatcher {

    public static String[] patternMatcher(String pattern, String str) {
        String[] result = new String[0];
        if (pattern.length() > str.length()) return result;
        String newPattern = getNewPattern(pattern);
        boolean didSwitch = !pattern.equals(newPattern);

        HashMap<Character, Integer> counts = new HashMap<>();
        int firstYPos = getCountAndFirstYPos(newPattern, counts);

        int strLength = str.length();


        if(counts.getOrDefault('y', 0) != 0){

            for(int xLength = 1; xLength < strLength; xLength++){
                int remainingLength = strLength - (counts.get('x') * xLength);
                if (remainingLength % counts.get('y') != 0) continue;

                int yLength = remainingLength / counts.get('y');

                if(yLength <= 0) continue;

                int yStartIdx = firstYPos * xLength;

                String x = str.substring(0, xLength);
                String y = str.substring(yStartIdx, yStartIdx + yLength);
                String potentialMatch = buildString(x, y, newPattern);

                if(potentialMatch.equals(str)){
                    return didSwitch ? new  String[]{y, x} : new  String[]{x, y};
                }

            }
        }else {
            int xLength = strLength / counts.get('x');
            if(xLength % 1 == 0){
                String x =  str.substring(0, xLength);
                String potentialMatch = buildString(x, "", newPattern);
                if(potentialMatch.equals(str)){
                    return didSwitch ? new  String[]{"", x} : new  String[]{x, ""};
                }
            }
        }
        return result;
    }




    private static String getNewPattern(String pattern) {
        if(pattern.charAt(0) == 'x') return pattern;
        StringBuilder newPattern = new StringBuilder();
        for(char c : pattern.toCharArray()) {
            char newChar = (c == 'x') ? 'y' : 'x';
            newPattern.append(newChar);
        }
        return newPattern.toString();
    }

    private static int getCountAndFirstYPos(String pattern, HashMap<Character, Integer> counts) {
        int firstYPos = -1;

        for(int  i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(firstYPos == -1 && c == 'y') firstYPos = i;
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return firstYPos;
    }

    private static int getLengthOfY(int xLength, int xTimes, int strLength, int yTimes){
        return (strLength - (xTimes * xLength)) / yTimes;
    }

    private static String buildString(String x, String y, String pattern) {
        StringBuilder sb = new StringBuilder();
        for(char c : pattern.toCharArray()){
            String valueToAppend = (c == 'x') ? x : y;
            sb.append(valueToAppend);
        }
        return sb.toString();
    }

}
