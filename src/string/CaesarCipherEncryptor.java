package string;

public class CaesarCipherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder encryptedString = new StringBuilder();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii_value = ch + (key%26);
            ascii_value = ascii_value > 'z' ? ascii_value - 26 : ascii_value;
            encryptedString.append((char)ascii_value);
        }
        return encryptedString.toString();
    }
}
