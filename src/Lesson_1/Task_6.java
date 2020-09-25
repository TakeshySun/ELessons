package Lesson_1;

import java.util.Arrays;

/*
Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.
Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
 */
public class Task_6 {
    public static void main(String[] args) {
        int[] randomArray = new int[10];

        min(randomArray);
        max(randomArray);
        midle(randomArray);

    }

    static void min(int[] incomeArray){

        for (int i = 0; i < incomeArray.length; i++) {
            int randomValue = (int) (Math.random() * 200);
            incomeArray[i] = randomValue;
        }
        Arrays.sort(incomeArray);
        System.out.println("Array is: " + Arrays.toString(incomeArray));
        System.out.println("Max value is: " + incomeArray[0]);
    }

    static void midle(int[] incomeArray){
        double arraySum = 0;

        for (int i = 0; i < incomeArray.length; i++) {
            int randomValue = (int) (Math.random() * 200);
            incomeArray[i] = randomValue;
            int valueInArray = incomeArray[i];
            arraySum = (arraySum + valueInArray);
        }
        double result = arraySum / 10;
        System.out.println("Array is: " + Arrays.toString(incomeArray));
        System.out.println("Midle value is: " + result);
    }

    static void max(int[] incomeArray){
        for (int i = 0; i < incomeArray.length; i++) {
            int randomValue = (int) (Math.random() * 200);
            incomeArray[i] = randomValue;
        }
        Arrays.sort(incomeArray);
        System.out.println("Array is: " + Arrays.toString(incomeArray));
        System.out.println("Min value is: " + incomeArray[9]);
    }
}
