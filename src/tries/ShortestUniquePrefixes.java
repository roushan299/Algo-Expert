package tries;

import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefixes {

    static class TrieNode {
        public Map<Character, TrieNode> children;
        public int count;
        public boolean isWordEnd;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            count = 0;
            isWordEnd = false;
        }
    }

    public String[] shortestUniquePrefixes(String[] strings) {
        TrieNode root = new TrieNode();
        for(String word: strings){
            addWord(word, root);
        }

        String[] res = new  String[strings.length];

        for(int i=0; i<strings.length; i++){
            String word = strings[i];
            String uniquePrefix = getUniquePrefix(word, root);
            res[i] =  uniquePrefix;

        }
        return res;
    }

    private String getUniquePrefix(String word, TrieNode root) {
        TrieNode current = root;

        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            current = current.children.get(c);

            if(current == null){
                return word;
            }

            if(current.count == 1){
                return word.substring(0, i+1);
            }
        }
        return word;
    }

    private void addWord(String word, TrieNode root) {
        TrieNode current = root;

        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.count = current.count + 1;
        }
        current.isWordEnd = true;

    }


}
