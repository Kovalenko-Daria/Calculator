# Calculator

Java-калькулятор с графическим интерфейсом (GUI), реализованный с использованием архитектуры MVC (Model-View-Controller).

## Структура проекта

```
src/
├── Main.java                    # Точка входа приложения
└── calc/
    ├── model/                   # Бизнес-логика
    │   ├── Calculator.java      # Основной класс калькулятора
    │   ├── Expression.java      # Работа с выражениями
    │   ├── ExpressionPart.java  # Часть выражения
    │   ├── NumberExpression.java # Числовое выражение
    │   ├── Operation.java       # Операции
    │   └── CalculatedAnswer.java # Результат вычислений
    ├── view/                    # Пользовательский интерфейс
    │   └── GUIView.java         # Графический интерфейс
    ├── controller/              # Контроллеры
    │   ├── CalculateExpression.java  # Вычисление выражений
    │   └── ExpressionParse.java      # Парсинг выражений
    └── exceptions/              # Исключения
```

## Требования

- Java JDK 8 или выше
- Bash (для использования build.sh)

## Сборка и запуск

### С помощью build.sh

```bash
chmod +x build.sh
./build.sh
```

### Вручную

```bash
# Компиляция
mkdir -p build
javac -d build src/calc/model/*.java src/calc/controller/*.java src/calc/view/*.java src/calc/exceptions/*.java src/Main.java

# Запуск
java -cp build Main
```

## Архитектура

Проект следует паттерну **MVC (Model-View-Controller)**:

- **Model** — логика вычислений и работа с математическими выражениями
- **View** — графический интерфейс пользователя (GUIView)
- **Controller** — обработка действий пользователя и связь между моделью и представлением

## Лицензия

Учебный проект.
