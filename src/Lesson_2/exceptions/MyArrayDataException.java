package Lesson_2.exceptions;

public class MyArrayDataException extends NumberFormatException {
    public void info(String errorCell) {
        System.out.println("Суммировать все элементы массива не удалось !\n" +
                "Ошибка преобразования в ячейке массива " + errorCell);
    }
}
