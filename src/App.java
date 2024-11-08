import functional.Cipher;
import functional.FileManager;
import functional.Validator;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static functional.FileManager.readFile;


public class App {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        String value;
        while (!exit) {
            System.out.println("1.   Шифрование с ключём");
            System.out.println("2.   Расшифровка с ключём");
            System.out.println("3.   Brute Force");
            System.out.println("0.   Выход");
            System.out.println();
            System.out.println("При помощи клавиатуры введите номер в меню");

            value = scanner.nextLine();

            switch (value) {
                case "1":
                    System.out.println("Введите путь к файлу для шифрования"); // "C:\Users\Artem\Desktop\11\Война и мир.txt"
                    Path read = validator.ValidPathReadFile();
                    int key = validator.validKey("Введите ключ для шифрования файла в диапозоне от 1 до " + (Cipher.ALPHABET.length - 1));
                    System.out.println("Введите путь для нового файла");
                    Path write = validator.ValidPathWriteFile();

                    List<String> list = readFile(String.valueOf(read));
                    List<String> listCipher = Cipher.encipher(list, Integer.valueOf(key));
                    FileManager.writeFile(String.valueOf(write), listCipher);

                    System.out.println("Файл зашифрован и записан по указанному пути\n");


                    break;
                case "2":
                    System.out.println("Введите путь к файлу для декадировки");
                    read = validator.ValidPathReadFile();
                    key = validator.validKey("Введите ключ для дешифрования файла в диапозоне от 1 до " + (Cipher.ALPHABET.length - 1));
                    System.out.println("Введите путь для нового файла");
                    write = validator.ValidPathWriteFile();


                    list = readFile(String.valueOf(read));
                    listCipher = Cipher.decipher(list, Integer.valueOf(key));
                    FileManager.writeFile(String.valueOf(write), listCipher);

                    System.out.println("Файл зашифрован и записан по указанному пути\n");

                    break;
                case "3":
                    System.out.println("Введите путь к файлу для декадировки методом Brute Force");
                    read = validator.ValidPathReadFile();

                    list = readFile(String.valueOf(read));
                    Cipher.bruteForce(list, String.valueOf(read));

                    break;

                case "0":
                    exit = true;
                    System.out.println("Спасибо, что используете нашу программу!!!");
                    break;

                default:
                    System.out.println("Введите правильное значение меню");
                    break;
            }
        }
    }
}
