#!/bin/bash

# Путь к исходным файлам
MAIN_DIR="src"
MODEL_DIR="src/calc/model"
CONTROLLER_DIR="src/calc/controller"
VIEW_DIR="src/calc/view"
EXCEPTION_DIR="src/calc/exceptions"
CLASS_DIR="build"

# Создаем папку для скомпилированных файлов
rm -rf $CLASS_DIR
mkdir -p $CLASS_DIR

# Компилируем Java-файлы
javac -d $CLASS_DIR $MODEL_DIR/*.java $CONTROLLER_DIR/*.java $VIEW_DIR/*.java  $EXCEPTION_DIR/*.java  $MAIN_DIR/*.java

# Проверяем, успешно ли скомпилировалось
if [ $? -eq 0 ]; then
    echo "Компиляция успешна! Вывод программы:"

    # Запускаем приложение
    java -cp $CLASS_DIR Main
else
    echo "Ошибка компиляции!"
fi