package string;

public class OneEdit {

    public boolean oneEdit1(String stringOne, String stringTwo) {

        int length1 =  stringOne.length();
        int length2 = stringTwo.length();

        int lengthDiff = Math.abs(length1 - length2);
        if(lengthDiff > 1) return false;

        for(int idx = 0; idx < Math.min(length1, length2); idx++){

            if(stringOne.charAt(idx) != stringTwo.charAt(idx)){
                if(length1 > length2){
                    return stringOne.substring(idx+1).equals(stringTwo.substring(idx));
                }else if(length1 < length2){
                    return stringOne.substring(idx).equals(stringTwo.substring(idx+1));
                }else {
                    return stringOne.substring(idx+1).equals(stringTwo.substring(idx+1));
                }
            }
        }
        return true;
    }

    public boolean oneEdit(String stringOne, String stringTwo) {

        int length1 =  stringOne.length();
        int length2 = stringTwo.length();

        int lengthDiff = Math.abs(length1 - length2);
        if(lengthDiff > 1) return false;

        boolean madeEdit = false;
        int index1 = 0;
        int index2 = 0;

        while (index1 < length1 && index2 < length2){
            if(stringOne.charAt(index1) != stringTwo.charAt(index2)){

                if(madeEdit){
                    return false;
                }else{
                    madeEdit = true;
                }


                if(length1 > length2){
                    index1++;
                } else if (length1 < length2) {
                    index2++;
                }else {
                    index1++;
                    index2++;
                }
            }else {
                index1++;
                index2++;
            }
        }
        return true;
    }

}
