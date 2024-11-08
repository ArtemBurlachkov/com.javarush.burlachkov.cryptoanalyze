package functional;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    public Path ValidPathReadFile() {
        Scanner scanner = new Scanner(System.in);
        Path pathFileEncoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileEncoder = Paths.get(scanner.nextLine());
                File file = new File(String.valueOf(pathFileEncoder));
                if (Files.isRegularFile(pathFileEncoder) && file.length() != 0) {
                    validPath = true;
                } else if (Files.isRegularFile(pathFileEncoder) && file.length() == 0) {
                    System.out.println("Выбранный файл пустой попробуте другой файл");
                } else {
                    System.out.println("По данной ссылке файл отсутствует, попробуйте другой файл");
                }
            } catch (InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("По данной ссылке файл отсутствует, попробуйте другой файл");
            }
        }
        return pathFileEncoder;
    }

    public int validKey(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean validKey = false;
        while (!validKey) {
            try {
                key = scanner.nextInt();
                if (key > 0 && key < Cipher.ALPHABET.length) {
                    validKey = true;
                } else {
                    System.out.println("Внимание!!! Введите ключ в диапозоне от 1 до " + (Cipher.ALPHABET.length - 1));
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите целое ЧИСЛО");
                scanner.nextLine();
            }
        }
        return key;
    }

    public Path ValidPathWriteFile() {
        Scanner scanner = new Scanner(System.in);
        Path pathFileDecoder = Paths.get("");
        boolean validPath = false;
        while (validPath == false) {
            try {
                pathFileDecoder = Paths.get(scanner.nextLine());
                if (pathFileDecoder.toString().equals("")) throw new NullPointerException();
                validPath = true;
            } catch (NullPointerException | InvalidPathException e) {
                System.out.println(e.getMessage());
                System.out.println("Введите корректный путь к файлу");
            }
        }
        return pathFileDecoder;
    }
}
