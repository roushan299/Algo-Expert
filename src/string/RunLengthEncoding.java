package string;

public class RunLengthEncoding {
    public String runLengthEncoding(String string) {
        StringBuilder encodedString = new StringBuilder();
        char previousChar = string.charAt(0);
        int count = 1;

        for (int i = 1; i < string.length(); i++) {
            char currentChar = string.charAt(i);

            if(currentChar == previousChar) {
                count = handleRepeat(encodedString, previousChar, count);
            }else {
                flush(encodedString, previousChar, count);
                previousChar = currentChar;
                count = 1;
            }
        }
        flush(encodedString, previousChar, count);
        return encodedString.toString();
    }

    private int handleRepeat(StringBuilder encodedString, char previousChar, int count) {
        count++;

        if(count == 9){
            encodedString.append(count).append(previousChar);
            return 0;
        }
        return count;
    }

    private void flush(StringBuilder encodedString, char previousChar, int count) {
        if(count > 0) {
            encodedString.append(count).append(previousChar);
        }
    }
}
