package algorithms;

import java.util.HashMap;
import java.util.Map;

public class UnionFindAlgorithm {
    static class UnionFind {
        private Map<Integer,Integer> parents = new HashMap<>();
        private Map<Integer, Integer> ranks  = new HashMap<>();

        public void createSet(int value) {
            parents.put(value,value);
            ranks.put(value,0);
        }

        public Integer find(int value) {
            if(!parents.containsKey(value)){
                return null;
            }
            int currentParent = value;

            while (currentParent != parents.get(currentParent)){
                currentParent = parents.get(currentParent);
            }
            return currentParent;
        }

        public void union(int valueOne, int valueTwo) {
            if(!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)){
                return;
            }
            int valueOneRoot = find(valueOne);
            int valueTwoRoot = find(valueTwo);

            if(ranks.get(valueOneRoot) < ranks.get(valueTwoRoot)){
                parents.put(valueOneRoot,valueTwoRoot);

            }else if(ranks.get(valueOneRoot) > ranks.get(valueTwoRoot)){
                parents.put(valueTwoRoot,valueOneRoot);
            }else{
                parents.put(valueTwoRoot, valueOneRoot);
                ranks.put(valueOneRoot,ranks.get(valueOneRoot)+1);
            }
        }
    }
}
