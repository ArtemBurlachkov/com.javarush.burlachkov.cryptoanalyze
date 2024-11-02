import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String value;
        while (!exit) {
            System.out.println("1.   Шифроыание");
            System.out.println("2.   Расшифровка");
            System.out.println("3.   Расшифровка с ключем");
            System.out.println("4.   Brute Force");
            System.out.println("0.   Выход");
            System.out.println();
            System.out.println("При помощи клавиатуры введите номер в меню");

            value = scanner.nextLine();

            switch (value) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "0":
                    exit = true;

                default:
                    System.out.println("Введите правильное значение меню");
                    break;
            }
        }
    }
}
