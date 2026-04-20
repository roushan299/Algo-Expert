package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {
    
  private static class TrieNode{
      
      Map<Character, TrieNode> edges;
      boolean isWordEnd = false;
      
      TrieNode(){
        edges = new HashMap<>();
      }
  }
  
  
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        TrieNode root = new TrieNode();
        
        for(int i=0;i<bigString.length();i++){
            addString(root, bigString.substring(i));
        }

        List<Boolean> result = new ArrayList<>();

        for(String s: smallStrings){
            result.add(checkString(root, s));
        }
        return result;
    }

    private static Boolean checkString(TrieNode root, String str) {
        TrieNode current = root;

        for(char c: str.toCharArray()){
            if(!current.edges.containsKey(c)){
                return false;
            }
            current = current.edges.get(c);
        }
        return true;
    }


    private static void addString(TrieNode root, String substring) {
      TrieNode current = root;

      for(char c: substring.toCharArray()){
          if(!current.edges.containsKey(c)){
              current.edges.put(c, new TrieNode());
          }
          current = current.edges.get(c);
      }
      current.isWordEnd = true;
    }


//    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
//        List<Boolean> result = new ArrayList<>();
//
//        for(String smallString : smallStrings) {
//            result.add(bigString.contains(smallString));
//        }
//        return result;
//    }
}
