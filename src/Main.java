import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Виселица!");
        while (true) {
            System.out.println("Начать новую игру (Д - да, Н - нет)?");
            char selectChar = scanner.next().toUpperCase().charAt(0);
            if (selectChar == 'Д') {
                Game.start();
            } else if (selectChar == 'Н') {
                scanner.close();
                System.out.println("До свидания!");
                System.exit(0);
            } else {
                System.out.println("Сделайте выбор ещё раз");
            }
        }
    }
}
