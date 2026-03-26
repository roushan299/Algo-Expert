package tries;

import tries.ds.TrieNode;

public class SuffixTrieConstruction {

    static class suffixTrie{
        TrieNode root = new  TrieNode();
        char endSymbol = '*';

        public void SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String string) {

            for(int i = 0; i < string.length(); i++) {
                String word  = string.substring(i);
                TrieNode node = root;
                for(Character letter : word.toCharArray()) {

                    if(!node.children.containsKey(letter)) {
                        TrieNode currentNode = new TrieNode();
                        node.children.put(letter, new TrieNode());
                    }
                    node = node.children.get(letter);
                }
                node.children.put(endSymbol, null);
            }

        }




        public boolean contains(String str) {
            TrieNode node = root;

            for(Character letter:str.toCharArray()){
                if(!node.children.containsKey(letter)) return false;
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }

    }

}
