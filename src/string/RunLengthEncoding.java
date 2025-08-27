package string;
public class RunLengthEncoding {

    public String runLengthEncoding(String string) {
        StringBuilder str = new StringBuilder();
        int charCount = 0;
        char currentChar = string.charAt(0);
        for(int idx = 0;idx<string.length();idx++){
            if(charCount == 9 || currentChar != string.charAt(idx)){
                str.append(charCount).append(currentChar);
                currentChar = string.charAt(idx);
                charCount =0;
            }
            charCount++;

        }
        if(charCount != 0) {
            str.append( charCount ).append( currentChar );
        }
        return str.toString();
    }
}
