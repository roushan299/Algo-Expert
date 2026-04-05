package string;

import java.util.ArrayList;
import java.util.Arrays;

public class UnderScorifySubstring {

//    public static void main(String[] args) {
//        String str = "testthis is a testtest to see if testestest it works";
//        String subString = "test";
//
//        ArrayList<int[]> list = getLocations(str, subString);
//
//       for(int[] location: list){
//           System.out.println(Arrays.toString(location));
//       }
//
//        System.out.println("----------------");
//       ArrayList<int[]> list2 = collapseLocations(list);
//        for(int[] location: list2){
//            System.out.println(Arrays.toString(location));
//        }
//
//    }

    public static String underscorifySubstring(String str, String substring) {
        ArrayList<int[]> locations = getLocations(str, substring);
        ArrayList<int[]> collapsedLocations = collapseLocations(locations);
        String result = underScorify(str, collapsedLocations);
        return result;
    }

    private static ArrayList<int[]> getLocations(String str, String substring) {
        ArrayList<int[]> locations = new ArrayList<>();

        int subStringLength = substring.length();

        for(int i = 0; i <= str.length()-subStringLength; i++) {
            String possibleSubString = str.substring(i, i+subStringLength);

            if(possibleSubString.equals(substring)) {
                locations.add(new int[] {i, i+subStringLength});
            }
        }
        return locations;
    }

    private static ArrayList<int[]> collapseLocations(ArrayList<int[]> locations) {
        if(locations.isEmpty()) return new ArrayList<>();

        ArrayList<int[]> collapsedLocations = new ArrayList<>();
        int[]  currentLocation = locations.get(0);

        for(int i = 1; i < locations.size(); i++) {
            int[] nextLocation = locations.get(i);
            if(currentLocation[1] >=  nextLocation[0]) {
                currentLocation[1] = nextLocation[1];
            }else{
                collapsedLocations.add(currentLocation);
                currentLocation = nextLocation;
            }
        }
        collapsedLocations.add(currentLocation);
        return collapsedLocations;
    }

    private static String underScorify(String str, ArrayList<int[]> locations) {

        if(locations.isEmpty()) return str;

        int locationIdx = 0;
        int stringIdx = 0;
        boolean inBetweenUnderScores = false;
        StringBuilder result = new StringBuilder();
        int i =0;

        while (stringIdx < str.length() && locationIdx < locations.size()) {
            if(stringIdx == locations.get(locationIdx)[i]){
                result.append("_");
                inBetweenUnderScores = !inBetweenUnderScores;
                if(!inBetweenUnderScores){
                    locationIdx++;
                }
                i = i == 0 ? 1: 0;
            }
            result.append(str.charAt(stringIdx));
            stringIdx++;
        }

        if(locationIdx < locations.size()) {
            result.append("_");
        }else {
            result.append(str.substring(stringIdx));
        }

        return result.toString();
    }
}
