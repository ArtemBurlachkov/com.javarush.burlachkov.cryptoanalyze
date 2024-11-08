package functional;

import java.util.List;

public class Cipher {
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static List<String> encipher(List<String> input, int key) {
        String line;
        char[] ch;
        for (int i = 0; i < input.size(); i++) {
            line = input.get(i);
            ch = line.toCharArray();
            String encrypted = "";
            for (int j = 0; j < ch.length; j++) {

                for (int k = 0; k < ALPHABET.length; k++) {
                    if (ch[j] == ALPHABET[k]) {
                        if ((k + key) >= ALPHABET.length) {
                            ch[j] = (ALPHABET[k + key - ALPHABET.length]);
                        } else if ((k + key) < 0) {
                            ch[j] = (ALPHABET[ALPHABET.length + (k + key)]);
                        } else {
                            ch[j] = ALPHABET[k + key];
                        }
                        break;
                    }
                }
                encrypted += ch[j];
            }
            input.set(i, encrypted);
        }
        return input;
    }

    public static List<String> decipher(List<String> input, int key) {
        return encipher(input, -key);
    }

    public static void bruteForce(List<String> input, String fileName) {
        List<String> list;
        for (int key = 1; key < ALPHABET.length; key++) {
            list = input;
            StringBuilder stringBuilder = new StringBuilder(fileName);
            stringBuilder.insert(stringBuilder.lastIndexOf("."), "bruteForceKey" + key);
            FileManager.writeFile(String.valueOf(stringBuilder), decipher(list, Integer.valueOf(1))); // Не понимаю логики отработки, если подстовлять
            // вместо единицы целочисленную переменную key
            // Пример: Начинаем с 'а' при key 1 сhar = 'б'
            // key 2 сhar = 'д' key 3 сhar = 'и' key 4 сhar = 'н'
        }
    }
}
