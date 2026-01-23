package string;

public class CaesarCypherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        int shift = normalizeKey(key);
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            encrypted.append(encryptedCharacter(str.charAt(i), shift));
        }
        return encrypted.toString();
    }

    private static char encryptedCharacter(char c, int shift) {
        int shifted_ascii_value = c + shift;
        return (char) wrapIfNeeded(shifted_ascii_value);
    }

    private static int wrapIfNeeded(int ascii_value) {
        return  (ascii_value > 'z' ? ascii_value - 26 : ascii_value);
    }

    private static int normalizeKey(int key) {
        return key % 26;
    }
}
