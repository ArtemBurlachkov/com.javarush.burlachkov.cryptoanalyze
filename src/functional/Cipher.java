package functional;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        String encrypted = "";
        char ch;
        for (int i = 0; i < text.length(); i++) { // or ++i
            ch = text.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if (ch == alphabet[j]) {
                    if (alphabet[j] + shift > alphabet.length) {
                        ch = (char) (alphabet[j] + shift - alphabet.length);
                    } else {
                        ch = (char) (alphabet[j] + shift);
                    }
                }
            }
            encrypted += ch;
        }
        return encrypted;
    }

    public String decrypt(String encrytedText, int shift) {
        String decrypted = "";
        char ch;
        for (int i = 0; i < encrytedText.length(); i++) {
            ch = encrytedText.charAt(i);
            for (int j = 0; j < alphabet.length; j++) {
                if (ch == alphabet[j]) {
                    if (alphabet[j] - shift < 0) {
                        ch = (char) (alphabet[j] - shift + alphabet.length);
                    }
                    else {
                        ch = (char) (alphabet[j] - shift);
                    }
                }
            }
            decrypted += ch;
        }
        return decrypted;
    }


}
