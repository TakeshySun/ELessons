package Lesson_1;

import java.util.Arrays;

/*
Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
 */
public class Task_7 {
    public static void main(String[] args) {

        for (int i = 2; i < 101; i++)
        {
            boolean isSimple = true;
            for(int p = 2; p < i;p++)
            {

                if (i%p==0){
                    isSimple = false;
                    break;
                }
            }
            if (isSimple)System.out.println("Prostoe: " + i);
        }
    }
    }

