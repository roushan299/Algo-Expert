package string;


import java.util.HashSet;

public class CommonCharacters {
    public String[] commonCharacters(String[] strings) {
        if(strings == null || strings.length == 0){
            return new String[0];
        }
        HashSet<Character> set = getCharSet(strings[0]);

        for(int i = 1; i < strings.length; i++){
            HashSet<Character> set2 = getCharSet(strings[i]);
            set.retainAll(set2);
        }
        String[] result = new String[set.size()];
        int index = 0;
        for (char c : set) {
            result[index++] = String.valueOf(c);
         }

        return result;
    }

    private HashSet<Character> getCharSet(String string) {
        HashSet<Character> set = new HashSet<>();
        for(char c : string.toCharArray()){
            set.add(c);
        }
        return set;
    }
}
