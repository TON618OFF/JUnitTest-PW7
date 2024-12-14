import java.util.Arrays;

public class Main {

    // Метод 1: Найти слово, где больше всего встречается буква "И"
    public static String findWordWithMostI(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Предложение не может быть пустым");
        }
        String[] words = sentence.split("\\s+");
        return Arrays.stream(words)
                .max((a, b) -> Long.compare(
                        a.chars().filter(ch -> ch == 'И' || ch == 'и').count(),
                        b.chars().filter(ch -> ch == 'И' || ch == 'и').count()
                ))
                .orElse("");
    }

    // Метод 2: Найти наибольшую сумму по диагоналям
    public static int maxDiagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }

        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += matrix[i][i];
            secondaryDiagonalSum += matrix[i][n - i - 1];
        }

        return Math.max(primaryDiagonalSum, secondaryDiagonalSum);
    }


    // Метод 3: Вернуть строку из первых букв слов в верхнем регистре
    public static String extractFirstLettersToUpperCase(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        StringBuilder result = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        return result.toString();
    }
}
