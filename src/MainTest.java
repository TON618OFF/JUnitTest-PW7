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
    @DisplayName("Тест метода maxDiagonalSum: базовый случай")
    void testMaxDiagonalSum() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(15, Main.maxDiagonalSum(matrix));
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
    @DisplayName("Тест метода extractFirstLettersToUpperCase: параметризованный")
    void testExtractFirstLettersToUpperCase(String input, String expected) {
        assertEquals(expected, Main.extractFirstLettersToUpperCase(input));
    }

    @Test
    @DisplayName("Тест метода extractFirstLettersToUpperCase: исключения")
    void testExtractFirstLettersToUpperCaseExceptions() {
        assertThrows(IllegalArgumentException.class, () -> Main.extractFirstLettersToUpperCase(""));
        assertThrows(IllegalArgumentException.class, () -> Main.extractFirstLettersToUpperCase(null));
    }
}
