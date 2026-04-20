package tries;

import java.util.HashMap;
import java.util.Map;

public class LongestMostFrequentPrefix {

    static class TrieNode{
        Map<Character, TrieNode> edges;
        int maxPrefixCount;
        int maxPrefixLength;
        String maxPrefixFullString;
        boolean isWordEnd;

        public TrieNode(){
            edges = new HashMap<>();
            maxPrefixCount = 0;
            maxPrefixLength = 0;
            maxPrefixFullString = "";
        }

        public void insert(TrieNode root, String word){
            TrieNode current = root;
            StringBuilder prefix = new StringBuilder();

            for(char c: word.toCharArray()){
                prefix.append(c);
                if(!current.edges.containsKey(c)){
                    current.edges.put(c, new TrieNode());
                }

                current = current.edges.get(c);
                current.maxPrefixCount++;

                if(current.maxPrefixCount > root.maxPrefixCount || (current.maxPrefixCount == root.maxPrefixCount && prefix.length() > root.maxPrefixLength)){
                    root.maxPrefixCount = current.maxPrefixCount;
                    root.maxPrefixLength = prefix.length();
                    root.maxPrefixFullString = prefix.toString();
                }
            }
            current.isWordEnd = true;
        }

    }

    public String longestMostFrequentPrefix(String[] strings) {
        TrieNode root = new TrieNode();
        for(String str : strings){
            root.insert(root, str);
        }

        return root.maxPrefixFullString;
    }

}
