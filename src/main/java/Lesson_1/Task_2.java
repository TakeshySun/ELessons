package Lesson_1;

import java.util.Random;

/**
 * Write a Java program to sum values of an array.
 * 1.Create array with your data (integer)
 * 2.Create array with random data (integer)
 * 3.Create array with random data (integer and string) Do not do!
 **/

public class Task_2 {
    public static void main(String[] args) {
        System.out.println("sum: " + sumMyArray());
        System.out.println("sum: " + sumRandomInt());
    }

    //   1)
    static int sumMyArray() {
        int[] myArray = {1, 2, 3, 4, 5};
        int sum = 0;
//        for (int i:myArray) {
//            int x = sum+=i;
//        }
//        return sum;
        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        return sum;
    }

    //   2)
    static int sumRandomInt() {
        int[] randomArrays = new int[5];
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < randomArrays.length; i++) {
            randomArrays[i] = random.nextInt(10);
            sum += randomArrays[i];
        }
        return sum;
    }

    //   3)
    static void sumRandIntStr() {

    }


}

