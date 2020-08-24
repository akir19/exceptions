package Lesson_2.exceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public void info() {
        System.out.println("Размер массива не совпадает с заявленным!");
    }
}
