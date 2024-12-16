import java.util.Arrays;

public class Main {

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

    public static int calculatePrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int calculateSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - i - 1];
        }
        return sum;
    }

    public static int maxDiagonalSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Матрица не может быть пустой или нулевой");
        }

        int n = matrix.length;
        for (int[] row : matrix) {
            if (row.length != n) {
                throw new IllegalArgumentException("Матрица должна быть квадратной");
            }
        }

        int primaryDiagonalSum = calculatePrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = calculateSecondaryDiagonalSum(matrix);

        return Math.max(primaryDiagonalSum, secondaryDiagonalSum);
    }


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
