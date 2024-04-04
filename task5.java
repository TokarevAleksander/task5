import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task_5 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\test_5.txt";

        // Создание коллекции для хранения слов и их частот
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try {
            // Чтение файла и подсчёт частот слов
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
            reader.close();

            // Сортировка слов в алфавитном порядке
            List<String> sortedWords = new ArrayList<>(wordFrequencyMap.keySet());
            Collections.sort(sortedWords);

            for (String word : sortedWords) {
                System.out.println(word + ": " + wordFrequencyMap.get(word));
            }

            // Нахождение слова с максимальным количеством повторений
            int maxFrequency = 0;
            String mostFrequentWord = null;
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                if (entry.getValue() > maxFrequency) {
                    maxFrequency = entry.getValue();
                    mostFrequentWord = entry.getKey();
                }
            }

            System.out.println("Слово с максимальным количеством повторений:");
            System.out.println(mostFrequentWord + ": " + maxFrequency);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}
