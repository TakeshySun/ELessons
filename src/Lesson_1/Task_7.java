package Lesson_1;

import java.util.Arrays;

/*
Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
 */
public class Task_7 {
    public static void main(String[] args) {
        int[] arr = new int[101];
        int x;
        for (int i = 2; i < arr.length; i++)
        {
            boolean f = true;
            arr[i]=i;
            x = arr[i];
            for(int p = 2; p < x;p++)
            {

                if (x%p==0){
                    f = false;
                    break;
                }

            }
            if (f)System.out.println("Prostoe: " + x);

        }
    }
    }

