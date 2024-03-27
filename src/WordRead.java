import java.io.*;
import java.util.*;


class WordRead {
    private final File FILE = new File("src\\resourses\\word.txt"); // Имя вашего файла
    private List<String> words = new ArrayList<>();
    private String randomWord = null;

    String getRandomWord() {
        try (Scanner scanner = new Scanner(FILE)) {

            // Считываем все слова из файла
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }

            if (!words.isEmpty()) {
                Random random = new Random();
                randomWord = words.get(random.nextInt(words.size()));
            } else {
                System.out.println("Файл пустой или не содержит слов.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }

        return randomWord.toUpperCase();
    }
}
