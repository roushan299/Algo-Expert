package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringsMadeUpOfStrings {

    static class  TrieNode {
        Map<Character, TrieNode> children;
        boolean isWordEnd;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWordEnd = false;
        }
    }

    public String[] stringsMadeUpOfStrings(String[] strings, String[] substrings) {
        TrieNode root = new TrieNode();

        for (String subString : substrings) {
            addWord(root, subString);
        }

        ArrayList<String> stringArrayList = new  ArrayList<>();
        
        for(String word : strings) {
            if(canForm(word, root, 0, new HashMap<>())){
                stringArrayList.add(word);
            }
        }
        return stringArrayList.toArray(new String[0]);


    }

    private boolean canForm(String word, TrieNode root, int start, HashMap<Integer, Boolean> memo) {

        if(start == word.length()) return true;

        if(memo.containsKey(start)) return memo.get(start);

        TrieNode node = root;

        for(int i=start; i<word.length(); i++) {
            char c = word.charAt(i);

            if(!node.children.containsKey(c)){
                break;
            }

            node = node.children.get(c);

            if(node.isWordEnd) {
                if(canForm(word, root, i+1, memo)){
                    memo.put(start, true);
                    return true;
                }
            }
        }
        memo.put(start, false);
        return false;
    }

    private void addWord(TrieNode root, String subString) {
        TrieNode node = root;
        for (char c : subString.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isWordEnd = true;
    }

}
