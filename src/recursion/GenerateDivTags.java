package recursion;

import java.util.ArrayList;

public class GenerateDivTags {
    private final String START_DIV = "<div>";
    private final String END_DIV = "</div>";

    public ArrayList<String> generateDivTags(int numberOfTags) {
        ArrayList<String> tagList = new ArrayList<>();
//        backTrack(tagList, "", 0, 0, numberOfTags);
        backTrack(tagList, "", numberOfTags, numberOfTags);
        return tagList;
    }

    private void backTrack(ArrayList<String> tagList, String prefix, int open, int close) {
        if(open > 0){
            String newPrefix = prefix + START_DIV;
            backTrack(tagList, newPrefix, open - 1, close);
        }

        if(open < close){
            String newPrefix = prefix + END_DIV;
            backTrack(tagList, newPrefix, open, close-1);
        }

        if(close == 0){
            tagList.add(prefix);
        }
    }


//    private void backTrack(ArrayList<String> tagList, String current, int open, int close, int max) {
//
//        if(current.length() == max * (START_DIV.length() + END_DIV.length())) {
//            tagList.add(current);
//            return;
//        }
//
//        if(open < max){
//            backTrack(tagList, current+START_DIV, open+1, close, max);
//        }
//
//        if(close < open){
//            backTrack(tagList, current+END_DIV, close+1, close, max);
//        }
//
//    }

}
