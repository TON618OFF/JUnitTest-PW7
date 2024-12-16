import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
        System.out.println("Начало теста");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Завершение теста");
    }

    @Test
    @DisplayName("Тест метода findWordWithMostI: базовый случай")
    void testFindWordWithMostI() {
        assertEquals("информация", Main.findWordWithMostI("Эта информация будет полезна"));
        assertEquals("и", Main.findWordWithMostI("и это всё"));
    }

    @Test
    @DisplayName("Тест метода findWordWithMostI: исключения")
    void testFindWordWithMostIExceptions() {
        assertThrows(IllegalArgumentException.class, () -> Main.findWordWithMostI(""));
        assertThrows(IllegalArgumentException.class, () -> Main.findWordWithMostI(null));
    }

    @Test
    @Disabled("Тест отключён из-за долгого выполнения")
    @DisplayName("Тест метода findWordWithMostI: долгий ввод")
    void testFindWordWithMostILongInput() {
        String input = "и ".repeat(10_000) + "информация";
        assertTimeout(Duration.ofSeconds(1), () -> {
            assertEquals("информация", Main.findWordWithMostI(input));
        });
    }

    @Test
    @DisplayName("Тест метода maxDiagonalSum: сравнение диагоналей")
    void testMaxDiagonalSumComparison() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int primaryDiagonalSum = Main.calculatePrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = Main.calculateSecondaryDiagonalSum(matrix);
        int expectedMax = Math.max(primaryDiagonalSum, secondaryDiagonalSum);

        int result = Main.maxDiagonalSum(matrix);

        System.out.println("Сумма главной диагонали: " + primaryDiagonalSum);
        System.out.println("Сумма побочной диагонали: " + secondaryDiagonalSum);
        System.out.println("Наибольшая сумма диагоналей: " + result);

        assertEquals(expectedMax, result);
    }



    @Test
    @DisplayName("Test exceptions in maxDiagonalSum method")
    void testMaxDiagonalSumExceptions() {
        int[][] nonSquareMatrix = {{1}, {2, 3}};
        int[][] nullMatrix = null;
        int[][] emptyMatrix = {};

        assertThrows(IllegalArgumentException.class, () -> Main.maxDiagonalSum(nonSquareMatrix));
        assertThrows(IllegalArgumentException.class, () -> Main.maxDiagonalSum(nullMatrix));
        assertThrows(IllegalArgumentException.class, () -> Main.maxDiagonalSum(emptyMatrix));
    }

    @ParameterizedTest
    @CsvSource({
            "'привет мир добро', ПМД",
            "'А Б В', АБВ",
            "'один', О",
            "'два слова', ДС"
    })
    @DisplayName("Тест метода extractFirstLettersToUpperCase: параметризованный с выводом")
    void testExtractFirstLettersToUpperCase(String input, String expected) {
        String result = Main.extractFirstLettersToUpperCase(input);
        System.out.println("Входная строка: \"" + input + "\"");
        System.out.println("Ожидаемый результат: \"" + expected + "\"");
        System.out.println("Фактический результат: \"" + result + "\"");
        assertEquals(expected, result);
    }


    @Test
    @DisplayName("Тест метода extractFirstLettersToUpperCase: исключения")
    void testExtractFirstLettersToUpperCaseExceptions() {
        assertThrows(IllegalArgumentException.class, () -> Main.extractFirstLettersToUpperCase(""));
        assertThrows(IllegalArgumentException.class, () -> Main.extractFirstLettersToUpperCase(null));
    }
}
