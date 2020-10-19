package Lesson_3;

import java.util.HashMap;
import java.util.Map;

/*
Побудувати частотний словник букв алфавіту. Створити метод, який принімає текс і вертає словник,
в якиму міститься символ
і його кількість.

Приклад: ollo
o - 2
l - 2

Текст взяти свій
 */
public class Task_1 {

    public static void main(String[] args) {
        System.out.println(counterDictionary("olloiLlkbuksfKHDI:JLSDFhisfhglmsdfg"));
    }

    public static Map<Character, Integer> counterDictionary(String value){
        Map<Character, Integer> myMap = new HashMap<>();

        for (int i = 0; i<value.length()-1; i++){
            char key = 0;
            int counter = 0;
            for (int n = 0; n<value.length(); n++){
                if(value.charAt(i) == value.charAt(n)){
                    counter = counter +1;
                    key = value.charAt(i);
                }
            }
            myMap.put(key, counter);
        }


        return myMap;
    }
}
