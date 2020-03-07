

import java.util.NoSuchElementException;
import java.util.Scanner;

class HomeWork2 {
    public static void main(String[] args) {
        String inputData = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        try {
            System.out.println(getSumOfArray(putIntoArray(inputData)));
        } catch (NoSuchElementException e) {
            System.out.println("Исходная матрица меньше 4х4");
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Исходная матрица больше 4х4");
            System.out.println(e.getClass().getName() + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Неверные преобразуемые данные");
            System.out.println(e.getClass().getName() + e.getMessage());
        }
    }

    /**
     * Метод преобразования переданнной строки в двумерный массив
     * @param inputData - преобразуемая строка
     * @return - двумерный массив
     * @throws NoSuchElementException  произойдет если не хватит элементов заполнить массив
     * @throws ArrayIndexOutOfBoundsException  произойдет если элементов больше чем размерность массива
     */
    private static String[][] putIntoArray(String inputData) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
        final int SIZE = 4;                                     //Размерность массива
        String[][] arrayData = new String[SIZE][SIZE];
        int countI = 0;
        int countJ = 0;
        String groupElem;

        Scanner scanSubString = new Scanner(inputData);         //Передадим исходную строку в сканер

        while (countI < SIZE || scanSubString.hasNext()) {      //Пока не заполнили массив и есть еще строки - получаем подстроку
            groupElem = scanSubString.nextLine();
            Scanner scannerElem = new Scanner(groupElem);       //Передаем полученную подстроку в сканер

            while (countJ < SIZE || scannerElem.hasNext()) {    //Пока есть что то в подстроке - получаем
                arrayData[countI][countJ] = scannerElem.next(); //Полученное хитро помещаем в двумерный архив
                countJ++;
            }
            countJ = 0;                                          //Операции со счеткиком индекса архива
            countI++;
        }
        return arrayData;                                        //Возвращаем полученный архив
    }

    /**
     * Метод преобразования строковых значений массива в целые числа с последующим суммированием и делением на 2
     * @param array - строковый двумерный массив
     * @return сумма чисел массива / 2
     * @throws NumberFormatException может произвойьи если попадется не цифра
     */
    private static float getSumOfArray(String[][] array) throws NumberFormatException {
        int size = array.length;  //Добавим универсальности
        float result = 0;

        for (int i = 0; i < size * size; i++) {
            result += Integer.parseInt(array[i / size][i % size]); //Суммируем массив
        }
        return result / 2;
    }
}


