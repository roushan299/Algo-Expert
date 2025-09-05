package string;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> validIPAddressList = new ArrayList<>();
        
        for (int i = 0; i < string.length()-3; i++) {
            for (int j = i+1; j < string.length()-2; j++) {
                for (int k = j+1; k < string.length()-1; k++) {
                    List<String> partList = splitIntoParts(string, i, j, k);
                    if(allPartsValid(partList)){
                        validIPAddressList.add(joinParts(partList));
                    }
                }
            }
        }
        return validIPAddressList;
    }

    private List<String> splitIntoParts(String string, int i, int j, int k) {
        List<String> partList = new ArrayList<>(4);
        partList.add(string.substring(0, i+1));
        partList.add(string.substring(i+1, j+1));
        partList.add(string.substring(j+1, k+1));
        partList.add(string.substring(k+1));
        return partList;
    }

    private String joinParts(List<String> partList) {
        return String.join(".", partList);
    }

    private boolean allPartsValid(List<String> partList) {
        for (String part : partList) {
            if(!validPart(part)){
                return false;
            }
        }
        return true;
    }

    private boolean validPart(String part) {
        if(part.length()>1 && part.startsWith("0")){
            return false;
        }
        int value = Integer.parseInt(part);
        return 0 <= value && value <= 255;
    }


}
