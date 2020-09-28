package Lesson_1;

import java.util.Arrays;

/**
 * Write a Java program to find the duplicate values of an array of integer values.
 * <p>
 * Create array with duplicated numbers.
 **/

public class Task_3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 7, 9, 9};
        printDuplicate(arr);
    }

    static void printDuplicate(int[] array) {
        for (int original = 0; original < array.length; original++) {
            for (int second = original + 1; second < array.length; second++) {
                if (array[original] == array[second]) {
                    System.out.println("Duplicate is: " + array[second]);
                    }
                }
            }
        }
    }










