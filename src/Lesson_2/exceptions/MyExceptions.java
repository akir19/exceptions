package Lesson_2.exceptions;

import static java.lang.Integer.parseInt;

public class MyExceptions {
    private int arraySize;
    private String[][] array;
    private int arraySum = 0;
    private String errorCell = "";

    private int getArrayLength() { // вернет количество элементов главного массива, неважно квадратный он или нет
        int numbers = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) numbers++;
        return numbers;
    }

    private int getArraySum() {
        return arraySum;
    }

    public MyExceptions(String[][] array, int arraySize) {
        this.array = array;
        this.arraySize = arraySize;
    }

    public static void main(String[] args) {

        String[][] mass = { {"1", "2", "3", "4"},
                            {"1", "2", "3", "4"},
                            {"1", "2", "3", "s4"},  //тут введено неправильное число s4 для проверки работы исключения. Убрать s для правильной работы
                            //{"1", "2", "3", "4"}, //добавление лишнего элемента в массив. Раскомментировать для проверки работы исключения
                            {"1", "2", "3", "4"}
        };

        MyExceptions obj = new MyExceptions(mass, 4); //размерность массива задается здесь и может быть любой. По заданию массив квадратный 4х4

        try {
            obj.arrayCheck(mass);
        } catch (MyArraySizeException e) {
            e.info();
        } catch (MyArrayDataException e) {
            e.info(obj.errorCell);
        }

        if (obj.errorCell.isEmpty())
            System.out.println("Сумма элементов массива " +
                                obj.arraySize + "х" + obj.arraySize+ " = " + obj.getArraySum());

    }

    private void arrayCheck(String[][] mass) throws MyArrayDataException, MyArraySizeException {

        if (arraySize * arraySize != getArrayLength()) throw new MyArraySizeException();

        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                try {
                    arraySum += parseInt(mass[i][j]);
                } catch (NumberFormatException e) {
                    errorCell = "[" + (i + 1) + "," + (j + 1) + "]";  //к индексам добавляется 1, т.к. для человека элементы массива нумеруются с единицы
                    throw new MyArrayDataException();
                }
            }
        }
    }
}
