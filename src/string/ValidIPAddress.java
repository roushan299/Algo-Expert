package string;

import java.util.ArrayList;

public class ValidIPAddress {

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> list = new ArrayList<>();

        for(int i=0;i<string.length()-2;i++){
            for(int j=i+1;j<string.length()-1;j++){
                for(int k=j+1;k<string.length();k++){
                    String p1 = string.substring(0,i);
                    String p2 = string.substring(i,j);
                    String p3 = string.substring(j,k);
                    String p4 = string.substring(k);

                    if( !(validIPPart(p1) && validIPPart(p2) && validIPPart(p3) && validIPPart(p4))){
                        continue;
                    }
                    list.add(new String(p1)+"."+p2+"."+p3+"."+p4);
                }
            }
        }
        return list;
    }

    private boolean validIPPart(String part){
    if(part.length()==0 || part.length()>3) return false;

    int num = Integer.parseInt(part);

    if(num > 255) return false;

    if(part.length() > 1 && part.charAt(0) == '0') return false;
    return true;
    }
}
