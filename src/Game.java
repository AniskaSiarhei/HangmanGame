import java.util.Scanner;

public class Game {
    private static final int MAX_ATTEMPTS = 6; // Максимальное количество попыток
    private static final String HIDDENCHAR = "-";
    private static int attempts = 0;            // Количество попыток
    private static boolean isLetterFound;
    private static char userLetter;
    private static Scanner scanner;
    private static String secretWord;            // Загаданное слово
    private static StringBuilder guessedWord;    // Загаданное слово в виде скрытого символа
    private static StringBuilder wrongLetters;   // Неправильно угаданные буквы
    private static StringBuilder trueLetters;    // Правильно угаданные буквы

    public static void start() {
        scanner = new Scanner(System.in);
        wrongLetters = new StringBuilder();
        trueLetters = new StringBuilder();

        secretWord = new WordRead().getRandomWord();
        guessedWord = new StringBuilder(HIDDENCHAR.repeat(secretWord.length()));

        while (attempts < MAX_ATTEMPTS && guessedWord.toString().contains(HIDDENCHAR)) {
            isLetterFound = false;

            System.out.println("Угадайте слово: " + guessedWord);

            enterChar();    // ввод буквы

            addChar();      // добавление буквы при правильном вводе

            checkChar();    // проверка буквы на повторный ввод и отсутствие

            System.out.print("Использованные неправильные буквы: " + wrongLetters);
            System.out.println("\n-----------------------------------------");
        }

        if (!guessedWord.toString().contains(HIDDENCHAR)) {
            System.out.println("Поздравляем, вы угадали слово: " + secretWord);
        } else {
            System.out.println("У вас закончились попытки. Загаданное слово было: " + secretWord);
        }
    }

    private static void enterChar() {
        System.out.print("Введите букву: ");
        userLetter = scanner.next().toUpperCase().charAt(0);
        while (!isRussianLetter(userLetter)) {
            System.out.print("Введите РУССКУЮ букву: ");
            userLetter = scanner.next().toUpperCase().charAt(0);
        }
    }

    private static void addChar() {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == userLetter) {
                guessedWord.setCharAt(i, userLetter);
                isLetterFound = true;
                trueLetters.append(userLetter);
            }
        }
    }

    private static void checkChar() {
        if (!isLetterFound) {
            if (wrongLetters.toString().contains(String.valueOf(userLetter))) {
                System.out.println("Ты уже вводил такую букву. Введи другую!");
                System.out.println("Осталось попыток: " + (MAX_ATTEMPTS - attempts));
                Gallows.printGallows(attempts);
            } else {
                attempts++;
                wrongLetters.append(userLetter).append(" ");
                System.out.println("Такой буквы нет. Осталось попыток: " + (MAX_ATTEMPTS - attempts));
                Gallows.printGallows(attempts);
            }
        }
    }

    private static boolean isRussianLetter(char ch) {
        return Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.CYRILLIC;
    }
}