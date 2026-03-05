package greedy_algorithms;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class TaskAssignment {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        TreeMap<Integer, ArrayList<Integer>> taskIndexMap = getTaskIndexMap(tasks);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while (!taskIndexMap.isEmpty()){
            ArrayList<Integer> pairList = new ArrayList<>();
            Integer firstKey = taskIndexMap.firstKey();
            Integer lastKey = taskIndexMap.lastKey();
            addIndexToList(pairList, firstKey, taskIndexMap);
            addIndexToList(pairList, lastKey, taskIndexMap);
            result.add(pairList);
        }

        return result;
    }

    private void addIndexToList(ArrayList<Integer> pairList, int key, TreeMap<Integer, ArrayList<Integer>> taskIndexMap){
        ArrayList<Integer> keyIndexList = taskIndexMap.get(key);
        pairList.add(keyIndexList.remove(0));
        if(keyIndexList.isEmpty()){
            taskIndexMap.remove(key);
        }
    }

    private TreeMap<Integer, ArrayList<Integer>> getTaskIndexMap(ArrayList<Integer> tasks) {
        TreeMap<Integer, ArrayList<Integer>> taskIndexMap = new TreeMap<>();
        for(int i = 0; i < tasks.size(); i++){
            int key = tasks.get(i);
            ArrayList<Integer> indexList = taskIndexMap.getOrDefault(key,  new ArrayList<>());
            indexList.add(i);
            taskIndexMap.put(key, indexList);
        }
        return taskIndexMap;
    }


}
