package string;

import java.util.ArrayList;
import java.util.HashSet;

public class Semordnilap {

    public ArrayList<ArrayList<String>> semordnilap( String[] words) {
        ArrayList<ArrayList<String>> semordnilapPairList = new ArrayList<>();
        HashSet<String> used = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            if (used.contains(word1)) {
                continue;
            }
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if (used.contains(word2)) {
                    continue;
                }
                if (!reverse(word2).equals(word1)) {
                    continue;
                }
                addPair(word1, word2, used, semordnilapPairList);
            }
        }
        return semordnilapPairList;
    }

    private void addPair(String word1, String word2, HashSet<String> used, ArrayList<ArrayList<String>> semordnilapPairList){
        ArrayList<String> semordnilapPair = new ArrayList<>();
        used.add(word1);
        used.add(word2);
        semordnilapPair.add(word1);
        semordnilapPair.add(word2);
        semordnilapPairList.add(semordnilapPair);
    }

    private String reverse(String string){
        return new StringBuilder(string).reverse().toString();
    }

}
