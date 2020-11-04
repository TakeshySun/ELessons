package javaOop.Lesson_3;
/*
Написати метод, який на вхід принімає колекцію обєктів V (Generic),
в якій є дублючі обєкти,
а вертає колекцію V вже без дублікатів.
 */

import java.util.*;


public class Task_2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("q", "q", "d", "f", "d");
        System.out.println(removeDuplicateFromCollection(list));
        List<?> list2 = Arrays.asList(1,2,3,4,4,5,5,6,6);
        System.out.println(removeDuplicateFromCollection(list2));
    }

    public static <T> Collection<T> removeDuplicateFromCollection(Collection<T> v){
        return new TreeSet<>(v);
    }
}
