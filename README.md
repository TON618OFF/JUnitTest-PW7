# Задача: Создание программы на Java с тестированием JUnit5

## Условия
- При тестировании необходимо использовать **JUnit5**.
- Использовать аннотации и методы тестирования из прикрепленного материала.
- Весь прикрепленный материал изучить и выучить.

## Функции для реализации и тестирования
1. **Найти слово, в котором больше всего встречается буква "И".**  
   В метод передается предложение (не слово).

2. **Найти в двухмерном массиве сумму значений по диагоналям, сравнить и вывести наибольшую сумму.**

3. **Создать метод, который принимает строку из слов и возвращает строку, состоящую из первых букв этих слов, переведенных в верхний регистр.**

## Требования
- Количество тестов не ограничено.

## Прикрепленный материал

### Аннотации JUnit5

- **@BeforeEach**  
  Описание: Аннотация, указывающая, что метод должен быть выполнен перед каждым тестом. Используется для подготовки общих данных или объектов, необходимых для всех тестов.

- **@AfterEach**  
  Описание: Выполняет метод после каждого теста. Применяется для очистки ресурсов или завершения действий после каждого теста.

- **@Disabled**  
  Описание: Аннотация для временного отключения теста. Используется, если тест не должен выполняться, например, из-за незавершенной реализации.

- **@DisplayName**  
  Описание: Позволяет задать читаемое имя для теста, отображающееся при запуске, чтобы улучшить читаемость отчетов о тестировании.

- **@ParameterizedTest**  
  Описание: Позволяет запускать один и тот же тест с различными входными данными. Используется для проверки методов, принимающих множество вариантов входных данных.

- **@CsvSource**  
  Описание: Указывает набор входных данных для параметризованного теста в формате CSV.

### Методы проверки

- **assertTimeout**  
  Проверяет, что выполнение блока кода завершается за установленное время. Если время превышено, тест завершится с ошибкой.

- **assertThrows**  
  Проверяет, что выполнение блока кода вызывает ожидаемое исключение.
