package recursion;

import java.sql.Array;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneNumberMnemonics {

    private static HashMap<Character, ArrayList<String>> DIGIT_LETTERS = createDigitMap();
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> result = new ArrayList<>();
        buildMnemonics(0, phoneNumber, new StringBuffer(phoneNumber), result);
        return result;

    }

    private void buildMnemonics(int index, String phoneNumber, StringBuffer current, ArrayList<String> result) {

        if(isComplete(index, phoneNumber)){
            result.add(current.toString());
            return;
        }
        char digit = getDigit(phoneNumber, index);
        List<String> letters = getLetters(digit);

        for(String letter : letters){
            applyChoice(current, index, letter);
            buildMnemonics(index+1, phoneNumber, current, result);
        }

    }

    private char getDigit(String phoneNumber, int index){
        return phoneNumber.charAt(index);
    }

    private void applyChoice(StringBuffer current, int index, String letter) {
        current.setCharAt(index, letter.charAt(0));
    }

    private List<String> getLetters(char digit) {
        return DIGIT_LETTERS.get(digit);
    }

    private boolean isComplete(int index, String phoneNumber) {
        return index == phoneNumber.length();
    }

    private static HashMap<Character, ArrayList<String>> createDigitMap() {
        HashMap<Character, ArrayList<String>> DIGIT_LETTERS = new HashMap<>();
        DIGIT_LETTERS.put('0', new ArrayList<String>(Arrays.asList("0")));
        DIGIT_LETTERS.put('1', new ArrayList<String>(Arrays.asList("1")));
        DIGIT_LETTERS.put('2', new ArrayList<String>(Arrays.asList("a", "b", "c")));
        DIGIT_LETTERS.put('3', new ArrayList<String>(Arrays.asList("d", "e", "f")));
        DIGIT_LETTERS.put('4', new ArrayList<String>(Arrays.asList("g", "h", "i")));
        DIGIT_LETTERS.put('5', new ArrayList<String>(Arrays.asList("j", "k", "l")));
        DIGIT_LETTERS.put('6', new ArrayList<String>(Arrays.asList("m", "n", "o")));
        DIGIT_LETTERS.put('7', new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
        DIGIT_LETTERS.put('8', new ArrayList<String>(Arrays.asList("t", "u", "v")));
        DIGIT_LETTERS.put('9', new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
        return DIGIT_LETTERS;
    }
}
